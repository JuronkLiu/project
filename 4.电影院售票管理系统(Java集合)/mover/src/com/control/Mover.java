package com.control;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.crypto.Data;

import com.bean.TicketType;
import com.bean.User;
import com.utils.Util;

/**
 * @describe 电影院
 *
 * @author liuzhirong
 * @date 2018年8月23日---下午4:04:04
 */
public class Mover {

	Set<TicketType> ticketTypes = new HashSet<>();

	public Set<TicketType> getTicketTypes() {
		return ticketTypes;
	}

	public void setTicketTypes(Set<TicketType> ticketTypes) {
		this.ticketTypes = ticketTypes;
	}

	Set<User> users = new HashSet<>();

	public Mover() {

		// 添加电影
		TicketType zhanglang1 = new TicketType(1, "战狼1", 50d, "2018年8月25日    10:30", "2小时10分");
		zhanglang1.addType(users);
		TicketType zhanglang2 = new TicketType(2, "战狼2", 50d, "2018年8月26日    15:30", "2小时20分");
		zhanglang2.addType(users);
		TicketType zhanglang3 = new TicketType(3, "战狼3", 50d, "2018年8月27日    18:30", "2小时30分");
		zhanglang3.addType(users);
		ticketTypes.add(zhanglang1);
		ticketTypes.add(zhanglang2);
		ticketTypes.add(zhanglang3);

		// 用户
		users.add(new User("1", "1", true));
		users.add(new User("2", "2", false));

		// 监测用户的预订信息
		// new Thread(new AutoTime(users)).start();

	}

	/**
	 * 显示各种电影
	 */
	public void showTickets() {
		System.out
				.println("id" + "\t" + "电影名" + "\t" + "价格" + "\t" + "开始时间 " + "\t\t\t" + "电影时长 " + "\t\t" + "电影剩余票数 ");
		for (TicketType ticketType : ticketTypes) {
			ticketType.showTickets();
		}
		showTicket();
	}

	// 显示每种电影票的位置信息和预订购买状态
	private void showTicket() {
		while (true) {
			Integer id = Util.inputInt("请输入你要查看的电影id：");
			TicketType findTicketTypeById = findTicketTypeById(id);
			if (findTicketTypeById == null) {
				System.out.println("本电影院无该电影，请重新输入！！！");
				continue;
			}
			System.out.println("id" + "\t\t" + "位置" + "\t" + "电影名" + "\t" + "价格" + "\t" + "开始时间 " + "\t\t\t" + "电影时长 "
					+ "\t\t" + "状态" + "\t" + "预订时间/购买时间 ");
			findTicketTypeById.showTicket();
			return;
		}
	}

	// 按id寻找电影
	public TicketType findTicketTypeById(Integer id) {
		for (TicketType ticketType : ticketTypes) {
			if (ticketType.getId() == id) {
				return ticketType;
			}
		}
		return null;
	}

	/**
	 * 用户登录实现
	 */
	public User userLogin() {

		User u = new User();

		String name = null;
		String password = null;
		boolean b = false; // 记录用户是否存在
		while (true) {
			name = Util.inputStr("请输入用户名(exit返回)：");
			if (name.equals("exit")) {
				Menu.welcome();
			}
			for (User user : users) {
				if (user.getName().equals(name)) {
					u = user;
					b = true;
					break;
				}
			}
			if (!b) {
				System.out.println("用户不存在！请重新输入");
				continue;
			}
			while (true) {
				password = Util.inputStr("请输入密码:");
				if (u.getPassword().equals(password)) {
					return u;
				} else {
					System.out.println("密码错误！");
					continue;
				}
			}
		}
	}

	/**
	 * 用户注册实现
	 */
	public void userRegister() {
		String name;
		String password;
		f1: while (true) {
			name = Util.inputStr("请输入用户名(exit返回):");
			if (name.equals("exit")) {
				return;
			}
			for (User user : users) {
				if (user.getName().equals(name)) {
					System.out.println("--用户已存在！请重新输入");
					continue f1;
				}
			}
			password = Util.inputStr("请输入密码:");
			users.add(new User(name, password, false));
			System.out.println("注册成功！");
			return;
		}
	}

