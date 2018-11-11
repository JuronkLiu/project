package com.utils;

import java.util.Scanner;

/**
 *@describe ������
 *
 *@author liuzhirong
 *@date 2018��8��13��---����11:33:07 
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
	
	public static String inputStr(String mes) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(mes);
			return scanner.next();
	}
}
