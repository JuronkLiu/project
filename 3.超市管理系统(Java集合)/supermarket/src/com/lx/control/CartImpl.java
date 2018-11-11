package com.lx.control;

import com.lx.bean.Goods;
import com.lx.bean.User;
import com.lx.utils.Utils;

/**
 *@describe 购物车实现类
 *
 *@author liuzhirong
 *@date 2018年8月20日---上午11:07:04 
*/
public class CartImpl implements Cart {

	/**
	 * 添加商品到购物车
	 */
	@Override
	public void addCart(Supermarket supermarket,User user) {
		int gId;
		int gNum;
		Goods findGoods;
		Goods findCartGoods;
		System.out.println("******添加商品到购物车******");
		while (true) {
			gId = Utils.inputInt("请输入你要购买的商品id(-1返回)：");
			findGoods = supermarket.findGoods(gId);
			findCartGoods = findCartGoods(gId, user);
			if (gId == -1) {
				return;
			}
			if (findGoods == null) {
				System.out.println("抱歉，本超市无此商品！请重新输入！！！");
				continue;
			} 
			while (true) {
				gNum = Utils.inputInt("请输入你要购买的此商品的数量(-1返回)：");
				if (gNum == -1) {
					return;
				}
				if (findGoods.getNumber() < gNum) {
					System.out.println("您所需要的商品数量库存不足！请重新输入！！！");
					continue;
				} 
				if (user.getUserCart().contains(findCartGoods)) {
					findCartGoods.setNumber(findCartGoods.getNumber() + gNum);
					System.out.println("添加成功！！！");
					return;
				}
				user.getUserCart().add(new Goods(findGoods.getId(), findGoods.getName(), findGoods.getPrice(), gNum));
				System.out.println("添加成功！！！");
				return;
			}
		}
		
	}

	/**
	 * 删除购物车的商品
	 */
	@Override
	public void delCart(Supermarket supermarket,User user) {
		int gId;
		Goods findCartGoods;
		System.out.println("******删除购物车的某商品******");
		showMyCart(user);
		while (true) {
			gId = Utils.inputInt("请输入您要删除购物车里商品的id(-1返回)：");
			if (gId == -1) {
				System.out.println("删除失败！！！");
				return;
			}
			findCartGoods = findCartGoods(gId, user);
			if (findCartGoods == null) {
				System.out.println("购物车无此商品！请重新输入！！！");
				continue;
			} 
			user.getUserCart().remove(findCartGoods);
			System.out.println("删除成功！！！");
			return;
		}
	}

	/**
	 * 清空购物车
	 */
	@Override
	public void delAllCart(User user) {
		System.out.println("******清空购物车******");
		
		String isf = Utils.inputStr("是否清空购物车(y-->是;其他-->返回)！！！");
		if (isf.equals("y")) {
			user.getUserCart().clear();
			if (user.getUserCart().size() == 0) {
				System.out.println("购物车清空成功！！！");
				return;
			}
		}
		System.out.println("购物车清空失败！！！");
	}

	/**
	 * 查看购物车某商品的信息
	 */
	@Override
	public void queryCart(User user) {
		int gId;
		Goods g;
		System.out.println("*****查看购物车某商品的信息******");
		while (true) {
			gId = Utils.inputInt("请输入您要查看购物车里商品的id(-1返回)：");
			if (gId == -1) {
				System.out.println("查看失败");
				return;
			}
			g = findCartGoods(gId, user);
			if (g == null) {
				System.out.println("购物车无此商品！请重新输入！！！");
				continue;
			} 
			
			System.out.println("商品id\t商品名称\t商品价格\t购买数量\t金额");
			System.out.println(g.getId()+"\t"+g.getName()+"\t"+g.getPrice()+"\t"+g.getNumber()+"\t"+g.getPrice()*g.getNumber());
			return;
		}
	}

