package com.bean;
/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018��8��13��---����2:42:38 
*/

import java.util.ArrayList;
import java.util.List;

public class Library {

	//ֻ��һ��ͼ��ݣ�����ֻ��ʵ����һ�Σ�ʹ�õ���ģʽ
	
	//ͼ���ȫ���鼮
	static List<Book> books = new ArrayList<>();
	
	//����-->����ʽ
	//1.˽�й�����
	private Library(){
	}
	
	//2.˽�С���̬����ֻ����һ��ʵ����
	private static Library intance = new Library();
	
	//3.�ṩ���еķ���������ͼ��ݶ���ʹ���ⲿ���Ե��ô˷�������ͼ���
	public static Library getIntance() {
		return intance;
	}
	
	//Ϊͼ�������鼮
	public List<Book> returnBooks() {
		books.add(new Book("java",10));
		books.add(new Book("c",10));
		books.add(new Book("c++",10));
		return books;
	}
	
	//����������ͼ��ݵ��鼮
	public Book findLibBook(String s) {
		for (Book book : books) {
			if (book.getBname().equals(s)) {
				return book;
			}
		}
		return null;
	}
	
	//��ʾͼ��ݵ��鼮
	public void showLibBooks() {
		System.out.println("����\t����");
		for (Book book : books) {
			System.out.println(book.getBname()+"\t"+book.getBnumber());
		}
	}
}
