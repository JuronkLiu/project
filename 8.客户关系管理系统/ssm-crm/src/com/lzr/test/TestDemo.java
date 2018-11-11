package com.lzr.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lzr.pojo.User;
import com.lzr.service.UserService;

public class TestDemo {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserService userService = (UserService) ac.getBean("userService");
	
	@Test
	public void findUserById() {
		User findUserById = userService.findUserById(1);
		System.out.println(findUserById);
	}

}
