package com.czk.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.czk.domain.BaseDict;
import com.czk.domain.Customer;
import com.czk.domain.QueryVo;
import com.czk.service.CustomerService;
import com.czk.service.DictService;
import com.czk.utils.Page;
import com.czk.websocket.MyHandler;

@Controller
@RequestMapping("/customer")
public class CustomerAction {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private MyHandler myHandler;
	
	@Autowired
	private DictService dictService;
	
	@RequestMapping("/list")
	public String getCustomerList(QueryVo queryVo,Model model) throws IOException{
		try {
			// 解决get请求乱码问题
			if (StringUtils.isNotBlank(queryVo.getCustName())) {
				queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		//客户来源
		List<BaseDict> fromType = dictService.findDictByTypeCode("002");
		//所属行业
		List<BaseDict> industryType = dictService.findDictByTypeCode("001");
		//客户级别
		List<BaseDict> levelType = dictService.findDictByTypeCode("006");
		
		
		List<Customer> list = customerService.findAllCustomer();
		model.addAttribute("fromType",fromType);
		model.addAttribute("industryType",industryType);
		model.addAttribute("levelType",levelType);
		
		
		Page<Customer> page = this.customerService.queryCustomerByQueryVo(queryVo);
		// 把分页查询的结果放到模型中
		model.addAttribute("page", page);

		// 数据回显
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());
		int i = page.getTotal()/page.getSize();
		return "index";
	}
	/***
	 * 根据id查询
	 * @param id
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Customer edit(@RequestParam("id") Long id) throws IOException{
		Customer customer = customerService.queryCuestomerById(id);
		myHandler.sendMessage("编辑了 "+id);
		return customer;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Customer customer){
		customerService.updateCustomerById(customer);
		return "ok";
	}
	
	@RequiresPermissions("customer:findAll")
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll(String id){
		List<Customer> list = customerService.findAllCustomer();
		return list;
		
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Long id){
		customerService.deletetById(id);
		return "ok";
		
	}
	
	@RequestMapping("/c1")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file){
		System.out.println(file);
		try {
			file.transferTo(new File("e:/123.jsp"));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@RequestMapping("/c2")
	@ResponseBody
	public String c2(@RequestParam("name")String name,@RequestParam("sex")String sex){
		System.out.println("name="+name);
		System.out.println("sex="+sex);
		return null;
		
	}
	
}
