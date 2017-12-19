package com.dyh.transaction.api.service;

import com.dyh.transaction.api.bean.GlobalTransaction;
import com.dyh.transaction.api.enums.GlobalTransactionsStatus;

/**
 * Created by dengyunhui on 2017/11/29 21:42.
 */
public interface GlobalTransactionService {


    GlobalTransaction create(GlobalTransaction globalTransaction) throws Exception;


    Boolean update(Integer globalTransactionId, Integer currSequence, GlobalTransactionsStatus status) throws Exception;

}