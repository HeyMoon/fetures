package com.dyh.transaction.api.bean;

import com.dyh.transaction.api.enums.GlobalTransactionsStatus;

/**
 * Created by dengyunhui on 2017/11/29 21:37.
 */
public class GlobalTransaction {
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
    private GlobalTransactionsStatus status;

    public GlobalTransactionsStatus getStatus() {
        return status;
    }

    public void setStatus(GlobalTransactionsStatus status) {
        this.status = status;
    }

    /**
     *
     **/
    private Integer currSequence;

    public Integer getCurrSequence() {
        return this.currSequence;
    }

    public void setCurrSequence(Integer currSequence) {
        this.currSequence = currSequence;
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