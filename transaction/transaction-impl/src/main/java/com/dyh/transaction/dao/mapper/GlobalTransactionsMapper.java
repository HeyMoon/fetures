package com.dyh.transaction.dao.mapper;

import com.dyh.transaction.dao.model.GlobalTransactions;

public interface GlobalTransactionsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_transactions
     *
     * @mbg.generated Tue Dec 05 13:47:12 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_transactions
     *
     * @mbg.generated Tue Dec 05 13:47:12 CST 2017
     */
    int insert(GlobalTransactions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_transactions
     *
     * @mbg.generated Tue Dec 05 13:47:12 CST 2017
     */
    int insertSelective(GlobalTransactions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_transactions
     *
     * @mbg.generated Tue Dec 05 13:47:12 CST 2017
     */
    GlobalTransactions selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_transactions
     *
     * @mbg.generated Tue Dec 05 13:47:12 CST 2017
     */
    int updateByPrimaryKeySelective(GlobalTransactions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_transactions
     *
     * @mbg.generated Tue Dec 05 13:47:12 CST 2017
     */
    int updateByPrimaryKey(GlobalTransactions record);
}