package com.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @describe
 *
 * @author liuzhirong
 * @date 2018年8月28日---上午10:00:13
 */
public class JDBCUtils {

	private static String DRIVER = null;
	private static String URL = null;
	private static String USERNAME = null;
	private static String PASSWORD = null;

	static {
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(new File("src/com/tools/jdbc.properties")));
			DRIVER = pro.getProperty("driver");
			URL = pro.getProperty("url");
			USERNAME = pro.getProperty("username");
			PASSWORD = pro.getProperty("password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 释放资源的方法 可变参数的设置(泛型)
	 * 
	 * @param arr
	 */
	public static <T extends AutoCloseable> void closeAll(T... arr) {
		for (T t : arr) {
			if (t != null) {
				try {
					t.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 释放资源的方法 可变参数的设置
	 * 
	 * @param arr
	 */
	public static void close(AutoCloseable... arr) {

		for (AutoCloseable t : arr) {

			if (t != null) {
				try {
					t.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