	/**
	 * 修改购物车商品的数量
	 */
	@Override
	public void updateCart(Supermarket supermarket,User user) {
		int gId;
		int gNum;
		System.out.println("*****修改购物车商品的数量******");
		showMyCart(user);
		Goods findCartGoods;
		while (true) {
			gId = Utils.inputInt("请输入您要修改购物车里商品的id(-1返回)：");
			if (gId == -1) {
				System.out.println("修改失败");
				return;
			}
			findCartGoods = findCartGoods(gId, user);
			if (findCartGoods == null) {
				System.out.println("购物车无此商品！请重新输入！！！");
				continue;
			} 
			while (true ) {
				gNum = Utils.inputInt("请输入你要修改的商品数量(-1返回)：");
				if (gNum == -1) {
					System.out.println("修改失败");
					return;
				}
				if (gNum > supermarket.findGoods(gId).getNumber()) {
					System.out.println("超市库存不足！请重新输入！！！");
					continue;
				} 
				findCartGoods.setNumber(gNum);
				System.out.println("修改成功！！！");
				return;
			}
		}
	}

	/**
	 * 显示购物车的商品信息
	 */
	@Override
	public Double showMyCart(User user) {
		Double sum = 0.0;
		System.out.println("******我的购物车******");
		System.out.println("商品id\t商品名称\t商品价格\t购买数量\t金额");
		for (Goods g : user.getUserCart()) {
			System.out.println(g.getId()+"\t"+g.getName()+"\t"+g.getPrice()+"\t"+g.getNumber()+"\t"+g.getPrice()*g.getNumber());
			sum += g.getPrice()*g.getNumber();
		}
		System.out.println("总金额："+ sum);
		return sum;
	}

	/**
	 * 为购物车买单
	 */
	@Override
	public void pay(Supermarket supermarket,User user) {
		if (user.getUserCart().size() == 0) {
			System.out.println("购物车为空！不能支付！快去添加商品到购物车吧！！！");
			System.out.println("选择3即可添加商品到购物车!!!");
			return;
		}
		Double sumMoney = showMyCart(user);
		System.out.println("********支付********");
		String s = Utils.inputStr("是否支付(y-->是;其他-->返回)！！！:");
		int gId;
		if (s.equals("y")) {
			//判断当前购买的商品数量与超市库存的数量
			for (Goods g : user.getUserCart()) {
				gId = g.getId();
				if (g.getNumber() > supermarket.findGoods(gId).getNumber()) {
					System.out.println("该商品:"+ g.getId() +",库存不足！无法支付！请修改数量！！！");
					return;
				}
			}
			boolean payWay = payWay(sumMoney);
			if (payWay) {
				//循环删除购物车
				while (true) {
					for (Goods g : user.getUserCart()) {
						gId = g.getId();
						supermarket.findGoods(gId).setNumber(supermarket.findGoods(gId).getNumber() - g.getNumber());
						user.getUserCart().remove(g);
						break;
					}
					if (user.getUserCart().size() == 0) {
						System.out.println("支付成功！！！");
						return;
					}
				}
			}
		}
		System.out.println("支付失败");
	}

	/**
	 * 支付方式
	 */
	public boolean payWay(Double m){
		String payWay = Utils.inputStr("请选择支付方式(1:微信；2:支付宝；3：现金；其他-->返回)：");
		switch (payWay) {
		case "1":
			System.out.println("   ***微信支付***");
			break;
		case "2":
			System.out.println("   ***支付宝支付***");
			break;
		case "3":
			System.out.println("   ***现金支付***");
			break;
		default:
			return false;
		}
		Double money;
		while (true) {
			money = Utils.inputDouble("请输入金额(-1：退出支付)：");
			if (money == -1) {
				return false;
			}
			if (m > money) {
				System.out.println("金额不足！请重新输入金额！！！");
				continue;
			}
			break;
		}
		if (m <= money) {
			System.out.println("找零：" + (money-m));
		}
		return true;
	}
	/**
	 * 查找购物车的商品，返回商品对象
	 * @param id
	 * @param user
	 * @return
	 */
	public Goods findCartGoods(int id,User user) {
		for (Goods g : user.getUserCart()) {
			if (g.getId() == id) {
				return g;
			}
		}
		return null;
	}
}
