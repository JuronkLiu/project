package com.bean;

import java.util.Set;
import java.util.Timer;

/**
 * @describe 每张电影票
 *
 * @author liuzhirong
 * @date 2018年8月23日---下午3:56:40
 */
public class Ticket extends Comment {

	private String userName;	//记录购买的用户
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private Long id;
	private String rowCol;
	private  Integer state = 0;
	private String time = null;
	private TicketType ticketType;
	private Set<User> users;
	
	public Ticket() {
	}

	public Ticket(Long id, Integer state, String time, String name, Double price, String startTime, String timeLong, TicketType ticketType, Set<User> users) {
		this.id = id;
		this.state = state;
		this.time = time;
		this.name = name;
		this.price = price;
		this.startTime = startTime;
		this.timeLong = timeLong;
		this.ticketType = ticketType;
		this.users = users;
		
		//自动取消
		autoClear(users);
	}

	//自动取消
	private void autoClear(Set<User> users) {
		//定时器
		new Timer().schedule(new MyTimerTask(this,this.ticketType,users), 0, 1 * 1000);
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRowCol() {
		String string = id.toString();
		StringBuilder sb = new StringBuilder();
		String substring = string.substring(string.length() - 2, string.length() - 1);
		rowCol = sb.append(substring).append("排").append(string.substring(string.length() - 1)).append("列").toString();
		return rowCol;
	}

	public void setRowCol(String rowCol) {
		this.rowCol = rowCol;
	}

	public String getState() {
		if (state == 1) {
			return "已预订";
		} else if (state == 2) {
			return "已购买";
		} else {
			return "未购买";
		}
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void show() {
		System.out.println(getId() + "\t" + getRowCol() + "\t" + getName() + "\t" + getPrice() + "\t" + getStartTime()
				+ "\t" + getTimeLong() + "\t\t" + getState() + "\t" + getTime());
	}
}
