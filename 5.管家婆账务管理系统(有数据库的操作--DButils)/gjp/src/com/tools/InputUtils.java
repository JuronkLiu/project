package com.tools;

import java.util.Scanner;

/**
 * @describe
 *
 * @author liuzhirong
 * @date 2018��8��29��---����5:22:25
 */
public class InputUtils {

	public static Integer inputInt(String mes) {
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

	public static String inputString(String mes) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(mes);
		return scanner.nextLine();
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
}
