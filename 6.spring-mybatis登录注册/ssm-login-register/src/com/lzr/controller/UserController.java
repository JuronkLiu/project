package com.lzr.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzr.exception.MessageException;
import com.lzr.pojo.User;
import com.lzr.service.UserService;

@Controller("userController")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/register.action")
	public String register(Model model,User user) {
		
		Integer register = userService.register(user);
		
		return "success";
	}
	
	@RequestMapping("/login.action")
	public String login(Model model,User user) throws MessageException {
		
		Integer login = userService.login(user);
		if (login <= 0) {
			throw new MessageException("用户或密码错误");
		}
		return "success";
	}
}
