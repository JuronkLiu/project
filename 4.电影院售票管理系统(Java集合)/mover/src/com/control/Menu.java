package com.control;

import com.bean.User;
import com.utils.MenuUtil;
import com.utils.Util;

/**
 * @describe ������ڿ���
 *
 * @author liuzhirong
 * @date 2018��8��23��---����4:10:16
 */
public class Menu {

	static Mover mover = new Mover();

	// ��¼ע��������
	public static void welcome() {
		while (true) {
			MenuUtil.welcome();
			int inputInt = Util.inputInt("����������ѡ��");
			switch (inputInt) {
			case 1:
				mover.showTickets();
				break;
			case 2:
				User user = mover.userLogin();
				if (user == null) {
					System.out.println("��¼ʧ��");
				} else if (user.isTag()) {
					adminHome(user,mover);
				} else {
					home(user);
				}
				break;
			case 3:
				mover.userRegister();
				break;

			default:
				System.out.println("�������ѡ����ڣ����������룡����");
				break;
			}
		}
	}

	private static void adminHome(User user, Mover m) {
		while (true) {
			MenuUtil.adminHome(user);
			int inputInt = Util.inputInt("����������ѡ��");
			switch (inputInt) {
			case 1:
				mover.addTickTypes();
				break;
			case 2:
				mover.delTickTypes();
				break;
			case 3:
				mover.updateTickTypes();
				break;
			case 4:
				mover.showTickTypesById();
				break;
			case 5:
				mover.showAllTickTypes();
				break;
			case 6:
				welcome();
				break;
			default:
				System.out.println("�������ѡ����ڣ����������룡����");
				break;
			}
		}
		
	}

	private static void home(User user) {
		while (true) {
			MenuUtil.home(user);
			int inputInt = Util.inputInt("����������ѡ��");
			switch (inputInt) {
			case 1:
				user.showBuyBefore();
				break;
			case 2:
				user.buyBefore(mover);
				break;
			case 3:
				user.buy(mover);
				break;
			case 4:
				user.removeBuyBefore(mover);
				break;
			case 5:
				user.showBuy();
				break;
			case 6:
				welcome();
				break;
			default:
				System.out.println("�������ѡ����ڣ����������룡����");
				break;
			}
		}
	}

}
