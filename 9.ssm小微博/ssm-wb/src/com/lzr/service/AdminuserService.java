package com.lzr.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.lzr.mapper.AdminuserMapper;
import com.lzr.pojo.Adminuser;
import com.lzr.pojo.Page;
import com.lzr.pojo.QueryVo;

@Service("adminuserService")
public class AdminuserService {

	@Resource(name = "adminuserMapper")
	private AdminuserMapper adminuserMapper;

	/*
	 * 用户注册
	 */
	public Integer register(Adminuser user) {
		return adminuserMapper.register(user);
	}

	/*
	 * 用户登录
	 */
	public Adminuser login(Adminuser user) {
		return adminuserMapper.login(user);
	}
	
	/*// 按照昵称查找用户
		Integer findUser(String usernichen);*/
	public Integer findUser(String usernichen) {
		return adminuserMapper.findUser(usernichen);
	}

	/*
	 * 分页查找全部用户
	 */
	public Page<Adminuser> findAllUser(QueryVo vo){
		Page<Adminuser> page = new Page<>();
		//总数量
		Integer countUser = adminuserMapper.countUser(vo.getName());
		//设置page对象的总数量
		page.setTotal(countUser);
		//设置page对象页面显示的页数量
		page.setSize(vo.getSize());
		//设置page对象的当前页
		page.setPage(vo.getPage());
		//设置page对象的总页数
		Integer allpage = page.getTotal() / page.getSize();
		page.setAllPage(page.getTotal() % page.getSize() == 0 ? allpage : allpage + 1);
		//设置分页查找的当前位置
		vo.setStartRow((vo.getPage()-1)*page.getSize());
		List<Adminuser> findAllUser = adminuserMapper.findAllUser(vo);
		
		page.setRows(findAllUser);
		return page;
	}
}
