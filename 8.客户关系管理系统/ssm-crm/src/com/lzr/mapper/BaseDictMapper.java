package com.lzr.mapper;

import java.util.List;

import com.lzr.pojo.BaseDict;


public interface BaseDictMapper {

	
	//查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}
