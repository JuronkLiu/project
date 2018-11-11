package com.lzr.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lzr.pojo.User;
import com.lzr.service.UserService;

@Controller("userController")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/query.action")
	public String queryUser(Model model) {
		
		//查找数据
//		User user = userService.findUserById(22);
		
		//添加传递到界面的数据
//		model.addAttribute("user", user);
		
		//传送界面，此为转发
		return "customer";
	}
}
