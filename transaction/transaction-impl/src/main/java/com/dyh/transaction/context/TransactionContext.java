package com.dyh.transaction.context;

/**
 * Created by dengyunhui on 2017/12/4 13:18.
 */
public class TransactionContext {

    private Integer seqId;

    private int failedTimes = 0;

    private boolean isSoaTransactionProcess;

    private boolean isSoaGlobalTransactional;

    private Integer currentTransactionSequence = 0;

    private Integer transactionId = 0;

    public Integer getSeqId() {
        return seqId;
    }

    public void setSeqId(Integer seqId) {
        this.seqId = seqId;
    }

    public int getFailedTimes() {
        return failedTimes;
    }

    public void setFailedTimes(int failedTimes) {
        this.failedTimes = failedTimes;
    }

    public boolean isSoaTransactionProcess() {
        return isSoaTransactionProcess;
    }

    public void setSoaTransactionProcess(boolean soaTransactionProcess) {
        isSoaTransactionProcess = soaTransactionProcess;
    }

    public boolean isSoaGlobalTransactional() {
        return isSoaGlobalTransactional;
    }

    public void setSoaGlobalTransactional(boolean soaGlobalTransactional) {
        isSoaGlobalTransactional = soaGlobalTransactional;
    }

    public Integer getCurrentTransactionSequence() {
        return currentTransactionSequence;
    }

    public void setCurrentTransactionSequence(Integer currentTransactionSequence) {
        this.currentTransactionSequence = currentTransactionSequence;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }
}