	// 添加电影
	public void addTickTypes() {
		// 寻找电影的最大id，为加入的电影设置id值
		Integer id = 0;
		for (TicketType ticketType : ticketTypes) {
			if (id < ticketType.getId()) {
				id = ticketType.getId();
			}
		}
		id++;
		String name;
		TicketType findTicketTypeByName;
		while (true) {
			name = Util.inputStr("请输入你要添加的电影：");
			findTicketTypeByName = findTicketTypeByName(name);
			if (findTicketTypeByName != null) {
				Util.inputStr("该电影已存在！请重新输入电影名称!!!");
				continue;
			}
			break;
		}
		Double price = Util.inputDouble("请输入电影的价格：");
		String time = inputTime();
		String timeLong = timeLong();
		TicketType ticketType = new TicketType(id, name, price, time, timeLong);
		ticketTypes.add(ticketType);
		ticketType.addType(users);

	}

	// 按电影名称查找电影
	public TicketType findTicketTypeByName(String name) {
		for (TicketType ticketType : ticketTypes) {
			if (ticketType.getName().equals(name)) {
				return ticketType;
			}
		}
		return null;
	}

	// 电影时长
	private String timeLong() {
		System.out.println("请输入电影的时长：");
		int hour = Util.inputInt("请输入上映几个小时：");
		int minute = Util.inputInt("请输入还要上映几分钟：");
		StringBuilder sb = new StringBuilder();
		return sb.append(hour).append("小时").append(minute).append("分钟").toString();
	}

	// 设置电影上映的时间
	private String inputTime() {
		// 创建当前的日历
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		// 当前年 月 日
		int yearNow = calendar.get(Calendar.YEAR);
		int monthNow = calendar.get(Calendar.MONTH) + 1;
		int dateNow = calendar.get(Calendar.DATE);
		System.out.println("请输入上映的时间：");
		// 年份判断设置
		int year;
		while (true) {
			year = Util.inputInt("请输入上映的年份：");
			if (year < yearNow) {
				System.out.println("你所输入的年份有误！请重新输入！！！");
				continue;
			}
			break;
		}
		// 月份判断设置
		int month;
		while (true) {
			month = Util.inputInt("请输入上映的月份：");
			if (year == yearNow && month < monthNow || month > 12) {
				System.out.println("你所输入的月份有误！请重新输入！！！");
				continue;
			}
			if (year > yearNow && month < 1 && month > 12) {
				System.out.println("你所输入的月份有误！请重新输入！！！");
				continue;
			}
			break;
		}
		// 日期判断设置
		int day;
		while (true) {
			day = Util.inputInt("请输入上映的日期：");
			if (year == yearNow) {
				if (month == monthNow) {
					if (day < dateNow || day > calendar.getActualMaximum(Calendar.DATE)) {
						System.out.println("日期输入有误！请重新输入！！！");
						continue;
					}
					if (day == dateNow) {
						System.out.println("电影应提前一天安排！请重新输入！！！");
						continue;
					}
				}
			}
			calendar2.set(Calendar.YEAR, year);
			calendar2.set(Calendar.MONTH, month - 1);
			if (day < 1 && day > calendar2.getActualMaximum(Calendar.DATE)) {
				System.out.println("日期输入有误！请重新输入！！！");
				continue;
			}
			break;
		}
		// 时分判断设置
		int hour;
		while (true) {
			hour = Util.inputInt("请输入上映的时：");
			if (hour < 0 || hour > 24) {
				System.out.println("上映的时输入有误！请重新输入！！！");
				continue;
			}
			break;
		}
		int minute;
		while (true) {
			minute = Util.inputInt("请输入上映的分：");
			if (minute < 0 || minute > 60) {
				System.out.println("上映的分钟输入有误！请重新输入！！！");
				continue;
			}
			break;
		}
		StringBuilder sb = new StringBuilder();
		String time = sb.append(year).append("年").append(month).append("月").append(day).append("日").append("    ")
				.append(hour).append(":").append(minute).toString();
		return time;
	}

