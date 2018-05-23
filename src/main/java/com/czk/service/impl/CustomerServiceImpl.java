package com.czk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czk.dao.CustomerMapper;
import com.czk.domain.Customer;
import com.czk.domain.QueryVo;
import com.czk.service.CustomerService;
import com.czk.utils.Page;
@Service
public class CustomerServiceImpl  implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> list = customerMapper.selectByExample(null);
		return list;
	}
	@Override
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
		queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());
		List<Customer> list = customerMapper.queryCustomerByQueryVo(queryVo);
		int sum = customerMapper.queryCountByQueryVo(queryVo);
		
		Page<Customer> page = new Page<Customer>(sum,queryVo.getPage(),queryVo.getRows(),list);
		page.setTotal(sum);
		page.setRows(list);
		return page;
	}
	@Override
	public Customer queryCuestomerById(Long id) {
		Customer customer = customerMapper.selectByPrimaryKey(id);
		return customer;
	}
	@Override
	public void updateCustomerById(Customer customer) {
		customerMapper.updateByPrimaryKey(customer);
		
	}
	@Override
	public void deletetById(Long id) {
		customerMapper.deleteByPrimaryKey(id);
		
	}
	
	

}
