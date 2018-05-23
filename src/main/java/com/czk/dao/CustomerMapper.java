package com.czk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.czk.domain.Customer;
import com.czk.domain.CustomerExample;
import com.czk.domain.QueryVo;

public interface CustomerMapper {
	int countByExample(CustomerExample example);

	int deleteByExample(CustomerExample example);

	int deleteByPrimaryKey(Long custId);

	int insert(Customer record);

	int insertSelective(Customer record);

	List<Customer> selectByExample(CustomerExample example);

	Customer selectByPrimaryKey(Long custId);

	int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

	int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

	int updateByPrimaryKeySelective(Customer record);

	int updateByPrimaryKey(Customer record);

	List<Customer> queryCustomerByQueryVo(QueryVo queryVo);

	int queryCountByQueryVo(QueryVo queryVo);
}