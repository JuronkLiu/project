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
 * @date 2018��8��29��---����10:40:13
 */
public class C3p0Utils {

	/*
	 * ��ȡ���ӳ�
	 */
	static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

	/*
	 * ��Threadlocal�洢conn �൱�Ǹ� map
	 */
	static ThreadLocal<Connection> comCon = new ThreadLocal<>();

	/**
	 * ��ȡ��ǰ�̣߳�main�̣߳���conn
	 * @return
	 */
	public static Connection getCurrentConn() {
		
		//ͨ���ڲ����߳�Ψһ��ʶ�� �õ��� key ��ȡconn
		Connection conn = comCon.get();
		
		// �ж��Ƿ�Ϊ��
		if (conn == null) {
			//��ȡconnection
			conn = getConn();
			// �浽 map��
			comCon.set(conn);
		}
		return conn;
	}

	/**
	 * ��ȡ���ݿ������
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
	 * �ر����ݿ������
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
	 * ��������
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
	 * �ع��Ĳ���
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
	 * �ύ���� 
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
