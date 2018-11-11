package com.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *@describe �û�ʵ��
 *
 *@author liuzhirong
 *@date 2018��8��13��---����11:26:37 
*/
public class User {
	
	private String name;	//�û���
	private String password;	//����
	
	private Book book = new Book();		//������Ķ����Ա�Ϊ�û�����鼮
	private List<Book> userbooks = new ArrayList<>();	//������ļ��ϣ����û������
	
	public User() {
	}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {	
		this.book = book;
		userbooks.add(book);	//���鼮��ӵ������
	}

	public List<Book> getUserbooks() {
		return userbooks;
	}
	public void setUserbooks(List<Book> userbooks) {
		this.userbooks = userbooks;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	/**
	 * ���û��������Ѱ�Ҷ�Ӧ�����Ķ���
	 * @param ���ܴ��������
	 * @return ���������
	 */
	public Book findBookName(String bn) {
		for (int i = 0; i < userbooks.size(); i++) {
			if (userbooks.get(i).getBname().equals(bn)) {
				return userbooks.get(i);
			}
		}
		return null;
	}
	
	/**
	 * ��ʾͼ��ݵ��鼮
	 */
	public void showBooks() {
		System.out.println("����\t����");
		for (Book book : userbooks) {
			System.out.println(book.getBname()+"\t"+book.getBnumber());
		}
	}
}
