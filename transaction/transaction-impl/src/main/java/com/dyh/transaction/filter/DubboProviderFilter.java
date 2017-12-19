package com.dyh.transaction.filter;

import com.alibaba.dubbo.rpc.*;
import com.alibaba.fastjson.JSONObject;
import com.dyh.transaction.api.annotation.GlobalTransactional;
import com.dyh.transaction.api.bean.GlobalTransaction;
import com.dyh.transaction.api.enums.GlobalTransactionsStatus;
import com.dyh.transaction.api.service.GlobalTransactionService;
import com.dyh.transaction.constants.Constants;
import com.dyh.transaction.context.TransactionContext;
import com.dyh.transaction.service.GlobalTransactionServiceImpl;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Objects;

/**
 * Created by dengyunhui on 2017/12/4 13:20.
 */
public class DubboProviderFilter implements Filter{
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

        GlobalTransactionService globalTransactionService = null;
        GlobalTransaction globalTransaction = null;
        TransactionContext context = null;
        boolean success = false;

        for (Method method : methods) {
            if (Objects.equals(methodName,method.getName())){
                boolean isGlobalTransaction = method.isAnnotationPresent(GlobalTransactional.class);

                if (isGlobalTransaction){
                    context = new TransactionContext();
                    context.setSoaGlobalTransactional(true);

                    globalTransaction = new GlobalTransaction();
                    globalTransaction.setCurrSequence(0);
                    globalTransaction.setCreatedAt(new Date());
                    globalTransaction.setStatus(GlobalTransactionsStatus.New);

                    globalTransactionService = new GlobalTransactionServiceImpl();
                    try {
                        GlobalTransaction result = globalTransactionService.create(globalTransaction);

                        context.setCurrentTransactionSequence(0);
                        context.setTransactionId(result.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    rpcInvocation.setAttachment(Constants.GLOBAL_TRANSACTION_KEY, JSONObject.toJSONString(context));
                }
            }
        }

        Result result = invoker.invoke(invocation);
        success = true;

        if (globalTransactionService != null && globalTransaction != null && context != null){
            try {
                globalTransactionService.update(globalTransaction.getId(), context.getCurrentTransactionSequence(), success ? GlobalTransactionsStatus.Success : GlobalTransactionsStatus.Fail);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
