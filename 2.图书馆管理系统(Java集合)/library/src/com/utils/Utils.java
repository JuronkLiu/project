package com.utils;

import java.util.Scanner;

/**
 *@describe 工具类
 *
 *@author liuzhirong
 *@date 2018年8月13日---上午11:33:07 
*/
public class Utils {

	public static int inputInt(String mes) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(mes);
			try {
				return scanner.nextInt();
			} catch (Exception e) {
				System.out.println("输入有误！重新输入！！！");
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
