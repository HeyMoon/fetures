package com.dyh.transaction.api.service;

import com.dyh.transaction.api.bean.GlobalTransactionProcess;
import com.dyh.transaction.api.enums.GlobalTransactionProcessStatus;

/**
 * Created by dengyunhui on 2017/11/29 21:43.
 */
public interface GlobalTransactionProcessService {


    /**
     *
     **/
    GlobalTransactionProcess create(GlobalTransactionProcess globalTransactionProcess) throws Exception;

    /**
     *
     **/
    void update(Integer globalTransactionProcessId, String responseJson, GlobalTransactionProcessStatus status) throws Exception;

}