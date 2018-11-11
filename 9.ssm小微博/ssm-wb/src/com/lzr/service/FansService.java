package com.lzr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lzr.mapper.FansMapper;
import com.lzr.pojo.Adminuser;
import com.lzr.pojo.Fans;
import com.lzr.pojo.Page;
import com.lzr.pojo.QueryVo;

@Service("fansService")
public class FansService {

	@Resource(name="fansMapper")
	private FansMapper fansMapper;
	
	/*
	 * 添加关注
	 */
	public Integer save(Fans fans) {
		return fansMapper.save(fans);
	}

	/*
	 * 删除关注
	 */
	public Integer delete(Integer id) {
		return fansMapper.delete(id);
	}

	/*
	 * 获取关注列表
	 */
	public Page<Fans> getAll(QueryVo vo) {
		
		Page<Fans> page = new Page<>();
		//总数量
		Integer countUser = fansMapper.countFans(vo.getId());
		System.out.println(countUser);
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
		List<Fans> findAllUser = fansMapper.getAll(vo);
		
		page.setRows(findAllUser);
		return page;
	}

	/*
	 * 根据被关注的id查找是否已经关注
	 */
	public Integer findFans(Fans fans) {
		return fansMapper.findFans(fans);
	}
	
}
