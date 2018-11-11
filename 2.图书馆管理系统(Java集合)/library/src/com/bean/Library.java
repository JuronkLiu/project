package com.bean;
/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018年8月13日---下午2:42:38 
*/

import java.util.ArrayList;
import java.util.List;

public class Library {

	//只有一个图书馆，此类只能实例化一次，使用单例模式
	
	//图书馆全部书籍
	static List<Book> books = new ArrayList<>();
	
	//单例-->饿汉式
	//1.私有构造器
	private Library(){
	}
	
	//2.私有、静态对象，只能有一次实例化
	private static Library intance = new Library();
	
	//3.提供公有的方法，返回图书馆对象，使得外部可以调用此方法创建图书馆
	public static Library getIntance() {
		return intance;
	}
	
	//为图书馆添加书籍
	public List<Book> returnBooks() {
		books.add(new Book("java",10));
		books.add(new Book("c",10));
		books.add(new Book("c++",10));
		return books;
	}
	
	//按书名查找图书馆的书籍
	public Book findLibBook(String s) {
		for (Book book : books) {
			if (book.getBname().equals(s)) {
				return book;
			}
		}
		return null;
	}
	
	//显示图书馆的书籍
	public void showLibBooks() {
		System.out.println("书名\t数量");
		for (Book book : books) {
			System.out.println(book.getBname()+"\t"+book.getBnumber());
		}
	}
}
