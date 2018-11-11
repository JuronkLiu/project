package com.lzr.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ZhangWu {
	private Integer zwid;

	private String flname;

	private Double money;

	private String zhanghu;

	private Date createtime;

	private String description;

	public ZhangWu() {
	}

	public ZhangWu(Integer zwid, String flname, Double money, String zhanghu, Date createtime, String description) {
		this.zwid = zwid;
		this.flname = flname;
		this.money = money;
		this.zhanghu = zhanghu;
		this.createtime = createtime;
		this.description = description;
	}

	public Integer getZwid() {
		return zwid;
	}

	public void setZwid(Integer zwid) {
		this.zwid = zwid;
	}

	public String getFlname() {
		return flname;
	}

	public void setFlname(String flname) {
		this.flname = flname == null ? null : flname.trim();
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getZhanghu() {
		return zhanghu;
	}

	public void setZhanghu(String zhanghu) {
		this.zhanghu = zhanghu == null ? null : zhanghu.trim();
	}

	public String getCreatetime() {
		
		return new SimpleDateFormat("yyyy-MM-dd").format(createtime);
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	@Override
	public String toString() {
		return "ZhangWu [zwid=" + zwid + ", flname=" + flname + ", money=" + money + ", zhanghu=" + zhanghu
				+ ", createtime=" + createtime + ", description=" + description + "]";
	}

}