package com.lzr.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzr.pojo.ZhangWu;
import com.lzr.service.ZhangWuService;

@Controller
public class ZhangWuController {
	
	@Resource(name = "zhangWuService")
	private ZhangWuService zhangWuService;
	
	/**
	 * 查询全部
	 * @param model
	 * @return
	 */
	@RequestMapping("/listZhangwu.action")
	public String listZhangwu(Model model) {
		
		List<ZhangWu> queryAll = zhangWuService.queryAll();
		
		model.addAttribute("list", queryAll);
		
		return "listZhangwu";
	}
	
	/**
	 * 删除
	 * @param model
	 * @param zwid
	 * @return
	 */
	@RequestMapping("/deleteZhangwu.action")
	public String deleteZhangwu(Model model,Integer zwid) {
		
		zhangWuService.delete(zwid);
		
		return "redirect:listZhangwu.action";
	}
	
	/**
	 * 按照id查找
	 * @param model
	 * @return
	 */
	@RequestMapping("/findZhangwu.action")
	public String findZhangwu(Model model,Integer zwid) {
		
		ZhangWu findZhangwu = zhangWuService.findZhangwu(zwid);
		
		model.addAttribute("zhangwu", findZhangwu);
		
		return "editZhangwu";
	}
	
	/**
	 * 编辑
	 * @param model
	 * @return
	 */
	@RequestMapping("/editZhangwu.action")
	public String editZhangwu(Model model,ZhangWu zw) {
		
		zhangWuService.editZhangwu(zw);
		
		return "redirect:listZhangwu.action";
	}

}
