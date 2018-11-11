package com.client;

import com.bean.User;
import com.control.BookControl;
import com.control.BookControlImpl;
import com.control.UserControl;
import com.control.UserControlImpl;
import com.utils.MenuUtil;
import com.utils.Utils;

/**
 *@describe ��ʾ����
 *
 *@author liuzhirong
 *@date 2018��8��13��---����11:34:20 
*/
public class Menu {

	/**
	 * ��½ע�����ѡ������
	 */
	public  static void welcome() {
		UserControl userControl = new UserControlImpl();
		while (true) {
			MenuUtil.welcome();
			int choose = Utils.inputInt("��ѡ��:");
			if (choose < 0 || choose > 3) {
				System.out.println("--ѡ����ڣ�");
				continue;
			}
			switch (choose) {
			case 1:
				User user = userControl.login();
				if (user == null) {
					System.out.println("��¼ʧ��");
				}else {
					homePage(user);
					return;
				}
				break;
			case 2:
				boolean reg = userControl.register();
				if (reg) {
					continue;
				}
				break;
			case 3:
				System.exit(0);
				break;
			}
		}
	}

	/**
	 * ����ͼ�����ϵͳ�������½���û�
	 * @param user	��½���û�
	 */
	private static void homePage(User user) {
		BookControl bControl = new BookControlImpl();
		while (true) {
			MenuUtil.homePage(user);
			int choose = Utils.inputInt("��ѡ��:");
			if (choose < 0 || choose > 5) {
				System.out.println("--ѡ����ڣ�");
				continue;
			} 
			switch (choose) {
			case 1:
				bControl.showBooks();
				break;
			case 2:
				bControl.borrowBooks(user);
				break;
			case 3:
				bControl.returnBooks(user);
				break;
			case 4:
				bControl.showMyBooks(user);
				break;
			case 5:
				welcome();
				break;
			}
		}
	}
	
}
