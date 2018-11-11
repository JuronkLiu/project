package com.view;
/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018年8月30日---下午2:08:36 
*/

import java.util.List;

import com.domain.ZhangWu;
import com.service.ZhangWuService;
import com.tools.InputUtils;

public class MainView {

	public static int pageSize = 5;	//每页显示的数据
	private boolean exit = false;	//标志分页中是否退出
	private static int pageNow = 1;  //当前页，默认首页
	
	private ZhangWuService zhangWuService = new ZhangWuService();

	/**
	 * 运行方法
	 */
	public void run() {
		/*
		 * 1. 打印菜单 2. 获取用户输入 3. 调用对应方法
		 */
		boolean flag = true;
		while (flag) {
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			Integer op = InputUtils.inputInt("请输入要操作的功能序号[1-5]:");
			switch (op) {
			case 1:
				addZhangWu();
				break;
			case 2:
				editZhangWu();
				break;
			case 3:
				deleteZhangWu();
				break;
			case 4:
				selectZhangWu();
				break;
			case 5:
				System.out.println("再见！");
				flag = false;
				break;
			default:
				System.out.println("输入错误！请重新输入！！！");
			}
		}
	}

	/**
	 * 查询账务方法
	 */
	private void selectZhangWu() {
		System.out.println("1.查询所有　2.按条件查询    3.分页查询    4.退出");
		int op = InputUtils.inputInt("请输入要查询的方式序号[1-3]:");
		switch (op) {
		case 1:
			selectAll();
			break;
		case 2:
			select();
			break;
		case 3:
			selectByPage();
		case 4:
			return;
		default:
			System.out.println("输入错误！请重新输入！！！");
			selectZhangWu();
			break;
		}
	}

	/**
	 * 分页查询
	 */
	private void selectByPage() {
		pageNow = 1;
		int num = zhangWuService.getNum();
		int pageCount = num / pageSize;
		if (num % pageSize !=0 ) {
			pageCount ++; 
		}
		mainPage(pageNow, pageCount);
	}

	/**
	 * 首页
	 * @param pageNow
	 * @param pageCount 
	 * @param exit 
	 * @return 
	 */
	private boolean mainPage(int pageNow, int pageCount) {
		if (exit) {
			return true;
		}
		System.out.println("当前页" + pageNow + ",共" + pageCount + "页");
		List<ZhangWu> selectByPage = zhangWuService.selectByPage(pageNow,pageSize);
		print(selectByPage);
		System.out.println("1-->下一页;2-->尾页;3-->退出");
		Integer op = InputUtils.inputInt("请输入选择：");
		switch (op) {
		case 1:
			return nextPage(++pageNow, pageCount);
		case 2:
			pageNow = pageCount;
			return endPage(pageNow,pageCount);
		case 3:
			return true;
		default:
			System.out.println("输入有误！");
			break;
		}
		return false;
	}

	/**
	 * 尾页
	 * @param pageNow 
	 * @param pageCount 
	 * @return 
	 */
	private boolean endPage(int pageNow, int pageCount) {
		if (exit) {
			return true;
		}
		System.out.println("当前页" + pageNow + ",共" + pageCount + "页");
		List<ZhangWu> selectByPage = zhangWuService.selectByPage(pageNow,pageSize);
		print(selectByPage);
		System.out.println("1-->首页;2-->上一页;3-->退出");
		Integer op = InputUtils.inputInt("请输入选择：");
		switch (op) {
		case 1:
			pageNow = 1;
			return mainPage(pageNow,pageCount);
		case 2:
			return nextPage(--pageNow, pageCount);
		case 3:
			return true;
		default:
			System.out.println("输入有误！");
			break;
		}
		return false;
	}

	/**
	 * 中间页
	 * @param pageCount 
	 * @param i
	 * @return 
	 */
	private boolean nextPage(int pageNow, int pageCount) {
		if (exit) {
			return true;
		}
		System.out.println("当前页" + pageNow + ",共" + pageCount + "页");
		List<ZhangWu> selectByPage = zhangWuService.selectByPage(pageNow,pageSize);
		print(selectByPage);
		System.out.println("1-->首页;2-->上一页;3-->下一页;4-->尾页;5-->退出");
		Integer op = InputUtils.inputInt("请输入选择：");
		switch (op) {
		case 1:
			return mainPage(1, pageCount);
		case 2:
			if (--pageNow == 1) {
				return mainPage(1, pageCount);
			}else {
				return nextPage(pageNow, pageCount);
			}
		case 3:
			if (++pageNow == pageCount) {
				return endPage(pageCount, pageCount);
			}else {
				return nextPage(++pageNow, pageCount);
			}
		case 4:
			return endPage(pageCount, pageCount);
		case 5:
			return true;
		default:
			System.out.println("输入有误！");
			break;
		}
		return false;
	}

