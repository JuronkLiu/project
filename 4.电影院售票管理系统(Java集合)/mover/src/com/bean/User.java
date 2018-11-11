package com.bean;
/**
 *@describe 用户
 *
 *@author liuzhirong
 *@date 2018年8月23日---下午3:53:29 
*/

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.control.Mover;
import com.utils.Util;

public class User {

	private String name;
	private String password;
	private boolean tag;
	
	

	Set<Ticket> buyBefore = new HashSet<>();
	
	
	public Set<Ticket> getBuyBefore() {
		return buyBefore;
	}
	public void setBuyBefore(Set<Ticket> buyBefore) {
		this.buyBefore = buyBefore;
	}

	Set<Ticket> buyAfter = new HashSet<>();
	
	public User() {
	}
	public User(String name, String password ,boolean tag) {
		this.name = name;
		this.password = password;
		this.tag = tag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isTag() {
		return tag;
	}
	public void setTag(boolean tag) {
		this.tag = tag;
	}
	
	/**
	 * 显示预订信息
	 */
	public void showBuyBefore() {
		if (buyBefore.size() == 0) {
			System.out.println("您暂时没有预订信息！请预订！");
			return;
		}
		System.out.println("id" + "\t\t" + "位置" + "\t" + "电影名" + "\t" + "价格" + "\t" + "开始时间 " + "\t\t\t" + "电影时长 "
				+ "\t\t" + "状态" + "\t" + "预订时间");
		for (Ticket ticket : buyBefore) {
			ticket.show();
		}
	}
	
	/**
	 * 预订电影票
	 * @param mover
	 */
	public void buyBefore(Mover mover) {
		mover.showAllTickTypes();
		TicketType findTicketType;
		int id = 0;
		Long rowCol;
		Ticket findTicket;
		while (true) {
			id = Util.inputInt("请选择您要预订的电影(-1返回)：");
			if (id == -1) {
				return;
			}
			findTicketType = findTicketType(mover, id);
			if (findTicketType == null) {
				System.out.println("您选择的电影不存在！请重新输入！！！");
				continue;
			}
			System.out.println("id" + "\t\t" + "位置" + "\t" + "电影名" + "\t" + "价格" + "\t" + "开始时间 " + "\t\t\t" + "电影时长 "
					+ "\t\t" + "状态" + "\t" + "预订时间/购买时间 " );
			//显示位置
			findTicketType.showTicket();
			
			while (true) {
				rowCol = Util.inputLong("请选择你要预订的位置(-1退出)：");
				if (rowCol == -1) {
					return;
				}
				findTicket = findTicket(findTicketType, rowCol);
				if (findTicket == null) {
					System.out.println("您选择的位置不存在！请重新输入！！！");
					continue;
				}
				if (findTicket.getState().equals("已预订")) {
					System.out.println("该票已被预订！无法预订！！！请重新输入");
					continue;
				}
				if (findTicket.getState().equals("已购买")) {
					System.out.println("该票已被购买！无法预订！！！请重新输入");
					continue;
				}
				break;
			}
			break;
		}
		String str = Util.inputStr("确定预订:Y-->是;其它-->返回");
		if (str.equals("Y")) {
			findTicket.setName(name);
			buyBefore.add(findTicket);
			findTicket.setState(1);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			findTicket.setTime(sdf.format(date));
			findTicketType.setTotal(findTicketType.getTotal()-1);
			System.out.println("预订成功");
			return;
		}
		System.out.println("预订失败！");
		return;
	}
	
	//寻找电影票的位置
	private Ticket findTicket(TicketType findTicketType, Long rowCol) {
		findTicketType.getTicket();
		for (Ticket ticket : findTicketType.getTicket()) {
			if (ticket.getId().equals(rowCol)) {
				return ticket;
			}
		}
		return null;
	}
	
	/**
	 * 取消预订
	 * @param mover
	 */
	public void removeBuyBefore(Mover mover) {
		if (buyBefore.size() == 0) {
			System.out.println("您暂时没有预订信息！取消预订信息失败！！！");
			return;
		}
		showBuyBefore();
		Ticket findTicket;
		Long id = 0L;
		while (true) {
			id = Util.inputLong("请选择您要取消预订的位置(-1返回)：");
			if (id == -1) {
				return;
			}
			findTicket = findMyTicket(id);
			if (findTicket == null) {
				System.out.println("您选择的位置不存在！请重新输入！！！");
				continue;
			}
			break;
		}
		String str = Util.inputStr("确定取消预订:Y-->是;其它-->返回");
		if (str.equals("Y")) {
			buyBefore.remove(findTicket);
			findTicket.setState(0);
			findTicket.setTime(null);
			mover.findTicketTypeByName(findTicket.getName()).setTotal(mover.findTicketTypeByName(findTicket.getName()).getTotal() + 1);;
			System.out.println("取消预订成功！");
			return;
		}
		System.out.println("取消预订失败！");
		return;
	}
	
	/**
	 * 购买预订的电影票
	 * @param mover
	 */
	public void buy(Mover mover) {
		if (buyBefore.size() == 0) {
			System.out.println("您暂时没有预订信息！无法购买！请预订");
			return;
		}
		showBuyBefore();
		Ticket findTicket;
		Long id = 0L;
		while (true) {
			id = Util.inputLong("请选择您要购买的位置(-1返回)：");
			if (id == -1) {
				return;
			}
			findTicket = findMyTicket(id);
			if (findTicket == null) {
				System.out.println("您选择的位置不存在！请重新输入！！！");
				continue;
			}
			break;
		}
		String str = Util.inputStr("确定购买:Y-->是;其它-->返回");
		if (str.equals("Y")) {
			buyBefore.remove(findTicket);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyy.MM.dd HH:mm:ss");
			findTicket.setTime(sdf.format(date));
			buyAfter.add(findTicket);
			findTicket.setState(2);
			System.out.println("购买成功！");
			return;
		}
		System.out.println("购买失败！");
		return;
	}
	
	/**
	 * 显示购买的电影票
	 */
	public void showBuy() {
		if (buyAfter.size() == 0) {
			System.out.println("您暂时没有购买信息！请去购买电影票");
			return;
		}
		System.out.println("id" + "\t\t" + "位置" + "\t" + "电影名" + "\t" + "价格" + "\t" + "开始时间 " + "\t\t\t" + "电影时长 "
				+ "\t\t" + "状态" + "\t" + "预订时间/购买时间 ");
		for (Ticket ticket : buyAfter) {
			ticket.show();
		}
	}
	
	/**
	 * 查找电影类别
	 * @param mover  电影
	 * @param id  电影类别id
	 * @return  电影类别
	 */
	public TicketType findTicketType(Mover mover, int id){
		TicketType findTicketTypeById = mover.findTicketTypeById(id);
		if (findTicketTypeById != null) {
			return findTicketTypeById;
		}
		return null;
	}
	
	/**
	 * 查找预订的电影票
	 * @param id 电影票的id
	 * @return
	 */
	public Ticket findMyTicket(Long id){
		for (Ticket ticket : buyBefore) {
			if (ticket.getId().equals(id)) {
				return ticket;
			}
		}
		return null;
	}
	
}