	// 删除电影
	public void delTickTypes() {
		showAllTickTypes();
		int id;
		TicketType findTicketTypeById;
		while (true) {
			id = Util.inputInt("请输入要删除的电影id(-1返回)：");
			if (id == -1) {
				return;
			}
			findTicketTypeById = findTicketTypeById(id);
			if (findTicketTypeById == null) {
				System.out.println("输入的电影id不存在！请重新输入！！！");
				continue;
			}
			break;
		}
		ticketTypes.remove(findTicketTypeById);
		System.out.println("删除成功！！！");
	}

	// 修改电影
	public void updateTickTypes() {
		showAllTickTypes();
		int id;
		TicketType findTicketTypeById;
		while (true) {
			id = Util.inputInt("请输入要修改的电影id(-1返回)：");
			if (id == -1) {
				return;
			}
			findTicketTypeById = findTicketTypeById(id);
			if (findTicketTypeById == null) {
				System.out.println("输入的电影id不存在！请重新输入！！！");
				continue;
			}
			break;
		}
		System.out
				.println("id" + "\t" + "电影名" + "\t" + "价格" + "\t" + "开始时间 " + "\t\t\t" + "电影时长 " + "\t\t" + "电影剩余票数 ");
		findTicketTypeById.showTickets();

		updateCol(findTicketTypeById);
		System.out.println("修改完毕！！！");
	}

	// 修改
	private void updateCol(TicketType findTicketTypeById) {
		while (true) {
			String str = Util.inputStr("请选择要修改的项目(exit返回；只能修改价格，开始时间，电影时长)：");
			if (str.equals("exit")) {
				return;
			}
			if (str.equals("价格")) {
				Double price = Util.inputDouble("请输入价格：");
				findTicketTypeById.setPrice(price);
			}
			if (str.equals("开始时间")) {
				String time = inputTime();
				findTicketTypeById.setStartTime(time);
			}
			if (str.equals("电影时长")) {
				String timeLong = timeLong();
				findTicketTypeById.setTimeLong(timeLong);
			}
			if (!str.equals("exit") && !str.equals("价格") && !str.equals("开始时间") && !str.equals("电影时长")) {
				System.out.println("你输入有误！请重新输入！！！");
				continue;
			}
			String fag = Util.inputStr("修改成功！是否还要修改？(Y-->是；其他-->否)");
			if (fag.equals("Y")) {
				continue;
			} else {
				return;
			}
		}

	}

	// 查看电影详细信息
	public void showTickTypesById() {
		showAllTickTypes();
		int id;
		TicketType findTicketTypeById;
		while (true) {
			id = Util.inputInt("请输入要查看的电影id(-1返回)：");
			if (id == -1) {
				return;
			}
			findTicketTypeById = findTicketTypeById(id);
			if (findTicketTypeById == null) {
				System.out.println("输入的电影id不存在！请重新输入！！！");
				continue;
			}
			break;
		}
		System.out.println("******电影场次信息*******");
		System.out
				.println("id" + "\t" + "电影名" + "\t" + "价格" + "\t" + "开始时间 " + "\t\t\t" + "电影时长 " + "\t\t" + "电影剩余票数 ");
		findTicketTypeById.showTickets();
		System.out.println("******电影票信息*******");
		System.out.println("id" + "\t" + "位置" + "\t" + "电影名" + "\t" + "价格" + "\t" + "开始时间 " + "\t\t\t" + "电影时长 "
				+ "\t\t" + "状态" + "\t" + "预订时间/购买时间 ");
		findTicketTypeById.showTicket();
	}

	public void showAllTickTypes() {
		System.out
				.println("id" + "\t" + "电影名" + "\t" + "价格" + "\t" + "开始时间 " + "\t\t\t" + "电影时长 " + "\t\t" + "电影剩余票数 ");
		for (TicketType ticketType : ticketTypes) {
			ticketType.showTickets();
		}
	}

}
