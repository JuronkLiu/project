package com.bean;
/**
 *@describe ͼ��ʵ��
 *
 *@author liuzhirong
 *@date 2018��8��13��---����11:28:56 
*/
public class Book {

	private String bname;	//����
	private int bnumber;	//�������
	
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getBnumber() {
		return bnumber;
	}
	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}
	public Book() {
	}
	public Book(String bname, int bnumber) {
		this.bname = bname;
		this.bnumber = bnumber;
	}
	public Book(String bname) {
		this.bname = bname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bname == null) ? 0 : bname.hashCode());
		result = prime * result + bnumber;
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
		Book other = (Book) obj;
		if (bname == null) {
			if (other.bname != null)
				return false;
		} else if (!bname.equals(other.bname))
			return false;
		if (bnumber != other.bnumber)
			return false;
		return true;
	}
	
}
