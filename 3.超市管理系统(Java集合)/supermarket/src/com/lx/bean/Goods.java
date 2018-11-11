package com.lx.bean;
/**
 *@describe 商品实体类
 *
 *@author liuzhirong
 *@date 2018年8月20日---上午11:01:03 
*/
public class Goods {

	private Integer id;
	private String name;
	private Double price;
	private Integer number;
	

	public Goods() {
	}

	public Goods(Integer id, String name, Double price,Integer number) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.number = number;
	}
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Goods other = (Goods) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", number=" + number + "]";
	}
	
	public void showGoods(){
		System.out.println(getId()+"\t"+getName()+"\t"+getPrice()+"\t"+getNumber());
	}
}
