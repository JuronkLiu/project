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
 * @describe ��ӰԺ
 *
 * @author liuzhirong
 * @date 2018��8��23��---����4:04:04
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

		// ��ӵ�Ӱ
		TicketType zhanglang1 = new TicketType(1, "ս��1", 50d, "2018��8��25��    10:30", "2Сʱ10��");
		zhanglang1.addType(users);
		TicketType zhanglang2 = new TicketType(2, "ս��2", 50d, "2018��8��26��    15:30", "2Сʱ20��");
		zhanglang2.addType(users);
		TicketType zhanglang3 = new TicketType(3, "ս��3", 50d, "2018��8��27��    18:30", "2Сʱ30��");
		zhanglang3.addType(users);
		ticketTypes.add(zhanglang1);
		ticketTypes.add(zhanglang2);
		ticketTypes.add(zhanglang3);

		// �û�
		users.add(new User("1", "1", true));
		users.add(new User("2", "2", false));

		// ����û���Ԥ����Ϣ
		// new Thread(new AutoTime(users)).start();

	}

	/**
	 * ��ʾ���ֵ�Ӱ
	 */
	public void showTickets() {
		System.out
				.println("id" + "\t" + "��Ӱ��" + "\t" + "�۸�" + "\t" + "��ʼʱ�� " + "\t\t\t" + "��Ӱʱ�� " + "\t\t" + "��Ӱʣ��Ʊ�� ");
		for (TicketType ticketType : ticketTypes) {
			ticketType.showTickets();
		}
		showTicket();
	}

	// ��ʾÿ�ֵ�ӰƱ��λ����Ϣ��Ԥ������״̬
	private void showTicket() {
		while (true) {
			Integer id = Util.inputInt("��������Ҫ�鿴�ĵ�Ӱid��");
			TicketType findTicketTypeById = findTicketTypeById(id);
			if (findTicketTypeById == null) {
				System.out.println("����ӰԺ�޸õ�Ӱ�����������룡����");
				continue;
			}
			System.out.println("id" + "\t\t" + "λ��" + "\t" + "��Ӱ��" + "\t" + "�۸�" + "\t" + "��ʼʱ�� " + "\t\t\t" + "��Ӱʱ�� "
					+ "\t\t" + "״̬" + "\t" + "Ԥ��ʱ��/����ʱ�� ");
			findTicketTypeById.showTicket();
			return;
		}
	}

	// ��idѰ�ҵ�Ӱ
	public TicketType findTicketTypeById(Integer id) {
		for (TicketType ticketType : ticketTypes) {
			if (ticketType.getId() == id) {
				return ticketType;
			}
		}
		return null;
	}

	/**
	 * �û���¼ʵ��
	 */
	public User userLogin() {

		User u = new User();

		String name = null;
		String password = null;
		boolean b = false; // ��¼�û��Ƿ����
		while (true) {
			name = Util.inputStr("�������û���(exit����)��");
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
				System.out.println("�û������ڣ�����������");
				continue;
			}
			while (true) {
				password = Util.inputStr("����������:");
				if (u.getPassword().equals(password)) {
					return u;
				} else {
					System.out.println("�������");
					continue;
				}
			}
		}
	}

	/**
	 * �û�ע��ʵ��
	 */
	public void userRegister() {
		String name;
		String password;
		f1: while (true) {
			name = Util.inputStr("�������û���(exit����):");
			if (name.equals("exit")) {
				return;
			}
			for (User user : users) {
				if (user.getName().equals(name)) {
					System.out.println("--�û��Ѵ��ڣ�����������");
					continue f1;
				}
			}
			password = Util.inputStr("����������:");
			users.add(new User(name, password, false));
			System.out.println("ע��ɹ���");
			return;
		}
	}

	// ��ӵ�Ӱ
	public void addTickTypes() {
		// Ѱ�ҵ�Ӱ�����id��Ϊ����ĵ�Ӱ����idֵ
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
			name = Util.inputStr("��������Ҫ��ӵĵ�Ӱ��");
			findTicketTypeByName = findTicketTypeByName(name);
			if (findTicketTypeByName != null) {
				Util.inputStr("�õ�Ӱ�Ѵ��ڣ������������Ӱ����!!!");
				continue;
			}
			break;
		}
		Double price = Util.inputDouble("�������Ӱ�ļ۸�");
		String time = inputTime();
		String timeLong = timeLong();
		TicketType ticketType = new TicketType(id, name, price, time, timeLong);
		ticketTypes.add(ticketType);
		ticketType.addType(users);

	}

	// ����Ӱ���Ʋ��ҵ�Ӱ
	public TicketType findTicketTypeByName(String name) {
		for (TicketType ticketType : ticketTypes) {
			if (ticketType.getName().equals(name)) {
				return ticketType;
			}
		}
		return null;
	}

	// ��Ӱʱ��
	private String timeLong() {
		System.out.println("�������Ӱ��ʱ����");
		int hour = Util.inputInt("��������ӳ����Сʱ��");
		int minute = Util.inputInt("�����뻹Ҫ��ӳ�����ӣ�");
		StringBuilder sb = new StringBuilder();
		return sb.append(hour).append("Сʱ").append(minute).append("����").toString();
	}

	// ���õ�Ӱ��ӳ��ʱ��
	private String inputTime() {
		// ������ǰ������
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		// ��ǰ�� �� ��
		int yearNow = calendar.get(Calendar.YEAR);
		int monthNow = calendar.get(Calendar.MONTH) + 1;
		int dateNow = calendar.get(Calendar.DATE);
		System.out.println("��������ӳ��ʱ�䣺");
		// ����ж�����
		int year;
		while (true) {
			year = Util.inputInt("��������ӳ����ݣ�");
			if (year < yearNow) {
				System.out.println("�������������������������룡����");
				continue;
			}
			break;
		}
		// �·��ж�����
		int month;
		while (true) {
			month = Util.inputInt("��������ӳ���·ݣ�");
			if (year == yearNow && month < monthNow || month > 12) {
				System.out.println("����������·��������������룡����");
				continue;
			}
			if (year > yearNow && month < 1 && month > 12) {
				System.out.println("����������·��������������룡����");
				continue;
			}
			break;
		}
		// �����ж�����
		int day;
		while (true) {
			day = Util.inputInt("��������ӳ�����ڣ�");
			if (year == yearNow) {
				if (month == monthNow) {
					if (day < dateNow || day > calendar.getActualMaximum(Calendar.DATE)) {
						System.out.println("���������������������룡����");
						continue;
					}
					if (day == dateNow) {
						System.out.println("��ӰӦ��ǰһ�찲�ţ����������룡����");
						continue;
					}
				}
			}
			calendar2.set(Calendar.YEAR, year);
			calendar2.set(Calendar.MONTH, month - 1);
			if (day < 1 && day > calendar2.getActualMaximum(Calendar.DATE)) {
				System.out.println("���������������������룡����");
				continue;
			}
			break;
		}
		// ʱ���ж�����
		int hour;
		while (true) {
			hour = Util.inputInt("��������ӳ��ʱ��");
			if (hour < 0 || hour > 24) {
				System.out.println("��ӳ��ʱ�����������������룡����");
				continue;
			}
			break;
		}
		int minute;
		while (true) {
			minute = Util.inputInt("��������ӳ�ķ֣�");
			if (minute < 0 || minute > 60) {
				System.out.println("��ӳ�ķ��������������������룡����");
				continue;
			}
			break;
		}
		StringBuilder sb = new StringBuilder();
		String time = sb.append(year).append("��").append(month).append("��").append(day).append("��").append("    ")
				.append(hour).append(":").append(minute).toString();
		return time;
	}

	// ɾ����Ӱ
	public void delTickTypes() {
		showAllTickTypes();
		int id;
		TicketType findTicketTypeById;
		while (true) {
			id = Util.inputInt("������Ҫɾ���ĵ�Ӱid(-1����)��");
			if (id == -1) {
				return;
			}
			findTicketTypeById = findTicketTypeById(id);
			if (findTicketTypeById == null) {
				System.out.println("����ĵ�Ӱid�����ڣ����������룡����");
				continue;
			}
			break;
		}
		ticketTypes.remove(findTicketTypeById);
		System.out.println("ɾ���ɹ�������");
	}

	// �޸ĵ�Ӱ
	public void updateTickTypes() {
		showAllTickTypes();
		int id;
		TicketType findTicketTypeById;
		while (true) {
			id = Util.inputInt("������Ҫ�޸ĵĵ�Ӱid(-1����)��");
			if (id == -1) {
				return;
			}
			findTicketTypeById = findTicketTypeById(id);
			if (findTicketTypeById == null) {
				System.out.println("����ĵ�Ӱid�����ڣ����������룡����");
				continue;
			}
			break;
		}
		System.out
				.println("id" + "\t" + "��Ӱ��" + "\t" + "�۸�" + "\t" + "��ʼʱ�� " + "\t\t\t" + "��Ӱʱ�� " + "\t\t" + "��Ӱʣ��Ʊ�� ");
		findTicketTypeById.showTickets();

		updateCol(findTicketTypeById);
		System.out.println("�޸���ϣ�����");
	}

	// �޸�
	private void updateCol(TicketType findTicketTypeById) {
		while (true) {
			String str = Util.inputStr("��ѡ��Ҫ�޸ĵ���Ŀ(exit���أ�ֻ���޸ļ۸񣬿�ʼʱ�䣬��Ӱʱ��)��");
			if (str.equals("exit")) {
				return;
			}
			if (str.equals("�۸�")) {
				Double price = Util.inputDouble("������۸�");
				findTicketTypeById.setPrice(price);
			}
			if (str.equals("��ʼʱ��")) {
				String time = inputTime();
				findTicketTypeById.setStartTime(time);
			}
			if (str.equals("��Ӱʱ��")) {
				String timeLong = timeLong();
				findTicketTypeById.setTimeLong(timeLong);
			}
			if (!str.equals("exit") && !str.equals("�۸�") && !str.equals("��ʼʱ��") && !str.equals("��Ӱʱ��")) {
				System.out.println("�������������������룡����");
				continue;
			}
			String fag = Util.inputStr("�޸ĳɹ����Ƿ�Ҫ�޸ģ�(Y-->�ǣ�����-->��)");
			if (fag.equals("Y")) {
				continue;
			} else {
				return;
			}
		}

	}

	// �鿴��Ӱ��ϸ��Ϣ
	public void showTickTypesById() {
		showAllTickTypes();
		int id;
		TicketType findTicketTypeById;
		while (true) {
			id = Util.inputInt("������Ҫ�鿴�ĵ�Ӱid(-1����)��");
			if (id == -1) {
				return;
			}
			findTicketTypeById = findTicketTypeById(id);
			if (findTicketTypeById == null) {
				System.out.println("����ĵ�Ӱid�����ڣ����������룡����");
				continue;
			}
			break;
		}
		System.out.println("******��Ӱ������Ϣ*******");
		System.out
				.println("id" + "\t" + "��Ӱ��" + "\t" + "�۸�" + "\t" + "��ʼʱ�� " + "\t\t\t" + "��Ӱʱ�� " + "\t\t" + "��Ӱʣ��Ʊ�� ");
		findTicketTypeById.showTickets();
		System.out.println("******��ӰƱ��Ϣ*******");
		System.out.println("id" + "\t" + "λ��" + "\t" + "��Ӱ��" + "\t" + "�۸�" + "\t" + "��ʼʱ�� " + "\t\t\t" + "��Ӱʱ�� "
				+ "\t\t" + "״̬" + "\t" + "Ԥ��ʱ��/����ʱ�� ");
		findTicketTypeById.showTicket();
	}

	public void showAllTickTypes() {
		System.out
				.println("id" + "\t" + "��Ӱ��" + "\t" + "�۸�" + "\t" + "��ʼʱ�� " + "\t\t\t" + "��Ӱʱ�� " + "\t\t" + "��Ӱʣ��Ʊ�� ");
		for (TicketType ticketType : ticketTypes) {
			ticketType.showTickets();
		}
	}

}
