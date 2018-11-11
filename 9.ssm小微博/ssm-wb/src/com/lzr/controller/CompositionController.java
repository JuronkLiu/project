package com.lzr.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzr.pojo.Composition;
import com.lzr.pojo.Fans;
import com.lzr.pojo.Page;
import com.lzr.pojo.QueryVo;
import com.lzr.service.CompositionService;

@Controller
@RequestMapping("/composition")
public class CompositionController {
	
	@Resource(name="compositionService")
	private CompositionService compositionService;
	
	
	/*
	 * 展示我的心情
	 */
	@RequestMapping("/toList.action")
	public String toList(Model model,HttpSession session,@RequestParam(required=true,defaultValue="1")Integer page,
			@RequestParam(required=true,defaultValue="")String pname,@RequestParam(required=true,defaultValue="10")String state) {
		Integer userid = (Integer) session.getAttribute("userid");
		QueryVo vo = new QueryVo();
		vo.setPage(page);
		vo.setId(userid);
		vo.setFind(pname);
		vo.setState(Integer.parseInt(state));
		Page<Composition> getAll = compositionService.getAll(vo);
		
		//获取用户的数集合
		List<Composition> rows = getAll.getRows();
		
		model.addAttribute("lists", rows);
		model.addAttribute("page", getAll);
		
		return "composition/composition";
	}
	
	/*
	 * 展示公共的心情
	 */
	@RequestMapping("/toListAll.action")
	public String toListAll(Model model,@RequestParam(required=true,defaultValue="1")Integer page,
			@RequestParam(required=true,defaultValue="")String pname) {
		
		QueryVo vo = new QueryVo();
		vo.setPage(page);
		vo.setFind(pname);
		
		Page<Composition> all = compositionService.getAllCommer(vo);
		List<Composition> rows = all.getRows();
		
		model.addAttribute("lists", rows);
		model.addAttribute("page", all);
		
		return "composition/AllComposition";
	}
	
	/*
	 * 去添加我的心情
	 */
	@RequestMapping("/toAdd.action")
	public String toAdd(Model model) {
		return "composition/addComposition";
	}
	
	/*
	 * 添加我的心情
	 */
	@RequestMapping("/add.action")
	public String add(Model model,HttpSession session,Composition composition) {
		Integer userid = (Integer) session.getAttribute("userid");
		String username = (String) session.getAttribute("username");
		composition.setUserid(userid);
		composition.setUsername(username);
		composition.setCreatetime(new Date());
		compositionService.save(composition);
		return "redirect:toList.action";
	}
	
	/*
	 * 将心情放在垃圾箱
	 */
	@RequestMapping("/tobash.action")
	public String tobash(Model model,Integer id) {
		compositionService.tobash(id);
		return "redirect:toList.action";
	}
	
	/*
	 * 彻底删除心情
	 */
	@RequestMapping("/delete.action")
	public String delete(Model model,Integer id) {
		compositionService.delete(id);
		return "redirect:findDeleted.action";
	}
	
	/*
	 * 批量将心情加入垃圾箱
	 */
	@RequestMapping("/tobashMore.action")
	public String tobashMore(Model model,String[] ids) {
		if (ids != null) {
			for(int i = 0;i < ids.length ; i++){
				if (!ids[i].equals("on")) {
					Integer parseInt = Integer.parseInt(ids[i]);
					compositionService.tobash(parseInt);
				}
			}
		}
		return "redirect:toList.action";
	}
	
	/*
	 * 彻底批量删除心情
	 */
	@RequestMapping("/deleteMore.action")
	public String deleteMore(Model model,String[] ids) {
		if (ids != null) {
			for(int i = 0;i < ids.length ; i++){
				if (!ids[i].equals("on")) {
					Integer parseInt = Integer.parseInt(ids[i]);
					compositionService.delete(parseInt);
				}
			}
		}
		return "redirect:findDeleted.action";
	}
	
	/*
	 * 批量还原心情
	 */
	@RequestMapping("/returnMore.action")
	public String returnMore(Model model,String[] ids) {
		if (ids != null) {
			for(int i = 0;i < ids.length ; i++){
				if (!ids[i].equals("on")) {
					Integer parseInt = Integer.parseInt(ids[i]);
					Composition composition = new Composition(parseInt,new Date());
					compositionService.toupdatedelete(composition);
				}
			}
		}
		return "redirect:findDeleted.action";
	}
	
	/*
	 * 查看已经删除的心情
	 */
	@RequestMapping("/findDeleted.action")
	public String findDeleted(Model model,HttpSession session,@RequestParam(required=true,defaultValue="1")Integer page,
			@RequestParam(required=true,defaultValue="")String pname) {
		Integer userid = (Integer) session.getAttribute("userid");
		QueryVo vo = new QueryVo();
		vo.setPage(page);
		vo.setId(userid);
		vo.setFind(pname);
		System.out.println(vo);
		
		Page<Composition> findDeleted = compositionService.findDeleted(vo);
		
		//获取用户的数集合
		List<Composition> rows = findDeleted.getRows();
		
		model.addAttribute("lists", rows);
		model.addAttribute("page", findDeleted);
		
		return "composition/deleteComposition";
	}
	
	/*
	 * 将心情还原
	 */
	@RequestMapping("/toupdatedelete.action")
	public String toupdatedelete(Model model,Integer id) {
		Composition composition = new Composition(id,new Date());
		compositionService.toupdatedelete(composition);
		return "redirect:findDeleted.action";
	}
	
	/*
	 * 去修改我的心情
	 */
	@RequestMapping("/toUpdate.action")
	public String toUpdate(Model model,Integer id) {
		Composition composition = compositionService.getById(id);
		model.addAttribute("composition", composition);
		return "composition/updateComposition";
	}
	
	/*
	 * 修改我的心情
	 */
	@RequestMapping("/update.action")
	public String update(Model model,Composition composition) {
		composition.setCreatetime(new Date());
		compositionService.update(composition);
		return "redirect:toList.action";
	}
	
	/*
	 * 查看详细心情
	 */
	@RequestMapping("/findXiangxi.action")
	public String findXiangxi(Model model,Integer id) {
		Composition composition = compositionService.getById(id);
		model.addAttribute("composition", composition);
		return "composition/CKComposition";
	}
}
