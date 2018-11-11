package com.lx.control;

import com.lx.control.Supermarket;
import com.lx.bean.Goods;
import com.lx.bean.User;
import com.lx.utils.Utils;

/**
 *@describe ����ʵ����
 *
 *@author liuzhirong
 *@date 2018��8��20��---����11:07:20 
*/
public class SupermarketImpl implements Supermarket {
	
	/**
	 * ��ʼ��������Ʒ��Ϣ
	 */
	public SupermarketImpl() {
		users.add(new User("1", "1", true));
		users.add(new User("2", "2", false));
		goods.add(new Goods(1, "�ֻ�", 1314d, 68));
		goods.add(new Goods(2, "����", 6868d, 66));
	}

	/**
	 * �û���¼ʵ��
	 */
	@Override
	public User userLogin() {

		User u =new User();
		
		String name = null;
		String password = null;
		boolean b = false;	//��¼�û��Ƿ����
		while (true) {
			name = Utils.inputStr("�������û���(exit����)��");
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
				password = Utils.inputStr("����������:");
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
	@Override
	public void userRegister() {
		String name;
		String password;
		f1:while (true) {
			name = Utils.inputStr("�������û���(exit����):");
			if (name.equals("exit")) {
				return;
			}
			for (User user : users) {
				if (user.getName().equals(name)) {
					System.out.println("--�û��Ѵ��ڣ�����������");
					continue f1;
				}
			} 
			password = Utils.inputStr("����������:");
			users.add(new User(name,password,false));
			System.out.println("ע��ɹ���");
			return;
		}
	}

	/**
	 * ��ʾ����ȫ����Ʒ��Ϣ
	 */
	@Override
	public void showGoods() {
		System.out.println("*******�����е���Ʒ��Ϣ����*********");
		System.out.println("��Ʒid\t��Ʒ����\t��Ʒ�۸�\t�������\t");
		for (Goods g : goods) {
			g.showGoods();
		}
	}

	/**
	 * Ϊ���������Ʒ
	 */
	@Override
	public void addGoods() {
		//��ȡ������Ʒ����id��Ϊ֮�������Ʒ��id������
		int maxId = 0;
		for (Goods g : goods) {
			if (g.getId() > maxId) {
				maxId = g.getId();
			}
		}
		System.out.println("*******�����Ʒ*********");
		String gName = Utils.inputStr("��������Ʒ��(exit����)��");
		if (gName.equals("exit") ) {
			return;
		}
		Double gPrice = Utils.inputDouble("��������Ʒ�۸�");
		int gNum = Utils.inputInt("��������Ʒ�Ŀ��������");
		goods.add(new Goods(maxId+1, gName, gPrice, gNum));
		System.out.println("��ӳɹ�������");
	}

	/**
	 * ɾ��������Ʒ
	 */
	@Override
	public void delGoods() {
		System.out.println("*******ɾ����Ʒ*********");
		while (true) {
			int gId = Utils.inputInt("������Ҫɾ������Ʒid(-1����)��");
			Goods findGoods = findGoods(gId);
			if (gId == -1) {
				return;
			}
			if (findGoods == null) {
				System.out.println("�������Ʒ�����ڣ����������룡����");
				continue;
			} else {
				goods.remove(findGoods);
				System.out.println("ɾ���ɹ�������");
			} 
			break;
		}
	}
	
	/**
	 * ������Ʒ��ʽѡ��
	 */
	@Override
	public void queryGoods() {
		System.out.println("*******������Ʒ*********");
		int inputInt = Utils.inputInt("��ѡ���ѯ��ʽ(1.��id������Ʒ;2.����Ʒ��������Ʒ;����-->����)��");
		if (inputInt == 1) {
			queryGoodsById();
		}else if (inputInt == 2) {
			queryGoodsByName();
		}else{
			return;
		}
	}

	/**
	 * �鿴����ĳ��Ʒ��Ϣ
	 */
	public void queryGoodsById() {
		while (true) {
			int gId = Utils.inputInt("������Ҫ���ҵ���Ʒid(-1����)��");
			Goods findGoods = findGoods(gId);
			if (gId == -1) {
				return;
			}
			
			if (findGoods == null) {
				System.out.println("�������Ʒ�����ڣ����������룡����");
				continue;
			} else {
				System.out.println("*******��������*******");
				System.out.println("��Ʒid\t��Ʒ����\t��Ʒ�۸�\t�������\t");
				findGoods.showGoods();
			} 
			break;
		}
	}

	/**
	 * ����Ʒ���鿴��Ʒ��Ϣ
	 */
	@Override
	public void queryGoodsByName() {
		while (true) {
			String gName = Utils.inputStr("��������Ҫ�ҵ���Ʒ����(exit����)��");
			if (gName.equals("exit")) {
				return;
			}
			Goods findGoodsByName = findGoodsByName(gName);
			if (goods.contains(findGoodsByName)) {
				System.out.println("*******��������*******");
				System.out.println("��Ʒid\t��Ʒ����\t��Ʒ�۸�\t�������\t");
				findGoodsByName.showGoods();
				return;
			} else {
				System.out.println("�������Ʒ�����ڣ����������룡����");
				continue;
			} 
		}
	}
	
	/**
	 * �޸ĳ�����Ʒ��Ϣ
	 */
	@Override
	public void updateGods() {
		System.out.println("*******�޸���Ʒ��Ϣ*********");
		int gId = 0;
		int gNum = 0;
		while (true) {
			gId = Utils.inputInt("������Ҫ�޸ĵ���Ʒid(-1����)��");
			Goods findGoods = findGoods(gId);
			if (gId == -1) {
				return;
			}
			if (findGoods == null) {
				System.out.println("�������Ʒ�����ڣ����������룡����");
				continue;
			} else {
				System.out.println("��Ʒid\t��Ʒ����\t��Ʒ�۸�\t�������\t");
				findGoods.showGoods();
				Double gPrice = Utils.inputDouble("������Ҫ�޸ĵļ۸�(-1����;-2����)��");
				if (gPrice == -1) {
					return;
				}
				if (gPrice == -2) {
					gNum = Utils.inputInt("������Ҫ�޸ĵ���Ʒ�������(-1����)��");
					if (gNum == -1) {
						return;
					}
					findGoods.setNumber(gNum);
					System.out.println("�޸ĳɹ�������");
					return;
				}
				findGoods.setPrice(gPrice);
				gNum = Utils.inputInt("������Ҫ�޸ĵ���Ʒ�������(-1����)��");
				if (gNum == -1) {
					return;
				}
				findGoods.setNumber(gNum);
				System.out.println("�޸ĳɹ�������");
				return;
			} 
		}
	}
	
	/**
	 * ��id������Ʒ��������Ʒ����
	 */
	public Goods findGoods(Integer id){
		for (Goods g : goods) {
			if (g.getId() == id) {
				return g;
			}
		}
		return null;
	}
	
	/**
	 * ����Ʒname������Ʒ��������Ʒ����
	 */
	public Goods findGoodsByName(String name){
		for (Goods g : goods) {
			if (g.getName().equals(name)) {
				return g;
			}
		}
		return null;
	}
}
