package com.dyh.transaction.api.bean;

import com.dyh.transaction.api.enums.GlobalTransactionProcessExpectedStatusEnum;
import com.dyh.transaction.api.enums.GlobalTransactionProcessStatus;

/**
 * Created by dengyunhui on 2017/11/29 21:37.
 */
public class GlobalTransactionProcess {

    /**
     *
     **/
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    /**
     *
     **/
    private Integer transactionId;

    public Integer getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }


    /**
     *
     **/
    private Integer transactionSequence;

    public Integer getTransactionSequence() {
        return this.transactionSequence;
    }

    public void setTransactionSequence(Integer transactionSequence) {
        this.transactionSequence = transactionSequence;
    }


    /**
     *
     **/
    private GlobalTransactionProcessStatus status;

    public GlobalTransactionProcessStatus getStatus() {
        return status;
    }

    public void setStatus(GlobalTransactionProcessStatus status) {
        this.status = status;
    }

    public GlobalTransactionProcessExpectedStatusEnum getExpectedStatus() {
        return expectedStatus;
    }

    public void setExpectedStatus(GlobalTransactionProcessExpectedStatusEnum expectedStatus) {
        this.expectedStatus = expectedStatus;
    }

    /**
     *
     **/
    private GlobalTransactionProcessExpectedStatusEnum expectedStatus;



    /**
     *
     **/
    private String serviceName;

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


    /**
     *
     **/
    private String versionName;

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }


    /**
     *
     **/
    private String methodName;

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }


    /**
     *
     **/
    private String rollbackMethodName;

    public String getRollbackMethodName() {
        return this.rollbackMethodName;
    }

    public void setRollbackMethodName(String rollbackMethodName) {
        this.rollbackMethodName = rollbackMethodName;
    }


    /**
     *
     **/
    private String requestJson;

    public String getRequestJson() {
        return this.requestJson;
    }

    public void setRequestJson(String requestJson) {
        this.requestJson = requestJson;
    }


    /**
     *
     **/
    private String responseJson;

    public String getResponseJson() {
        return this.responseJson;
    }

    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson;
    }


    /**
     * @datatype(name="date")
     **/
    private Integer redoTimes;

    public Integer getRedoTimes() {
        return this.redoTimes;
    }

    public void setRedoTimes(Integer redoTimes) {
        this.redoTimes = redoTimes;
    }


    /**
     * @datatype(name="date")
     **/
    private java.util.Date nextRedoTime;

    public java.util.Date getNextRedoTime() {
        return this.nextRedoTime;
    }

    public void setNextRedoTime(java.util.Date nextRedoTime) {
        this.nextRedoTime = nextRedoTime;
    }


    /**
     * @datatype(name="date")
     **/
    private java.util.Date createdAt;

    public java.util.Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(java.util.Date createdAt) {
        this.createdAt = createdAt;
    }


    /**
     * @datatype(name="date")
     **/
    private java.util.Date updatedAt;

    public java.util.Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(java.util.Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}