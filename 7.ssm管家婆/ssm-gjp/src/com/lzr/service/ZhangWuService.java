package com.lzr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lzr.mapper.ZhangWuMapper;
import com.lzr.pojo.ZhangWu;
import com.lzr.pojo.ZhangWuExample;

@Service("zhangWuService")
public class ZhangWuService {
	
	@Resource(name ="zhangWuMapper")
	private ZhangWuMapper zhangWuMapper;
	
	ZhangWuExample example = new ZhangWuExample();
	
	/**
	 * 查询所有信息
	 * @return
	 */
	public List<ZhangWu> queryAll(){
		return zhangWuMapper.selectByExample(example);
	}

	/**
	 * 删除
	 * @return
	 */
	public Integer delete(Integer zwid){
		return zhangWuMapper.deleteByPrimaryKey(zwid);
	}
	
	/**
	 * 按照id查询
	 * @return
	 */
	public ZhangWu findZhangwu(Integer zwid){
		return zhangWuMapper.selectByPrimaryKey(zwid);
	}
	
	/**
	 * 修改
	 * @return
	 */
	public Integer editZhangwu(ZhangWu zw){
		return zhangWuMapper.updateByPrimaryKey(zw);
	}
	
}
