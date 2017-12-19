package com.dyh.transaction.dao.mapper;

import com.dyh.transaction.dao.model.GlobalTransactionProcess;
import com.dyh.transaction.dao.model.GlobalTransactionProcessWithBLOBs;

public interface GlobalTransactionProcessMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_transaction_process
     *
     * @mbg.generated Tue Dec 05 13:47:12 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_transaction_process
     *
     * @mbg.generated Tue Dec 05 13:47:12 CST 2017
     */
    int insert(GlobalTransactionProcessWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_transaction_process
     *
     * @mbg.generated Tue Dec 05 13:47:12 CST 2017
     */
    int insertSelective(GlobalTransactionProcessWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_transaction_process
     *
     * @mbg.generated Tue Dec 05 13:47:12 CST 2017
     */
    GlobalTransactionProcessWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_transaction_process
     *
     * @mbg.generated Tue Dec 05 13:47:12 CST 2017
     */
    int updateByPrimaryKeySelective(GlobalTransactionProcessWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_transaction_process
     *
     * @mbg.generated Tue Dec 05 13:47:12 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(GlobalTransactionProcessWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_transaction_process
     *
     * @mbg.generated Tue Dec 05 13:47:12 CST 2017
     */
    int updateByPrimaryKey(GlobalTransactionProcess record);
}