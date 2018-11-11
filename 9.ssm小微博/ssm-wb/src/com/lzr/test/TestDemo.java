package com.lzr.test;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzr.pojo.Adminuser;
import com.lzr.pojo.Page;
import com.lzr.pojo.QueryVo;
import com.lzr.service.AdminuserService;

public class TestDemo {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	AdminuserService adminuserService = (AdminuserService) ac.getBean("adminuserService");

	/*
	 * 用户注册
	 */
	@Test
	public void register() {
		Adminuser user = new Adminuser("1","m","123","1",new Date(),"0");
		Integer register = adminuserService.register(user );
		System.out.println(register);
	}

	/*
	 * 用户登录
	 */
	@Test
	public void login() {
		Adminuser user = new Adminuser("1","1");
		Adminuser login = adminuserService.login(user);
		System.out.println(login);
	}
	
	/*
	 * 查询所有用户
	 */
	@Test
	public void fans() {
		QueryVo vo = new QueryVo();
		vo.setName("1");
		vo.setPage(1);
//		vo.setSize(3);
		vo.setStartRow(0);
		Page<Adminuser> findAllUser = adminuserService.findAllUser(vo);
		System.out.println(findAllUser);
		List<Adminuser> rows = findAllUser.getRows();
		for (Adminuser adminuser : rows) {
			System.out.println(adminuser);
		}
		
	}
	
}
