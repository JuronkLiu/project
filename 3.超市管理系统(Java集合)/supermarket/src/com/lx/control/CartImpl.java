package com.lx.control;

import com.lx.bean.Goods;
import com.lx.bean.User;
import com.lx.utils.Utils;

/**
 *@describe ���ﳵʵ����
 *
 *@author liuzhirong
 *@date 2018��8��20��---����11:07:04 
*/
public class CartImpl implements Cart {

	/**
	 * �����Ʒ�����ﳵ
	 */
	@Override
	public void addCart(Supermarket supermarket,User user) {
		int gId;
		int gNum;
		Goods findGoods;
		Goods findCartGoods;
		System.out.println("******�����Ʒ�����ﳵ******");
		while (true) {
			gId = Utils.inputInt("��������Ҫ�������Ʒid(-1����)��");
			findGoods = supermarket.findGoods(gId);
			findCartGoods = findCartGoods(gId, user);
			if (gId == -1) {
				return;
			}
			if (findGoods == null) {
				System.out.println("��Ǹ���������޴���Ʒ�����������룡����");
				continue;
			} 
			while (true) {
				gNum = Utils.inputInt("��������Ҫ����Ĵ���Ʒ������(-1����)��");
				if (gNum == -1) {
					return;
				}
				if (findGoods.getNumber() < gNum) {
					System.out.println("������Ҫ����Ʒ������治�㣡���������룡����");
					continue;
				} 
				if (user.getUserCart().contains(findCartGoods)) {
					findCartGoods.setNumber(findCartGoods.getNumber() + gNum);
					System.out.println("��ӳɹ�������");
					return;
				}
				user.getUserCart().add(new Goods(findGoods.getId(), findGoods.getName(), findGoods.getPrice(), gNum));
				System.out.println("��ӳɹ�������");
				return;
			}
		}
		
	}

	/**
	 * ɾ�����ﳵ����Ʒ
	 */
	@Override
	public void delCart(Supermarket supermarket,User user) {
		int gId;
		Goods findCartGoods;
		System.out.println("******ɾ�����ﳵ��ĳ��Ʒ******");
		showMyCart(user);
		while (true) {
			gId = Utils.inputInt("��������Ҫɾ�����ﳵ����Ʒ��id(-1����)��");
			if (gId == -1) {
				System.out.println("ɾ��ʧ�ܣ�����");
				return;
			}
			findCartGoods = findCartGoods(gId, user);
			if (findCartGoods == null) {
				System.out.println("���ﳵ�޴���Ʒ�����������룡����");
				continue;
			} 
			user.getUserCart().remove(findCartGoods);
			System.out.println("ɾ���ɹ�������");
			return;
		}
	}

	/**
	 * ��չ��ﳵ
	 */
	@Override
	public void delAllCart(User user) {
		System.out.println("******��չ��ﳵ******");
		
		String isf = Utils.inputStr("�Ƿ���չ��ﳵ(y-->��;����-->����)������");
		if (isf.equals("y")) {
			user.getUserCart().clear();
			if (user.getUserCart().size() == 0) {
				System.out.println("���ﳵ��ճɹ�������");
				return;
			}
		}
		System.out.println("���ﳵ���ʧ�ܣ�����");
	}

	/**
	 * �鿴���ﳵĳ��Ʒ����Ϣ
	 */
	@Override
	public void queryCart(User user) {
		int gId;
		Goods g;
		System.out.println("*****�鿴���ﳵĳ��Ʒ����Ϣ******");
		while (true) {
			gId = Utils.inputInt("��������Ҫ�鿴���ﳵ����Ʒ��id(-1����)��");
			if (gId == -1) {
				System.out.println("�鿴ʧ��");
				return;
			}
			g = findCartGoods(gId, user);
			if (g == null) {
				System.out.println("���ﳵ�޴���Ʒ�����������룡����");
				continue;
			} 
			
			System.out.println("��Ʒid\t��Ʒ����\t��Ʒ�۸�\t��������\t���");
			System.out.println(g.getId()+"\t"+g.getName()+"\t"+g.getPrice()+"\t"+g.getNumber()+"\t"+g.getPrice()*g.getNumber());
			return;
		}
	}

