package com.control;

import java.util.ArrayList;
import java.util.List;
import com.bean.Book;
import com.bean.Library;
import com.bean.User;
import com.utils.Utils;

/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018��8��13��---����11:37:50 
*/
public class BookControlImpl implements BookControl {
	
	//���ͼ������
	static Library library = Library.getIntance();
	static List<Book> books =library.returnBooks();
	
	static List<Book> mybooks =new ArrayList<>();	//�û����
	
	/**
	 * �鿴ͼ������
	 */
	@Override
	public void showBooks() {
		
		library.showLibBooks();	//��ʾͼ��ݵ���Դ
	}

	/**
	 * ����
	 */
	@Override
	public void borrowBooks(User user) {
		Book b = new Book();	//����ͼ����鼮�Ķ���
		Book mBook = new Book();	//�����û��鼮�Ķ���
		String bname;
		int bnum = 0;
		while (true ) {
			bname= Utils.inputStr("�������������鼮(exit����):");
			if (bname.equals("exit")) {
				return;
			}
			b = library.findLibBook(bname);
			if (b == null) {
				System.out.println("������鼮�����ڣ����������룡����");
				continue;
			}
			while (true) {
				bnum = Utils.inputInt("����������������( < 1  ����):");
				if (bnum < 1) {
					return;
				}
				if (b.getBnumber() < bnum) {
					System.out.println("�����鼮�������������������룡����");
					continue;
				}
				break;
			}
			break;
		}
		mBook = user.findBookName(bname);
		//�ж��û��Ƿ��ѽ����
		if (mBook != null) {
			mBook.setBnumber(mBook.getBnumber() + bnum);
		}else{
			user.setBook(new Book(bname, bnum));	//����һ������Ķ���b�����µĶ���
		}
		b.setBnumber(b.getBnumber() - bnum);	//���������������ϵ��鼮����
		System.out.println("����ɹ�");
	}

	/**
	 * �鿴�û��Լ������
	 */
	@Override
	public void showMyBooks(User user) {
		user.showBooks();
	}

	/**
	 * ����
	 */
	@Override
	public void returnBooks(User user) {
		Book b = new Book();
		mybooks = user.getUserbooks();	//����û������
		String bn;
		int bm = 0;
		while (true) {
			bn= Utils.inputStr("����������Ҫ������(exit����)��");
			if (bn.equals("exit")) {
				return;
			}
			b = user.findBookName(bn);
			if (b == null) {
				System.out.println("��û�н��Ȿ�飡���������룡����");
				continue;
			}
			while (true) {
				bm = Utils.inputInt("����������Ҫ��������( < 1  ����)��");
				if (bm < 1) {
					return;
				}
				if (b.getBnumber() < bm) {
					System.out.println("�����������������룡����");
					continue;
				}
				break;
			}
			break;
		}
		b.setBnumber(b.getBnumber() - bm);	//�����û�����е��鼮����
		setBooksNum(bn,bm);	//����ͼ��ݵ��������
		System.out.println("����ɹ�");
	}

	/**
	 * ����ͼ������
	 * @param bn	����
	 * @param bm	���������
	 */
	private void setBooksNum(String bn, int bm) {
		Book b = library.findLibBook(bn);
		b.setBnumber(b.getBnumber() + bm);
	}

}
