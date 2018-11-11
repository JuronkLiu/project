package com.utils;

import java.util.Scanner;

/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018��8��23��---����3:52:59 
*/
public class Util {

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
	
	public static Long inputLong(String mes) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(mes);
			try {
				return scanner.nextLong();
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
