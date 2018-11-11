package com.domain;

import java.util.Date;


/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018年8月30日---下午2:07:47 
*/
public class ZhangWu {
	
	private Integer zwid;// id
	private String flname;// 分类名称
	private String zhangHu;// 账户名称
	private Double money;// 金额
	private String createtime;// 创建时间
	private String description;// 说明
	
	public ZhangWu() {
	}
	
	public ZhangWu(String flname, String zhangHu, double money, String createtime, String description) {
		this.flname = flname;
		this.zhangHu = zhangHu;
		this.money = money;
		this.createtime = createtime;
		this.description = description;
	}
	public String getFlname() {
		return flname;
	}
	public void setFlname(String flname) {
		this.flname = flname;
	}
	public String getZhangHu() {
		return zhangHu;
	}
	public void setZhangHu(String zhangHu) {
		this.zhangHu = zhangHu;
	}
	public int getZwid() {
		return zwid;
	}
	public void setZwid(int zwid) {
		this.zwid = zwid;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
