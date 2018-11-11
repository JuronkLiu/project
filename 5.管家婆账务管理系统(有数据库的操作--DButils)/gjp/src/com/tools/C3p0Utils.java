package com.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @describe
 *
 * @author liuzhirong
 * @date 2018年8月29日---上午10:40:13
 */
public class C3p0Utils {

	/*
	 * 获取连接池
	 */
	static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

	/*
	 * 用Threadlocal存储conn 相当是个 map
	 */
	static ThreadLocal<Connection> comCon = new ThreadLocal<>();

	/**
	 * 获取当前线程（main线程）的conn
	 * @return
	 */
	public static Connection getCurrentConn() {
		
		//通过内部的线程唯一标识符 拿到的 key 获取conn
		Connection conn = comCon.get();
		
		// 判断是否为空
		if (conn == null) {
			//获取connection
			conn = getConn();
			// 存到 map中
			comCon.set(conn);
		}
		return conn;
	}

	/**
	 * 获取数据库的连接
	 * @return
	 */
	public static Connection getConn() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭数据库的连接
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void close(Connection conn, Statement st, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 开启事务
	 * @param conn
	 */
	public static void startTranscation(Connection conn) {

		if (conn != null) {
			try {
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
				comCon.remove();
			}
		}
	}

	/**
	 * 回滚的操作
	 * 
	 * @param conn
	 */
	public static void rollbace(Connection conn) {

		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
				comCon.remove();
			}
		}
	}
	
	/**
	 * 提交事务 
	 * 
	 * @param conn
	 */
	public static void commit(Connection conn) {
		
		if (conn != null) {
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				comCon.remove();
			}
		}
	}

}
