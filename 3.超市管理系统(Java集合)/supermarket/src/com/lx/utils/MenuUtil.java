package com.lx.utils;

import com.lx.bean.User;

/**
 *@describe ������
 *
 *@author liuzhirong
 *@date 2018��8��20��---����11:00:05 
*/
public class MenuUtil {

	/**
	 * ��¼ע�����
	 */
	public static  void welcome() {
		System.out.println("***��ӭ��¼���й���ϵͳ***");
		System.out.println("   1.��¼");
		System.out.println("   2.ע��");
		System.out.println("   3.�˳�ϵͳ");
		
	}
	
	/**
	 * ���й���ϵͳ������---����Ա
	 * @param user
	 */
	public static void adminHome(User user) {
		System.out.println("******��ӭ����Ա"+user.getName()+"ʹ�ó��й���ϵͳ******");
		System.out.println("      1.�鿴��Ʒȫ����Ϣ");
		System.out.println("      2.�����Ʒ��Ϣ");
		System.out.println("      3.ɾ����Ʒ��Ϣ(��Ʒid����)");
		System.out.println("      4.�鿴��Ʒ��Ϣ");
		System.out.println("      5.�޸���Ʒ��Ϣ(��Ʒid����)");
		System.out.println("      6.������һ��");
	}
	
	/**
	 * ���й���ϵͳ������---��ͨ�û�
	 * @param user
	 */
	public static void userHome(User user) {
		System.out.println("******��ӭ�û�"+user.getName()+"ʹ�ó��й���ϵͳ******");
		System.out.println("      1.�䳬��");
		System.out.println("      2.Ѱ����Ʒ");
		System.out.println("      3.�����Ʒ�����ﳵ(��Ʒid����)");
		System.out.println("      4.ɾ�����ﳵ����Ʒ��Ϣ(��Ʒid����)");
		System.out.println("      5.��չ��ﳵ");
		System.out.println("      6.�鿴���ﳵĳ��Ʒ����Ϣ(��Ʒid����)");
		System.out.println("      7.�޸Ĺ��ﳵ����Ʒ��Ϣ(��Ʒid����)");
		System.out.println("      8.�鿴�ҵĹ��ﳵ");
		System.out.println("      9.֧��");
		System.out.println("      10.������һ��");
	}
}
