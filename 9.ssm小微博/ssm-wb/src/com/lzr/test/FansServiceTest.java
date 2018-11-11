package com.lzr.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lzr.pojo.Fans;
import com.lzr.service.FansService;

public class FansServiceTest {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	FansService fansService = (FansService) ac.getBean("fansService");

	/**
	 * 添加粉丝
	 */
	@Test
	public void save() {

		Fans fans = new Fans(1,"乔峰",16,new Date());
		Integer save = fansService.save(fans);
		System.out.println(save);

	}

	/**
	 * 删除粉丝
	 */
	@Test
	public void delete() {

		int delete = fansService.delete(1);
		System.out.println(delete);

	}


	/**
	 * 根据用户id查询关注
	 */
	@Test
	public void getById() {

//		List<Fans> fans = fansService.getAll(16);
//		System.out.println(fans);

	}

	
}
