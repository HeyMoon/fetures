package com.dyh.transaction.service;

import com.dyh.transaction.api.bean.GlobalTransactionProcess;
import com.dyh.transaction.api.enums.GlobalTransactionProcessStatus;
import com.dyh.transaction.api.service.GlobalTransactionProcessService;
import com.dyh.transaction.dao.mapper.GlobalTransactionProcessMapper;
import com.dyh.transaction.dao.model.GlobalTransactionProcessWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dengyunhui on 2017/12/4 21:57.
 */
@Service
public class GlobalTransactionProcessServiceImpl implements GlobalTransactionProcessService {

    @Autowired
    private GlobalTransactionProcessMapper globalTransactionProcessMapper;

    /**
     * @param globalTransactionProcess
     */
    @Override
    public GlobalTransactionProcess create(GlobalTransactionProcess globalTransactionProcess) throws Exception {

        GlobalTransactionProcessWithBLOBs globalTransactionProcessWithBLOBs = new GlobalTransactionProcessWithBLOBs();
        globalTransactionProcessWithBLOBs.setRequestJson(globalTransactionProcess.getRequestJson());
        globalTransactionProcessWithBLOBs.setResponseJson(globalTransactionProcess.getResponseJson());
        globalTransactionProcessWithBLOBs.setCreatedAt(globalTransactionProcess.getCreatedAt());
        globalTransactionProcessWithBLOBs.setExpectedStatus((short)globalTransactionProcess.getExpectedStatus().getValue());
        globalTransactionProcessWithBLOBs.setMethodName(globalTransactionProcess.getMethodName());
        globalTransactionProcessWithBLOBs.setNextRetryTime(globalTransactionProcess.getNextRedoTime());
        globalTransactionProcessWithBLOBs.setRetryTimes(globalTransactionProcess.getRedoTimes());
        globalTransactionProcessWithBLOBs.setRollbackMethodName(globalTransactionProcess.getRollbackMethodName());
        globalTransactionProcessWithBLOBs.setServiceName(globalTransactionProcess.getServiceName());
        globalTransactionProcessWithBLOBs.setStatus((short)globalTransactionProcess.getStatus().getValue());
        globalTransactionProcessWithBLOBs.setTransactionId(globalTransactionProcess.getTransactionId());
        globalTransactionProcessWithBLOBs.setTransactionSequence(globalTransactionProcess.getTransactionSequence());
        globalTransactionProcessWithBLOBs.setUpdatedAt(globalTransactionProcess.getUpdatedAt());
        globalTransactionProcessWithBLOBs.setVersionName(globalTransactionProcess.getVersionName());

        globalTransactionProcessMapper.insertSelective(globalTransactionProcessWithBLOBs);

        globalTransactionProcess.setId(globalTransactionProcessWithBLOBs.getId());
        return globalTransactionProcess;
    }

    /**
     * @param globalTransactionProcessId
     * @param responseJson
     * @param status
     */
    @Override
    public void update(Integer globalTransactionProcessId, String responseJson, GlobalTransactionProcessStatus status) throws Exception {


        //globalTransactionProcessMapper.updateByPrimaryKeyWithBLOBs();
    }
}
