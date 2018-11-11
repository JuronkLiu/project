package com.lzr.test;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lzr.pojo.User;
import com.lzr.pojo.ZhangWu;
import com.lzr.service.UserService;
import com.lzr.service.ZhangWuService;

public class TestDemo {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserService userService = (UserService) ac.getBean("userService");
	ZhangWuService zhangWuService = (ZhangWuService) ac.getBean("zhangWuService");
	
	@Test
	public void findUserById() {
		User findUserById = userService.findUserById(1);
		System.out.println(findUserById);
	}
	
	@Test
	public void queryAll() {
		List<ZhangWu> queryAll = zhangWuService.queryAll();
		
		for (ZhangWu zhangWu : queryAll) {
			System.out.println(zhangWu);
		}
	}
	
	@Test
	public void findZhangwu() {
		ZhangWu zhangWu = zhangWuService.findZhangwu(13);
		System.out.println(zhangWu);
	}
	
	@Test
	public void delete() {
		Integer delete = zhangWuService.delete(1);
		System.out.println(delete);
	}
	
	@Test
	public void update() {
		ZhangWu zw = new ZhangWu(8, "fs" , 0d, "sdfs", new Date(), "sdfs");
		Integer editZhangwu = zhangWuService.editZhangwu(zw);
		System.out.println(editZhangwu);
	}

}
