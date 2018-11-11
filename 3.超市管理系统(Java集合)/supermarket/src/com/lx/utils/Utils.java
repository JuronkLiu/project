package com.lx.utils;

import java.util.Scanner;

/**
 *@describe ����̨������Ϣ������
 *
 *@author liuzhirong
 *@date 2018��8��20��---����11:00:30 
*/
public class Utils {

	public static int inputInt(String mes) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(mes);
			try {
				return scanner.nextInt();
			} catch (Exception e) {
				System.out.println("���������������룡����");
				continue;
			}
		}
	}
	
	public static Double inputDouble(String mes) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(mes);
			try {
				return scanner.nextDouble();
			} catch (Exception e) {
				System.out.println("���������������룡����");
				continue;
			}
		}
	}
	
	public static String inputStr(String mes) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(mes);
			return scanner.next();
	}
	
	
}
