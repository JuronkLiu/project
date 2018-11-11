package com.lzr.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Composition {

	private Integer id;
	private String title;
	private String neirong;
	private Integer state;
	private Integer userid;
	private String username;
	private Date createtime;

	public Composition() {
	}

	public Composition(Integer state, Integer userid) {
		this.state = state;
		this.userid = userid;
	}

	public Composition(Integer id, Date createtime) {
		this.id = id;
		this.createtime = createtime;
	}

	public Composition(String title, String neirong, Integer state, Integer userid, String username, Date createtime) {
		this.title = title;
		this.neirong = neirong;
		this.state = state;
		this.userid = userid;
		this.username = username;
		this.createtime = createtime;
	}

	public Composition(Integer id, String title, String neirong, Integer state, Integer userid, String username,
			Date createtime) {
		this.id = id;
		this.title = title;
		this.neirong = neirong;
		this.state = state;
		this.userid = userid;
		this.username = username;
		this.createtime = createtime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNeirong() {
		return neirong;
	}

	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreatetime() {
		return new SimpleDateFormat("yyyy-MM-dd").format(createtime);
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "Composition [id=" + id + ", title=" + title + ", neirong=" + neirong + ", state=" + state + ", userid="
				+ userid + ", username=" + username + ", createtime=" + createtime + "]";
	}

}
