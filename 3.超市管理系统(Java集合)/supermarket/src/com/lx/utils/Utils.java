package com.lx.utils;

import java.util.Scanner;

/**
 *@describe 控制台输入信息工具类
 *
 *@author liuzhirong
 *@date 2018年8月20日---上午11:00:30 
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
	
	public static Double inputDouble(String mes) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(mes);
			try {
				return scanner.nextDouble();
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