	/**
	 * �޸Ĺ��ﳵ��Ʒ������
	 */
	@Override
	public void updateCart(Supermarket supermarket,User user) {
		int gId;
		int gNum;
		System.out.println("*****�޸Ĺ��ﳵ��Ʒ������******");
		showMyCart(user);
		Goods findCartGoods;
		while (true) {
			gId = Utils.inputInt("��������Ҫ�޸Ĺ��ﳵ����Ʒ��id(-1����)��");
			if (gId == -1) {
				System.out.println("�޸�ʧ��");
				return;
			}
			findCartGoods = findCartGoods(gId, user);
			if (findCartGoods == null) {
				System.out.println("���ﳵ�޴���Ʒ�����������룡����");
				continue;
			} 
			while (true ) {
				gNum = Utils.inputInt("��������Ҫ�޸ĵ���Ʒ����(-1����)��");
				if (gNum == -1) {
					System.out.println("�޸�ʧ��");
					return;
				}
				if (gNum > supermarket.findGoods(gId).getNumber()) {
					System.out.println("���п�治�㣡���������룡����");
					continue;
				} 
				findCartGoods.setNumber(gNum);
				System.out.println("�޸ĳɹ�������");
				return;
			}
		}
	}

	/**
	 * ��ʾ���ﳵ����Ʒ��Ϣ
	 */
	@Override
	public Double showMyCart(User user) {
		Double sum = 0.0;
		System.out.println("******�ҵĹ��ﳵ******");
		System.out.println("��Ʒid\t��Ʒ����\t��Ʒ�۸�\t��������\t���");
		for (Goods g : user.getUserCart()) {
			System.out.println(g.getId()+"\t"+g.getName()+"\t"+g.getPrice()+"\t"+g.getNumber()+"\t"+g.getPrice()*g.getNumber());
			sum += g.getPrice()*g.getNumber();
		}
		System.out.println("�ܽ�"+ sum);
		return sum;
	}

	/**
	 * Ϊ���ﳵ��
	 */
	@Override
	public void pay(Supermarket supermarket,User user) {
		if (user.getUserCart().size() == 0) {
			System.out.println("���ﳵΪ�գ�����֧������ȥ�����Ʒ�����ﳵ�ɣ�����");
			System.out.println("ѡ��3���������Ʒ�����ﳵ!!!");
			return;
		}
		Double sumMoney = showMyCart(user);
		System.out.println("********֧��********");
		String s = Utils.inputStr("�Ƿ�֧��(y-->��;����-->����)������:");
		int gId;
		if (s.equals("y")) {
			//�жϵ�ǰ�������Ʒ�����볬�п�������
			for (Goods g : user.getUserCart()) {
				gId = g.getId();
				if (g.getNumber() > supermarket.findGoods(gId).getNumber()) {
					System.out.println("����Ʒ:"+ g.getId() +",��治�㣡�޷�֧�������޸�����������");
					return;
				}
			}
			boolean payWay = payWay(sumMoney);
			if (payWay) {
				//ѭ��ɾ�����ﳵ
				while (true) {
					for (Goods g : user.getUserCart()) {
						gId = g.getId();
						supermarket.findGoods(gId).setNumber(supermarket.findGoods(gId).getNumber() - g.getNumber());
						user.getUserCart().remove(g);
						break;
					}
					if (user.getUserCart().size() == 0) {
						System.out.println("֧���ɹ�������");
						return;
					}
				}
			}
		}
		System.out.println("֧��ʧ��");
	}

	/**
	 * ֧����ʽ
	 */
	public boolean payWay(Double m){
		String payWay = Utils.inputStr("��ѡ��֧����ʽ(1:΢�ţ�2:֧������3���ֽ�����-->����)��");
		switch (payWay) {
		case "1":
			System.out.println("   ***΢��֧��***");
			break;
		case "2":
			System.out.println("   ***֧����֧��***");
			break;
		case "3":
			System.out.println("   ***�ֽ�֧��***");
			break;
		default:
			return false;
		}
		Double money;
		while (true) {
			money = Utils.inputDouble("��������(-1���˳�֧��)��");
			if (money == -1) {
				return false;
			}
			if (m > money) {
				System.out.println("���㣡���������������");
				continue;
			}
			break;
		}
		if (m <= money) {
			System.out.println("���㣺" + (money-m));
		}
		return true;
	}
	/**
	 * ���ҹ��ﳵ����Ʒ��������Ʒ����
	 * @param id
	 * @param user
	 * @return
	 */
	public Goods findCartGoods(int id,User user) {
		for (Goods g : user.getUserCart()) {
			if (g.getId() == id) {
				return g;
			}
		}
		return null;
	}
}
