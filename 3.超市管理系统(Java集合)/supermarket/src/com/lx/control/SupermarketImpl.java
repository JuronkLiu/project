package com.lx.control;

import com.lx.control.Supermarket;
import com.lx.bean.Goods;
import com.lx.bean.User;
import com.lx.utils.Utils;

/**
 *@describe 超市实现类
 *
 *@author liuzhirong
 *@date 2018年8月20日---上午11:07:20 
*/
public class SupermarketImpl implements Supermarket {
	
	/**
	 * 初始化超市商品信息
	 */
	public SupermarketImpl() {
		users.add(new User("1", "1", true));
		users.add(new User("2", "2", false));
		goods.add(new Goods(1, "手机", 1314d, 68));
		goods.add(new Goods(2, "电脑", 6868d, 66));
	}

	/**
	 * 用户登录实现
	 */
	@Override
	public User userLogin() {

		User u =new User();
		
		String name = null;
		String password = null;
		boolean b = false;	//记录用户是否存在
		while (true) {
			name = Utils.inputStr("请输入用户名(exit返回)：");
			if (name.equals("exit")) {
				Menu.welcome();
			}
			for (User user : users) {
				if (user.getName().equals(name)) {
					u = user;
					b = true;
					break;
				}
			}
			if (!b) {
				System.out.println("用户不存在！请重新输入");
				continue;
			}
			while (true) {
				password = Utils.inputStr("请输入密码:");
				if (u.getPassword().equals(password)) {
					return u;
				} else {
					System.out.println("密码错误！");
					continue;
				} 
			}
		}
	}

	/**
	 * 用户注册实现
	 */
	@Override
	public void userRegister() {
		String name;
		String password;
		f1:while (true) {
			name = Utils.inputStr("请输入用户名(exit返回):");
			if (name.equals("exit")) {
				return;
			}
			for (User user : users) {
				if (user.getName().equals(name)) {
					System.out.println("--用户已存在！请重新输入");
					continue f1;
				}
			} 
			password = Utils.inputStr("请输入密码:");
			users.add(new User(name,password,false));
			System.out.println("注册成功！");
			return;
		}
	}

	/**
	 * 显示超市全部商品信息
	 */
	@Override
	public void showGoods() {
		System.out.println("*******本超市的商品信息如下*********");
		System.out.println("商品id\t商品名称\t商品价格\t库存数量\t");
		for (Goods g : goods) {
			g.showGoods();
		}
	}

	/**
	 * 为超市添加商品
	 */
	@Override
	public void addGoods() {
		//获取最大的商品编码id，为之后添加商品的id做基础
		int maxId = 0;
		for (Goods g : goods) {
			if (g.getId() > maxId) {
				maxId = g.getId();
			}
		}
		System.out.println("*******添加商品*********");
		String gName = Utils.inputStr("请输入商品名(exit返回)：");
		if (gName.equals("exit") ) {
			return;
		}
		Double gPrice = Utils.inputDouble("请输入商品价格：");
		int gNum = Utils.inputInt("请输入商品的库存数量：");
		goods.add(new Goods(maxId+1, gName, gPrice, gNum));
		System.out.println("添加成功！！！");
	}

	/**
	 * 删除超市商品
	 */
	@Override
	public void delGoods() {
		System.out.println("*******删除商品*********");
		while (true) {
			int gId = Utils.inputInt("请输入要删除的商品id(-1返回)：");
			Goods findGoods = findGoods(gId);
			if (gId == -1) {
				return;
			}
			if (findGoods == null) {
				System.out.println("输入的商品不存在！请重新输入！！！");
				continue;
			} else {
				goods.remove(findGoods);
				System.out.println("删除成功！！！");
			} 
			break;
		}
	}
	
	/**
	 * 查找商品方式选择
	 */
	@Override
	public void queryGoods() {
		System.out.println("*******查找商品*********");
		int inputInt = Utils.inputInt("请选择查询方式(1.按id查找商品;2.按商品名查找商品;其他-->返回)：");
		if (inputInt == 1) {
			queryGoodsById();
		}else if (inputInt == 2) {
			queryGoodsByName();
		}else{
			return;
		}
	}

	/**
	 * 查看超市某商品信息
	 */
	public void queryGoodsById() {
		while (true) {
			int gId = Utils.inputInt("请输入要查找的商品id(-1返回)：");
			Goods findGoods = findGoods(gId);
			if (gId == -1) {
				return;
			}
			
			if (findGoods == null) {
				System.out.println("输入的商品不存在！请重新输入！！！");
				continue;
			} else {
				System.out.println("*******查找如下*******");
				System.out.println("商品id\t商品名称\t商品价格\t库存数量\t");
				findGoods.showGoods();
			} 
			break;
		}
	}

	/**
	 * 按商品名查看商品信息
	 */
	@Override
	public void queryGoodsByName() {
		while (true) {
			String gName = Utils.inputStr("请输入您要找的商品名称(exit返回)：");
			if (gName.equals("exit")) {
				return;
			}
			Goods findGoodsByName = findGoodsByName(gName);
			if (goods.contains(findGoodsByName)) {
				System.out.println("*******查找如下*******");
				System.out.println("商品id\t商品名称\t商品价格\t库存数量\t");
				findGoodsByName.showGoods();
				return;
			} else {
				System.out.println("输入的商品不存在！请重新输入！！！");
				continue;
			} 
		}
	}
	
	/**
	 * 修改超市商品信息
	 */
	@Override
	public void updateGods() {
		System.out.println("*******修改商品信息*********");
		int gId = 0;
		int gNum = 0;
		while (true) {
			gId = Utils.inputInt("请输入要修改的商品id(-1返回)：");
			Goods findGoods = findGoods(gId);
			if (gId == -1) {
				return;
			}
			if (findGoods == null) {
				System.out.println("输入的商品不存在！请重新输入！！！");
				continue;
			} else {
				System.out.println("商品id\t商品名称\t商品价格\t库存数量\t");
				findGoods.showGoods();
				Double gPrice = Utils.inputDouble("请输入要修改的价格(-1返回;-2跳过)：");
				if (gPrice == -1) {
					return;
				}
				if (gPrice == -2) {
					gNum = Utils.inputInt("请输入要修改的商品库存数量(-1返回)：");
					if (gNum == -1) {
						return;
					}
					findGoods.setNumber(gNum);
					System.out.println("修改成功！！！");
					return;
				}
				findGoods.setPrice(gPrice);
				gNum = Utils.inputInt("请输入要修改的商品库存数量(-1返回)：");
				if (gNum == -1) {
					return;
				}
				findGoods.setNumber(gNum);
				System.out.println("修改成功！！！");
				return;
			} 
		}
	}
	
	/**
	 * 按id查找商品，返回商品对象
	 */
	public Goods findGoods(Integer id){
		for (Goods g : goods) {
			if (g.getId() == id) {
				return g;
			}
		}
		return null;
	}
	
	/**
	 * 按商品name查找商品，返回商品对象
	 */
	public Goods findGoodsByName(String name){
		for (Goods g : goods) {
			if (g.getName().equals(name)) {
				return g;
			}
		}
		return null;
	}
}
