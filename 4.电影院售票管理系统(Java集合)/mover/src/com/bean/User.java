package com.bean;
/**
 *@describe �û�
 *
 *@author liuzhirong
 *@date 2018��8��23��---����3:53:29 
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
	 * ��ʾԤ����Ϣ
	 */
	public void showBuyBefore() {
		if (buyBefore.size() == 0) {
			System.out.println("����ʱû��Ԥ����Ϣ����Ԥ����");
			return;
		}
		System.out.println("id" + "\t\t" + "λ��" + "\t" + "��Ӱ��" + "\t" + "�۸�" + "\t" + "��ʼʱ�� " + "\t\t\t" + "��Ӱʱ�� "
				+ "\t\t" + "״̬" + "\t" + "Ԥ��ʱ��");
		for (Ticket ticket : buyBefore) {
			ticket.show();
		}
	}
	
	/**
	 * Ԥ����ӰƱ
	 * @param mover
	 */
	public void buyBefore(Mover mover) {
		mover.showAllTickTypes();
		TicketType findTicketType;
		int id = 0;
		Long rowCol;
		Ticket findTicket;
		while (true) {
			id = Util.inputInt("��ѡ����ҪԤ���ĵ�Ӱ(-1����)��");
			if (id == -1) {
				return;
			}
			findTicketType = findTicketType(mover, id);
			if (findTicketType == null) {
				System.out.println("��ѡ��ĵ�Ӱ�����ڣ����������룡����");
				continue;
			}
			System.out.println("id" + "\t\t" + "λ��" + "\t" + "��Ӱ��" + "\t" + "�۸�" + "\t" + "��ʼʱ�� " + "\t\t\t" + "��Ӱʱ�� "
					+ "\t\t" + "״̬" + "\t" + "Ԥ��ʱ��/����ʱ�� " );
			//��ʾλ��
			findTicketType.showTicket();
			
			while (true) {
				rowCol = Util.inputLong("��ѡ����ҪԤ����λ��(-1�˳�)��");
				if (rowCol == -1) {
					return;
				}
				findTicket = findTicket(findTicketType, rowCol);
				if (findTicket == null) {
					System.out.println("��ѡ���λ�ò����ڣ����������룡����");
					continue;
				}
				if (findTicket.getState().equals("��Ԥ��")) {
					System.out.println("��Ʊ�ѱ�Ԥ�����޷�Ԥ������������������");
					continue;
				}
				if (findTicket.getState().equals("�ѹ���")) {
					System.out.println("��Ʊ�ѱ������޷�Ԥ������������������");
					continue;
				}
				break;
			}
			break;
		}
		String str = Util.inputStr("ȷ��Ԥ��:Y-->��;����-->����");
		if (str.equals("Y")) {
			findTicket.setName(name);
			buyBefore.add(findTicket);
			findTicket.setState(1);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			findTicket.setTime(sdf.format(date));
			findTicketType.setTotal(findTicketType.getTotal()-1);
			System.out.println("Ԥ���ɹ�");
			return;
		}
		System.out.println("Ԥ��ʧ�ܣ�");
		return;
	}
	
	//Ѱ�ҵ�ӰƱ��λ��
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
	 * ȡ��Ԥ��
	 * @param mover
	 */
	public void removeBuyBefore(Mover mover) {
		if (buyBefore.size() == 0) {
			System.out.println("����ʱû��Ԥ����Ϣ��ȡ��Ԥ����Ϣʧ�ܣ�����");
			return;
		}
		showBuyBefore();
		Ticket findTicket;
		Long id = 0L;
		while (true) {
			id = Util.inputLong("��ѡ����Ҫȡ��Ԥ����λ��(-1����)��");
			if (id == -1) {
				return;
			}
			findTicket = findMyTicket(id);
			if (findTicket == null) {
				System.out.println("��ѡ���λ�ò����ڣ����������룡����");
				continue;
			}
			break;
		}
		String str = Util.inputStr("ȷ��ȡ��Ԥ��:Y-->��;����-->����");
		if (str.equals("Y")) {
			buyBefore.remove(findTicket);
			findTicket.setState(0);
			findTicket.setTime(null);
			mover.findTicketTypeByName(findTicket.getName()).setTotal(mover.findTicketTypeByName(findTicket.getName()).getTotal() + 1);;
			System.out.println("ȡ��Ԥ���ɹ���");
			return;
		}
		System.out.println("ȡ��Ԥ��ʧ�ܣ�");
		return;
	}
	
	/**
	 * ����Ԥ���ĵ�ӰƱ
	 * @param mover
	 */
	public void buy(Mover mover) {
		if (buyBefore.size() == 0) {
			System.out.println("����ʱû��Ԥ����Ϣ���޷�������Ԥ��");
			return;
		}
		showBuyBefore();
		Ticket findTicket;
		Long id = 0L;
		while (true) {
			id = Util.inputLong("��ѡ����Ҫ�����λ��(-1����)��");
			if (id == -1) {
				return;
			}
			findTicket = findMyTicket(id);
			if (findTicket == null) {
				System.out.println("��ѡ���λ�ò����ڣ����������룡����");
				continue;
			}
			break;
		}
		String str = Util.inputStr("ȷ������:Y-->��;����-->����");
		if (str.equals("Y")) {
			buyBefore.remove(findTicket);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyy.MM.dd HH:mm:ss");
			findTicket.setTime(sdf.format(date));
			buyAfter.add(findTicket);
			findTicket.setState(2);
			System.out.println("����ɹ���");
			return;
		}
		System.out.println("����ʧ�ܣ�");
		return;
	}
	
	/**
	 * ��ʾ����ĵ�ӰƱ
	 */
	public void showBuy() {
		if (buyAfter.size() == 0) {
			System.out.println("����ʱû�й�����Ϣ����ȥ�����ӰƱ");
			return;
		}
		System.out.println("id" + "\t\t" + "λ��" + "\t" + "��Ӱ��" + "\t" + "�۸�" + "\t" + "��ʼʱ�� " + "\t\t\t" + "��Ӱʱ�� "
				+ "\t\t" + "״̬" + "\t" + "Ԥ��ʱ��/����ʱ�� ");
		for (Ticket ticket : buyAfter) {
			ticket.show();
		}
	}
	
	/**
	 * ���ҵ�Ӱ���
	 * @param mover  ��Ӱ
	 * @param id  ��Ӱ���id
	 * @return  ��Ӱ���
	 */
	public TicketType findTicketType(Mover mover, int id){
		TicketType findTicketTypeById = mover.findTicketTypeById(id);
		if (findTicketTypeById != null) {
			return findTicketTypeById;
		}
		return null;
	}
	
	/**
	 * ����Ԥ���ĵ�ӰƱ
	 * @param id ��ӰƱ��id
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
