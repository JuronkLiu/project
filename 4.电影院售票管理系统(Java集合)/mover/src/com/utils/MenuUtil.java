package com.utils;

import com.bean.User;

/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018��8��23��---����4:01:42 
*/
public class MenuUtil {

	public static void welcome() {
		System.out.println("***��ӭ��¼��Ӱ��Ʊϵͳ***");
		System.out.println("   1.�鿴��Ӱ");
		System.out.println("   2.��¼");
		System.out.println("   3.ע��");
	}

	public static void home(User user) {
		System.out.println("******��ӭ�û�"+user.getName()+"ʹ�õ�Ӱ��Ʊϵͳ******");
		System.out.println("   1.�鿴Ԥ���õĵ�ӰƱ");
		System.out.println("   2.Ԥ��");
		System.out.println("   3.����");
		System.out.println("   4.ȡ��Ԥ��");
		System.out.println("   5.�鿴�ѹ���ĵ�ӰƱ");
		System.out.println("   6.������һ��");
	}
	
	public static void adminHome(User user) {
		System.out.println("******��ӭ����Ա"+user.getName()+"��¼��Ӱ��Ʊ����ϵͳ******");
		System.out.println("   1.��ӵ�Ӱ");
		System.out.println("   2.ɾ����Ӱ");
		System.out.println("   3.�޸ĵ�Ӱ");
		System.out.println("   4.�鿴��Ӱ(����Ӱid�鿴)");
		System.out.println("   5.�鿴ȫ����Ӱ��Ϣ");
		System.out.println("   6.������һ��");
	}
}
