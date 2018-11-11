package com.lzr.mapper;

import java.util.List;

import com.lzr.pojo.Composition;
import com.lzr.pojo.Page;
import com.lzr.pojo.QueryVo;

public interface CompositionMapper {

	// 添加我的心情
	Integer save(Composition composition);

	// 删除我的心情
	Integer delete(Integer id);

	// 修改我的心情
	Integer update(Composition composition);

	// 按userid查询
	List<Composition> getUserById(Integer userid);

	
	
	// 查询全部数量
	Integer getTotalCount();

	// 查询我的全部心情
	List<Composition> getAll(QueryVo vo);
	
	// 查询公有的信息
	List<Composition> getAllCommer(QueryVo vo);
	
	// 查询公有的信息数量
	Integer countCommer(QueryVo vo);

	//获取我的某个心情
	Composition getById(Integer id);

	//将心情放在垃圾箱
	Integer tobash(Integer id);

	//查看已经删除的心情
	List<Composition> findDeleted(QueryVo vo);
	
	//获取已经删除的心情数量
	Integer deleted(QueryVo vo);

	//将心情还原
	Integer toupdatedelete(Composition composition);

	//查看我的心情数量
	Integer countMyComposition(QueryVo vo);
}
