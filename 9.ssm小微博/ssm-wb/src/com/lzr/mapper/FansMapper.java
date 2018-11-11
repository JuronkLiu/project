package com.lzr.mapper;

import java.util.List;

import com.lzr.pojo.Fans;
import com.lzr.pojo.QueryVo;

public interface FansMapper {

	// 添加
	Integer save(Fans fans);

	// 删除
	int delete(Integer id);

	// 根据用户昵称查询全部粉丝信息
	List<Fans> getAll(QueryVo vo);

	// 查询关注数量
	Integer countFans(Integer id);
		
	Integer findFans(Fans fans);
	
	

}
