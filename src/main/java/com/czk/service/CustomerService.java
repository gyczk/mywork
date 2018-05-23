package com.czk.service;

import java.util.List;

import com.czk.domain.Customer;
import com.czk.domain.QueryVo;
import com.czk.utils.Page;

public interface CustomerService {

	List<Customer> findAllCustomer();
	
	Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);

	Customer queryCuestomerById(Long id);
	
	void updateCustomerById(Customer customer);

	void deletetById(Long id);
}
