package com.lx.bean;

import java.util.HashSet;
import java.util.Set;

/**
 *@describe 用户实体类
 *
 *@author liuzhirong
 *@date 2018年8月20日---上午11:01:19 
*/
public class User {
	
	private String name;
	private String password;
	private boolean admin;
	private Set<Goods> userCart = new HashSet<>();
	
	
	public Set<Goods> getUserCart() {
		return userCart;
	}

	public void setUserCart(Set<Goods> userCart) {
		this.userCart = userCart;
	}

	public User() {
	}

	public User(String name, String password, boolean admin) {
		this.name = name;
		this.password = password;
		this.admin = admin;
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
	
	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		return true;
	}
	
	

}
