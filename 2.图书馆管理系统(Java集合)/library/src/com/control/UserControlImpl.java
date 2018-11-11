package com.control;

import com.bean.User;
import com.client.Menu;
import com.utils.Utils;

/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018��8��13��---����11:37:19 
*/
public class UserControlImpl implements UserControl{

	/**
	 * ��½
	 */
	@Override
	public User login() {
		
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
	 * ע��
	 */
	@Override
	public boolean register() {
		String name;
		String password;
		f1:while (true) {
			name = Utils.inputStr("�������û���(exit����):");
			if (name.equals("exit")) {
				return true;
			}
			for (User user : users) {
				if (user.getName().equals(name)) {
					System.out.println("--�û��Ѵ��ڣ�����������");
					continue f1;
				}
			} 
			password = Utils.inputStr("����������:");
			users.add(new User(name,password));
			System.out.println("ע��ɹ���");
			return false;
		}
		
	}

}
