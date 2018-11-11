package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * @describe 电影票的类别与数量
 *
 * @author liuzhirong
 * @date 2018年8月24日---上午8:28:17
 */
public class TicketType extends Comment{

	private Integer id;
	private Integer total = 0;
	
	private Set<Ticket> ticket = new HashSet<>();

	public Set<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(Set<Ticket> ticket) {
		this.ticket = ticket;
	}

	public TicketType() {
	}

	public TicketType(Integer id, String name, Double price, String startTime, String timeLong) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.startTime = startTime;
		this.timeLong = timeLong;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketType other = (TicketType) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void addType(Set<User> users){
		Long  hashCode = (long) hashCode();
		ticket.add(new Ticket(hashCode*100+11, 0, null,name,price,startTime,timeLong,this,users));
		total++;
		ticket.add(new Ticket(hashCode*100+22, 0, null,name,price,startTime,timeLong,this,users));
		total++;
		ticket.add(new Ticket(hashCode*100+33, 0, null,name,price,startTime,timeLong,this,users));
		total++;
		ticket.add(new Ticket(hashCode*100+44, 0, null,name,price,startTime,timeLong,this,users));
		total++;
	}
	
	// 显示票的种类
	public void showTickets() {
		System.out.println(getId() + "\t" + getName() + "\t" + getPrice() + "\t" + getStartTime() + "\t" + getTimeLong()+ "\t\t" + getTotal());
	}

	// 显示每张票
	public void showTicket() {
		
		for (Ticket t : ticket) {
			System.out.println(t.getId() + "\t" + t.getRowCol() + "\t" + getName() + "\t" + getPrice() + "\t" + getStartTime() + "\t" + getTimeLong()+ "\t\t" +t.getState() + "\t" + t.getTime());
		}
	}
}