	/**
	 * 查询所有账务方法
	 */
	private void select() {
		/*
		 * 1. 获取用户输入查询日期范围。 2. 调用service的select()方法完成条件查询功能
		 */
		String start = InputUtils.inputString("请输入查询起始时间(格式：2018-08-02)：");
		String end = InputUtils.inputString("请输入查询结束时间(格式：2018-08-02)：");
		List<ZhangWu> zhangWuList = zhangWuService.select(start, end);
		print(zhangWuList);
	}

	/*
	 * 输出账务方法
	 */
	private void print(List<ZhangWu> zhangWuList) {
		System.out.println("ID\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
		for (ZhangWu zw : zhangWuList) {
			System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t" + zw.getZhangHu() + "\t\t" + zw.getMoney()
					+ "\t\t" + zw.getCreatetime() + "\t" + zw.getDescription());
		}
	}

	/**
	 * 查询所有
	 */
	private void selectAll() {
		List<ZhangWu> zhangWuList = zhangWuService.selectAll();
		print(zhangWuList);
	}

	/**
	 * 删除账务方法
	 */
	private void deleteZhangWu() {
		/*
		 * 1. 获取用户输入，封装到bean中。 2. 调用service的deleteZhangWu()方法完成添加功能
		 */
		Integer zwid;
		while (true) {
			zwid = InputUtils.inputInt("请输入ID(-1退出)：");
			if (zwid == -1) {
				return;
			}
			boolean findZWById = zhangWuService.findZWById(zwid);
			if (!findZWById) {
				System.out.println("账务ID不存在！请重新输入！！！");
				continue;
			}
			break;
		}
		zhangWuService.deleteZhangWu(zwid);
		System.out.println("删除账务成功！");
	}

	/**
	 * 编辑账务方法
	 */
	private void editZhangWu() {
		/*
		 * 1. 获取用户输入，封装到bean中。 2. 调用service的editZhangWu()方法完成添加功能
		 */
		Integer zwid;
		while (true) {
			zwid = InputUtils.inputInt("请输入ID(-1退出)：");
			if (zwid == -1) {
				return;
			}
			boolean b = zhangWuService.findZWById(zwid);
			if (!b) {
				System.out.println("账务ID不存在！请重新输入！！！");
				continue;
			}
			break;
		}
		String flname = InputUtils.inputString("请输入新类别(exit退出)：");
		if (flname.equals("exit")) {
			return;
		}
		String zhangHu = InputUtils.inputString("请输入新消费方式(exit退出)：");
		if (zhangHu.equals("exit")) {
			return;
		}
		Double money = InputUtils.inputDouble("请输入新金额(-1退出)：");
		if (money == -1) {
			return;
		}
		String createtime = InputUtils.inputString("请输入新时间(exit退出)：");
		if (createtime.equals("exit")) {
			return;
		}
		String description = InputUtils.inputString("请输入新说明(exit退出)：");
		if (description.equals("exit")) {
			return;
		}
		ZhangWu zw = new ZhangWu(flname, zhangHu, money, createtime, description);
		zw.setZwid(zwid);
		zhangWuService.editZhangWu(zw);
		System.out.println("编辑账务成功！");
	}

	/**
	 * 添加账务方法
	 */
	private void addZhangWu() {
		/*
		 * 1. 获取用户输入，封装到bean中。 2. 调用service的addZhangWu()方法完成添加功能
		 */
		String flname = InputUtils.inputString("请输入类别(exit退出)：");
		if (flname.equals("exit")) {
			return;
		}
		String zhangHu = InputUtils.inputString("请输入消费方式(exit退出)：");
		if (zhangHu.equals("exit")) {
			return;
		}
		Double money = InputUtils.inputDouble("请输入金额(-1退出)：");
		if (money == -1) {
			return;
		}
		String createtime = InputUtils.inputString("请输入时间(exit退出)：");
		if (createtime.equals("exit")) {
			return;
		}
		String description = InputUtils.inputString("请输入说明(exit退出)：");
		if (description.equals("exit")) {
			return;
		}

		zhangWuService.addZhangWu(new ZhangWu(flname, zhangHu, money, createtime, description));
		System.out.println("添加账务成功！");
	}

}
