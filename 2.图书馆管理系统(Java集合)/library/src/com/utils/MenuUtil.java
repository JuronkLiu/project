package com.utils;

import com.bean.User;

/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018��8��14��---����11:32:38 
*/
public class MenuUtil {

	/**
	 * ��¼ע�����
	 */
	public static  void welcome() {
		System.out.println("***��ӭʹ��ͼ�����ϵͳ***");
		System.out.println("1.��¼");
		System.out.println("2.ע��");
		System.out.println("3.�˳�ϵͳ");
	}
	
	/**
	 * ͼ�����ϵͳ������
	 * @param user
	 */
	public static void homePage(User user) {
		System.out.println("***��ӭ"+user.getName()+"ʹ��ͼ�����ϵͳ***");
		System.out.println("1.�鿴ͼ��");
		System.out.println("2.����");
		System.out.println("3.����");
		System.out.println("4.�鿴�����鼮");
		System.out.println("5.������һ��");
	}
}
