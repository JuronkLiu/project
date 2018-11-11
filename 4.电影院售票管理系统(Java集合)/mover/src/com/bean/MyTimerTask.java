package com.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TimerTask;

/**
 *@describe ��ʱȡ������
 *
 *@author liuzhirong
 *@date 2018��9��4��---����6:06:25 
*/
public class MyTimerTask extends TimerTask {

	private Ticket ticket;
	private TicketType ticketType;
	private Set<User> users;
	
	public MyTimerTask(Ticket ticket, TicketType ticketType, Set<User> users) {
		this.ticket = ticket;
		this.ticketType = ticketType;
		this.users = users;
	}

	@Override
	public void run() {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		try {
			if (ticket.getTime() != null) {
				date = sdf.parse(ticket.getTime());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (ticket.getState().equals("��Ԥ��") && ticket.getTime() != null) {
			if (System.currentTimeMillis() - date.getTime() > 10 * 1000) {
				User findUser = findUser(ticket.getName());
				findUser.getBuyBefore().remove(ticket);
				ticketType.setTotal(ticketType.getTotal() + 1);
				ticket.setState(0);
				ticket.setTime(null);
			}
		}
	}

	/**
	 * Ѱ���û�
	 * @param name
	 * @return
	 */
	private User findUser(String name) {
		for (User user : users) {
			if (user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}

}
