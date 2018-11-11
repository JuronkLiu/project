package com.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *@describe 用户实体
 *
 *@author liuzhirong
 *@date 2018年8月13日---上午11:26:37 
*/
public class User {
	
	private String name;	//用户名
	private String password;	//密码
	
	private Book book = new Book();		//创建书的对象，以便为用户添加书籍
	private List<Book> userbooks = new ArrayList<>();	//创建书的集合，即用户的书包
	
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
		userbooks.add(book);	//将书籍添加到书包里
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
	 * 在用户的书包里寻找对应书名的对象
	 * @param 接受传入的书名
	 * @return 返回书对象
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
	 * 显示图书馆的书籍
	 */
	public void showBooks() {
		System.out.println("书名\t数量");
		for (Book book : userbooks) {
			System.out.println(book.getBname()+"\t"+book.getBnumber());
		}
	}
}
