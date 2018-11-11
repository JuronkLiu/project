package com.lzr.service;

import java.util.List;

import com.lzr.pojo.BaseDict;


public interface BaseDictService {

	
	//查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}
