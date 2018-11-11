package com.lzr.controller;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzr.pojo.Adminuser;
import com.lzr.pojo.Fans;
import com.lzr.pojo.Page;
import com.lzr.pojo.QueryVo;
import com.lzr.service.FansService;

@Controller
@RequestMapping("/fans")
public class FansController {

	@Resource(name="fansService")
	private FansService fansService;
	
	/*
	 * 展示我的关注
	 */
	@RequestMapping("/toList.action")
	public String toList(Model model,HttpSession session,@RequestParam(required=false,defaultValue="1")Integer page,@RequestParam(required=false,defaultValue="")String pname) {
		Integer userid = (Integer) session.getAttribute("userid");
		QueryVo vo = new QueryVo();
		vo.setPage(page);
		vo.setId(userid);
		vo.setFind(pname);
		
		Page<Fans> findAllUser = fansService.getAll(vo);
		System.out.println(findAllUser);
		//获取用户的数集合
		List<Fans> rows = findAllUser.getRows();
		System.out.println(rows);
		
		model.addAttribute("lists", rows);
		model.addAttribute("page", findAllUser);
		
		return "fans/fans";
	}
	
	/*
	 * 添加关注
	 */
	@RequestMapping("/save.action")
	public String save(Model model,HttpSession session,Fans fans) {
		Integer userid = (Integer) session.getAttribute("userid");
		fans.setUserid(userid);
		
		Integer findFans = fansService.findFans(fans);
		if (findFans > 0 ) {
			return "redirect:toList.action";
		}else{
			fans.setCreatetime(new Date());
			fansService.save(fans);
		}
		return "redirect:toList.action";
	}
	
	/*
	 * 取消关注
	 */
	@RequestMapping("/delete.action")
	public String delete(Model model,Integer fanid) {
		System.out.println(fanid);
		
		fansService.delete(fanid);
		
		return "redirect:toList.action";
	}
		
}
