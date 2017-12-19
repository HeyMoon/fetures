package com.dyh.transaction.service;

import com.dyh.transaction.api.bean.GlobalTransaction;
import com.dyh.transaction.api.enums.GlobalTransactionsStatus;
import com.dyh.transaction.api.service.GlobalTransactionService;
import com.dyh.transaction.dao.mapper.GlobalTransactionsMapper;
import com.dyh.transaction.dao.model.GlobalTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dengyunhui on 2017/12/4 13:29.
 */
@Service
public class GlobalTransactionServiceImpl implements GlobalTransactionService {

    @Autowired
    private GlobalTransactionsMapper globalTransactionsMapper;

    @Override
    public GlobalTransaction create(GlobalTransaction globalTransaction) throws Exception {

        GlobalTransactions globalTransactions = new GlobalTransactions();
        globalTransactions.setCreatedAt(globalTransaction.getCreatedAt());
        globalTransactions.setCurrSequence(globalTransaction.getCurrSequence());
        globalTransactions.setStatus((short)globalTransaction.getStatus().getValue());

        globalTransactionsMapper.insertSelective(globalTransactions);

        globalTransaction.setId(globalTransactions.getId());
        return globalTransaction;
    }

    @Override
    public Boolean update(Integer globalTransactionId, Integer currSequence, GlobalTransactionsStatus status) throws Exception {

        //globalTransactionsMapper.updateByPrimaryKeySelective();

        return null;
    }
}
