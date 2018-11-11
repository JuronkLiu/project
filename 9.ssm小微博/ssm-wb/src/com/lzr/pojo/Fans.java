package com.lzr.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fans {

	private Integer id;
	private Integer fanuserid;
	private String fanusername;
	private Integer userid;
	private Date createtime;

	public Fans() {
		super();
	}

	public Fans(Integer fanuserid, String fanusername, Integer userid, Date createtime) {
		super();
		this.fanuserid = fanuserid;
		this.fanusername = fanusername;
		this.userid = userid;
		this.createtime = createtime;
	}

	public Fans(Integer id, Integer fanuserid, String fanusername, Integer userid, Date createtime) {
		this.id = id;
		this.fanuserid = fanuserid;
		this.fanusername = fanusername;
		this.userid = userid;
		this.createtime = createtime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFanuserid() {
		return fanuserid;
	}

	public void setFanuserid(Integer fanuserid) {
		this.fanuserid = fanuserid;
	}

	public String getFanusername() {
		return fanusername;
	}

	public void setFanusername(String fanusername) {
		this.fanusername = fanusername;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getCreatetime() {
		return new SimpleDateFormat("yyyy-MM-dd").format(createtime);
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "Fans [id=" + id + ", fanuserid=" + fanuserid + ", fanusername=" + fanusername + ", userid=" + userid
				+ ", createtime=" + createtime + "]";
	}

}
