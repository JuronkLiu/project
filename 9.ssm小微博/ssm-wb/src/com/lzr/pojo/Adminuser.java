package com.lzr.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Adminuser {

	private Integer userid;
	private String username;
	private String usersex;
	private String userpassword;
	private String usernichen;
	private Date usercreatetime;
	private String state;

	public Adminuser() {
	}

	public Adminuser(String usernichen,String userpassword) {
		this.usernichen = usernichen;
		this.userpassword = userpassword;
	}

	public Adminuser(String username, String usersex, String userpassword, String usernichen, Date usercreatetime,
			String state) {
		this.username = username;
		this.usersex = usersex;
		this.userpassword = userpassword;
		this.usernichen = usernichen;
		this.usercreatetime = usercreatetime;
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

	public String getUsersex() {
		return usersex;
	}

	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUsernichen() {
		return usernichen;
	}

	public void setUsernichen(String usernichen) {
		this.usernichen = usernichen;
	}

	public String getUsercreatetime() {
		return new SimpleDateFormat("yyyy-MM-dd").format(usercreatetime);
	}

	public void setUsercreatetime(Date usercreatetime) {
		this.usercreatetime = usercreatetime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Adminuser [userid=" + userid + ", username=" + username + ", usersex=" + usersex + ", userpassword="
				+ userpassword + ", usernichen=" + usernichen + ", usercreatetime=" + usercreatetime + ", state="
				+ state + "]";
	}

}
