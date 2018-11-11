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
 *@date 2018年8月13日---上午11:37:50 
*/
public class BookControlImpl implements BookControl {
	
	//获得图书馆书架
	static Library library = Library.getIntance();
	static List<Book> books =library.returnBooks();
	
	static List<Book> mybooks =new ArrayList<>();	//用户书包
	
	/**
	 * 查看图书馆书架
	 */
	@Override
	public void showBooks() {
		
		library.showLibBooks();	//显示图书馆的资源
	}

	/**
	 * 借书
	 */
	@Override
	public void borrowBooks(User user) {
		Book b = new Book();	//接收图书馆书籍的对象
		Book mBook = new Book();	//接收用户书籍的对象
		String bname;
		int bnum = 0;
		while (true ) {
			bname= Utils.inputStr("请输入你想借的书籍(exit返回):");
			if (bname.equals("exit")) {
				return;
			}
			b = library.findLibBook(bname);
			if (b == null) {
				System.out.println("输入的书籍不存在！请重新输入！！！");
				continue;
			}
			while (true) {
				bnum = Utils.inputInt("请输入你想借的数量( < 1  返回):");
				if (bnum < 1) {
					return;
				}
				if (b.getBnumber() < bnum) {
					System.out.println("所借书籍数量不够！请重新输入！！！");
					continue;
				}
				break;
			}
			break;
		}
		mBook = user.findBookName(bname);
		//判断用户是否已借该书
		if (mBook != null) {
			mBook.setBnumber(mBook.getBnumber() + bnum);
		}else{
			user.setBook(new Book(bname, bnum));	//设置一个借书的对象，b接受新的对象
		}
		b.setBnumber(b.getBnumber() - bnum);	//借书完后，设置书架上的书籍数量
		System.out.println("借书成功");
	}

	/**
	 * 查看用户自己的书包
	 */
	@Override
	public void showMyBooks(User user) {
		user.showBooks();
	}

	/**
	 * 还书
	 */
	@Override
	public void returnBooks(User user) {
		Book b = new Book();
		mybooks = user.getUserbooks();	//获得用户的书包
		String bn;
		int bm = 0;
		while (true) {
			bn= Utils.inputStr("请输入你想要还的书(exit返回)：");
			if (bn.equals("exit")) {
				return;
			}
			b = user.findBookName(bn);
			if (b == null) {
				System.out.println("你没有借这本书！请重新输入！！！");
				continue;
			}
			while (true) {
				bm = Utils.inputInt("请输入你想要还的数量( < 1  返回)：");
				if (bm < 1) {
					return;
				}
				if (b.getBnumber() < bm) {
					System.out.println("数量有误！请重新输入！！！");
					continue;
				}
				break;
			}
			break;
		}
		b.setBnumber(b.getBnumber() - bm);	//更改用户书包中的书籍数量
		setBooksNum(bn,bm);	//更改图书馆的书架数量
		System.out.println("还书成功");
	}

	/**
	 * 更改图书馆书架
	 * @param bn	书名
	 * @param bm	还书的数量
	 */
	private void setBooksNum(String bn, int bm) {
		Book b = library.findLibBook(bn);
		b.setBnumber(b.getBnumber() + bm);
	}

}
