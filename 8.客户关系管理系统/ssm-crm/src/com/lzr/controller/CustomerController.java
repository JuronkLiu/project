package com.lzr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzr.pojo.BaseDict;
import com.lzr.pojo.Customer;
import com.lzr.pojo.QueryVo;
import com.lzr.service.BaseDictService;
import com.lzr.service.CustomerService;
import com.lzr.utils.Page;


/**
 * 客户管理
 * @author lx
 *
 */
@Controller
public class CustomerController {

	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
//	//注入在成员变量上
//	// 客户来源
//	@Value("${CUSTOMER_FROM_TYPE}")
//	private String CUSTOMER_FROM_TYPE;
//	// 客户行业
//	@Value("${CUSTOMER_INDUSTRY_TYPE}")
//	private String CUSTOMER_INDUSTRY_TYPE;
//	// 客户级别
//	@Value("${CUSTOMER_LEVEL_TYPE}")
//	private String CUSTOMER_LEVEL_TYPE;
	
	
	//入口
	@RequestMapping(value = "/customer/list.action")
	public String list(QueryVo vo,Model model){
		
//		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(CUSTOMER_FROM_TYPE);
//		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(CUSTOMER_INDUSTRY_TYPE);
//		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(CUSTOMER_LEVEL_TYPE);
		
		
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode("002");
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		
		//通过四个条件  查询分页对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	//去修改页面
	@RequestMapping(value = "/customer/edit.action")
	public @ResponseBody
	Customer edit(Integer id){
		return customerService.selectCustomerById(id);
	}
	//修改保存
	@RequestMapping(value = "/customer/update.action")
	public @ResponseBody
	String update(Customer customer){
		//修改
		customerService.updateCustomerById(customer);
		return "OK";
	}
	//删除
	@RequestMapping(value = "/customer/delete.action")
	public @ResponseBody
	String delete(Integer id){
		//删除
		customerService.deleteCustomerById(id);
		return "OK";
	}
	
}
