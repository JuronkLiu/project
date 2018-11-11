package com.lzr.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lzr.pojo.User;
import com.lzr.service.UserService;

public class TestDemo {

	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserService userService = (UserService) ac.getBean("userService");

	/**
	 * 注册用户
	 */
	@Test
	public void register() {

		User user = new User("zs","123");
		Integer register = userService.register(user);
		System.out.println(register);

	}

	/**
	 * 登录用户
	 */
	@Test
	public void login() {

		User user = new User("zs","12334");
		Integer register = userService.login(user);
		
		System.out.println(register);

	}
	

}