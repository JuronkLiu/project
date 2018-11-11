package com.lzr.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lzr.pojo.Adminuser;
import com.lzr.pojo.Page;
import com.lzr.pojo.QueryVo;
import com.lzr.service.AdminuserService;

@Controller("adminuserController")
public class AdminuserController {

	@Resource(name = "adminuserService")
	private AdminuserService adminuserService;

	/*
	 * 用户注册
	 */
	@RequestMapping("/register.action")
	public String register(Model model, HttpSession session, Adminuser user, String productCheck) {
		String checkcode_session = (String) session.getAttribute("checkcode_session");
		System.out.println(user);
		if (user.getUsernichen() == null || user.getUserpassword() == null || user.getUsernichen() == "" || user.getUserpassword() == "") {
			model.addAttribute("checkuser", "昵称或密码不能为空");
			return "forward:toregister.action";
		}
		if (!productCheck.equals(checkcode_session)) {
			model.addAttribute("check", "验证码有误");
			return "forward:toregister.action";
		}
		Integer findUser = adminuserService.findUser(user.getUsernichen());
		if (findUser == null) {
			model.addAttribute("checkuser", "昵称或密码有误");
			return "forward:toregister.action";
		}

		if (productCheck.equals(checkcode_session) && findUser != null) {
			user.setUsercreatetime(new Date());
			user.setState("0");
			Integer register = adminuserService.register(user);
			if (register == 1) {
				return "redirect:tologin.action";
			}
		}
		return "redirect:toregister.action";
	}

	/*
	 * 用户登录
	 */
	@RequestMapping("/login.action")
	public String login(Model model, HttpSession session, Adminuser user) {
		Adminuser login = adminuserService.login(user);
		if (login != null) {
			session.setAttribute("username", login.getUsernichen());
			session.setAttribute("userid", login.getUserid());
			return "redirect:touser.action";
		}
		model.addAttribute("message", "用户名或密码有误");
		return "forward:tologin.action";
	}

	/*
	 * 用户退出
	 */
	@RequestMapping("/logout.action")
	public String loginout(Model model, HttpSession session) {
		session.invalidate();
		return "redirect:tologin.action";
	}

	/*
	 * ajax检验用户昵称是否已经注册
	 */
	@RequestMapping("/checkUserNiChen.action")
	public @ResponseBody String checkUserNiChen(@RequestBody String usernichen) {

		// 切割json数据获取值
		String[] split = usernichen.split(":");
		String check = split[1].substring(0, split[1].length() - 1);

		Integer findUser = adminuserService.findUser(check);
		if (findUser == null) {
			return "{\"name\":\"yes\"}";
		}
		return "{\"name\":\"no\"}";
	}

	/*
	 * ajax检验验证码---json解析
	 */
	@RequestMapping("/productCheck.action")
	public @ResponseBody String productCheck(HttpSession session, @RequestBody String productCheck) {
		String checkcode_session = (String) session.getAttribute("checkcode_session");

		String[] split = productCheck.split(":");
		String check = split[1].substring(0, split[1].length() - 1);

		if (checkcode_session.equals(check)) {
			return "{\"name\":\"yes\"}";
		}
		return "{\"name\":\"no\"}";
	}

	/*
	 * 分页查询所有用户
	 */
	@RequestMapping("/touser.action")
	public String fans(Model model, HttpSession session,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "") String pname) {
		String username = (String) session.getAttribute("username");
		QueryVo vo = new QueryVo();
		vo.setPage(page);
		Page<Adminuser> findAllUser = null;
		vo.setName(username);
		vo.setFind(pname.trim());

		findAllUser = adminuserService.findAllUser(vo);
		// 获取用户的数集合
		List<Adminuser> rows = findAllUser.getRows();

		model.addAttribute("lists", rows);
		model.addAttribute("page", findAllUser);
		return "login/index";
	}
}
