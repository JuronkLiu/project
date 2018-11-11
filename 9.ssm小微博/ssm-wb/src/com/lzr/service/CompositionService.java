package com.lzr.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.lzr.mapper.CompositionMapper;
import com.lzr.pojo.Composition;
import com.lzr.pojo.Fans;
import com.lzr.pojo.Page;
import com.lzr.pojo.QueryVo;

@Service("compositionService")
public class CompositionService {
	
	@Resource(name = "compositionMapper")
	private CompositionMapper compositionMapper;

	/*
	 * 添加我的心情
	 */
	public Integer save(Composition composition) {
		return compositionMapper.save(composition);
	}

	/*
	 * 删除我的心情
	 */
	public Integer delete(Integer id) {
		return compositionMapper.delete(id);
	}

	/*
	 * 修改我的心情
	 */
	public Integer update(Composition composition) {
		return compositionMapper.update(composition);
	}

	public List<Composition> getUserById(Integer userid) {
		return compositionMapper.getUserById(userid);
	}

	public Integer getTotalCount() {
		return compositionMapper.getTotalCount();
	}

	public Page<Composition> getAll(QueryVo vo) {
		
		Page<Composition> page = new Page<>();
		//我的心情总数量
		Integer countMyComposition = compositionMapper.countMyComposition(vo);
		System.out.println(countMyComposition);
		//设置page对象的总数量
		page.setTotal(countMyComposition);
		//设置page对象页面显示的页数量
		page.setSize(vo.getSize());
		//设置page对象的当前页
		page.setPage(vo.getPage());
		//设置page对象的总页数
		Integer allpage = page.getTotal() / page.getSize();
		page.setAllPage(page.getTotal() % page.getSize() == 0 ? allpage : allpage + 1);
		
		//设置分页查找的当前位置
		vo.setStartRow((vo.getPage()-1)*page.getSize());
		List<Composition> getAll = compositionMapper.getAll(vo);
		System.out.println(getAll);
		page.setRows(getAll);
		return page;
	}

	public Page<Composition> getAllCommer(QueryVo vo) {
		Page<Composition> page = new Page<>();
		//我的心情总数量
		Integer countCommer = compositionMapper.countCommer(vo);
		System.out.println(countCommer);
		//设置page对象的总数量
		page.setTotal(countCommer);
		//设置page对象页面显示的页数量
		page.setSize(vo.getSize());
		//设置page对象的当前页
		page.setPage(vo.getPage());
		//设置page对象的总页数
		Integer allpage = page.getTotal() / page.getSize();
		page.setAllPage(page.getTotal() % page.getSize() == 0 ? allpage : allpage + 1);
		
		//设置分页查找的当前位置
		vo.setStartRow((vo.getPage()-1)*page.getSize());
		List<Composition> getAllCommer = compositionMapper.getAllCommer(vo);
		System.out.println(getAllCommer);
		page.setRows(getAllCommer);
		return page;
	}

	/*
	 * 获取我的某个心情
	 */
	public Composition getById(Integer id) {
		return compositionMapper.getById(id);
	}
	
	/*
	 * 将心情放在垃圾箱
	 */
	public Integer tobash(Integer id) {
		return compositionMapper.tobash(id);
	}

	/*
	 * 查看已经删除的心情
	 */
	public Page<Composition> findDeleted(QueryVo vo) {
		Page<Composition> page = new Page<>();
		//我的心情总数量
		Integer deleted = compositionMapper.deleted(vo);
		System.out.println(deleted);
		//设置page对象的总数量
		page.setTotal(deleted);
		//设置page对象页面显示的页数量
		page.setSize(vo.getSize());
		//设置page对象的当前页
		page.setPage(vo.getPage());
		//设置page对象的总页数
		Integer allpage = page.getTotal() / page.getSize();
		page.setAllPage(page.getTotal() % page.getSize() == 0 ? allpage : allpage + 1);
		
		//设置分页查找的当前位置
		vo.setStartRow((vo.getPage()-1)*page.getSize());
		List<Composition> findDeleted = compositionMapper.findDeleted(vo);
		System.out.println(findDeleted);
		page.setRows(findDeleted);
		return page;
	}

	/*
	 * 将心情还原
	 */
	public Integer toupdatedelete(Composition composition) {
		return compositionMapper.toupdatedelete(composition);
	}
	
}
