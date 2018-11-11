package com.lzr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("mainController")
public class MainController {
	
	@RequestMapping("/tologin.action")
	public String login(Model model) {
		return "login/login";
	}

	@RequestMapping("/toregister.action")
	public String register(Model model) {
		return "login/regist";
	}
	
	
	
}
