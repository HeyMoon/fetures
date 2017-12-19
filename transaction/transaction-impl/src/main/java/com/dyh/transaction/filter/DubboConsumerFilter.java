package com.dyh.transaction.filter;

import com.alibaba.dubbo.rpc.*;
import com.alibaba.fastjson.JSONObject;
import com.dyh.transaction.api.annotation.TransactionProcess;
import com.dyh.transaction.api.bean.GlobalTransactionProcess;
import com.dyh.transaction.api.enums.GlobalTransactionProcessExpectedStatusEnum;
import com.dyh.transaction.api.enums.GlobalTransactionProcessStatus;
import com.dyh.transaction.api.service.GlobalTransactionProcessService;
import com.dyh.transaction.constants.Constants;
import com.dyh.transaction.context.TransactionContext;
import com.dyh.transaction.service.GlobalTransactionProcessServiceImpl;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Objects;

/**
 * Created by dengyunhui on 2017/12/4 13:19.
 */
public class DubboConsumerFilter implements Filter{
    /**
     * do invoke filter.
     * <p>
     * <code>
     * // before filter
     * Result result = invoker.invoke(invocation);
     * // after filter
     * return result;
     * </code>
     *
     * @param invoker    service
     * @param invocation invocation.
     * @return invoke result.
     * @throws RpcException
     * @see Invoker#invoke(Invocation)
     */
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Class interfaceClass = invoker.getInterface();
        String methodName = invocation.getMethodName();

        RpcInvocation rpcInvocation = (RpcInvocation) invocation;

        Method[] methods = interfaceClass.getMethods();

        GlobalTransactionProcessService globalTransactionProcessService = null;
        TransactionContext context = null;
        GlobalTransactionProcess transactionProcess = null;

        boolean success = false;
        boolean unknown = false;

        for (Method method : methods) {
            if (Objects.equals(methodName,method.getName())){
                boolean isTransactionProcess = method.isAnnotationPresent(TransactionProcess.class);

                if (isTransactionProcess){
                    String contextJson = rpcInvocation.getAttachment(Constants.GLOBAL_TRANSACTION_KEY);
                    if (contextJson != null){
                        context = (TransactionContext) JSONObject.parse(contextJson);

                        if (context != null){
                            boolean soaGlobalTransactional = context.isSoaGlobalTransactional();

                            if (soaGlobalTransactional){
                                transactionProcess =  new GlobalTransactionProcess();

                                transactionProcess.setCreatedAt(new Date());
                                transactionProcess.setExpectedStatus(GlobalTransactionProcessExpectedStatusEnum.Success);
                                transactionProcess.setMethodName(methodName);
                                transactionProcess.setNextRedoTime(new Date(new Date().getTime() + 30 * 1000));
                                transactionProcess.setRedoTimes(0);

                                Object[] arguments = rpcInvocation.getArguments();
                                transactionProcess.setRequestJson(JSONObject.toJSONString(arguments[0]));
                                transactionProcess.setResponseJson("");
                                transactionProcess.setRollbackMethodName(methodName + "_rollback");
                                transactionProcess.setServiceName(interfaceClass.getName());
                                transactionProcess.setStatus(GlobalTransactionProcessStatus.New);
                                transactionProcess.setTransactionId(context.getTransactionId());
                                transactionProcess.setTransactionSequence(context.getCurrentTransactionSequence() + 1);
                                transactionProcess.setVersionName("");

                                context.setCurrentTransactionSequence(context.getCurrentTransactionSequence() + 1);
                                rpcInvocation.setAttachment(Constants.GLOBAL_TRANSACTION_KEY,JSONObject.toJSONString(context));

                                globalTransactionProcessService = new GlobalTransactionProcessServiceImpl();
                                try {
                                    globalTransactionProcessService.create(transactionProcess);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }

        Result result = null;
        try {
            result = invoker.invoke(invocation);
            success = true;
        }catch (RpcException e){
            unknown = true;
        }catch (Exception e){
            unknown = false;
        }
        finally {
            if (transactionProcess != null && globalTransactionProcessService != null && context != null){
                final GlobalTransactionProcessStatus status = success ? GlobalTransactionProcessStatus.Success : (unknown ? GlobalTransactionProcessStatus.Unknown : GlobalTransactionProcessStatus.Fail);

                if (transactionProcess.getId() != null) {
                    try {
                        globalTransactionProcessService.update(transactionProcess.getId(), result == null ? "" : JSONObject.toJSONString(result), status);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return result;
    }
}
