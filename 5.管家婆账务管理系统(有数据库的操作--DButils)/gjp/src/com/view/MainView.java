package com.view;
/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018��8��30��---����2:08:36 
*/

import java.util.List;

import com.domain.ZhangWu;
import com.service.ZhangWuService;
import com.tools.InputUtils;

public class MainView {

	public static int pageSize = 5;	//ÿҳ��ʾ������
	private boolean exit = false;	//��־��ҳ���Ƿ��˳�
	private static int pageNow = 1;  //��ǰҳ��Ĭ����ҳ
	
	private ZhangWuService zhangWuService = new ZhangWuService();

	/**
	 * ���з���
	 */
	public void run() {
		/*
		 * 1. ��ӡ�˵� 2. ��ȡ�û����� 3. ���ö�Ӧ����
		 */
		boolean flag = true;
		while (flag) {
			System.out.println("---------------�ܼ��ż�ͥ�������---------------");
			System.out.println("1.�������2.�༭����3.ɾ������4.��ѯ����5.�˳�ϵͳ");
			Integer op = InputUtils.inputInt("������Ҫ�����Ĺ������[1-5]:");
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
				System.out.println("�ټ���");
				flag = false;
				break;
			default:
				System.out.println("����������������룡����");
			}
		}
	}

	/**
	 * ��ѯ���񷽷�
	 */
	private void selectZhangWu() {
		System.out.println("1.��ѯ���С�2.��������ѯ    3.��ҳ��ѯ    4.�˳�");
		int op = InputUtils.inputInt("������Ҫ��ѯ�ķ�ʽ���[1-3]:");
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
			System.out.println("����������������룡����");
			selectZhangWu();
			break;
		}
	}

	/**
	 * ��ҳ��ѯ
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
	 * ��ҳ
	 * @param pageNow
	 * @param pageCount 
	 * @param exit 
	 * @return 
	 */
	private boolean mainPage(int pageNow, int pageCount) {
		if (exit) {
			return true;
		}
		System.out.println("��ǰҳ" + pageNow + ",��" + pageCount + "ҳ");
		List<ZhangWu> selectByPage = zhangWuService.selectByPage(pageNow,pageSize);
		print(selectByPage);
		System.out.println("1-->��һҳ;2-->βҳ;3-->�˳�");
		Integer op = InputUtils.inputInt("������ѡ��");
		switch (op) {
		case 1:
			return nextPage(++pageNow, pageCount);
		case 2:
			pageNow = pageCount;
			return endPage(pageNow,pageCount);
		case 3:
			return true;
		default:
			System.out.println("��������");
			break;
		}
		return false;
	}

	/**
	 * βҳ
	 * @param pageNow 
	 * @param pageCount 
	 * @return 
	 */
	private boolean endPage(int pageNow, int pageCount) {
		if (exit) {
			return true;
		}
		System.out.println("��ǰҳ" + pageNow + ",��" + pageCount + "ҳ");
		List<ZhangWu> selectByPage = zhangWuService.selectByPage(pageNow,pageSize);
		print(selectByPage);
		System.out.println("1-->��ҳ;2-->��һҳ;3-->�˳�");
		Integer op = InputUtils.inputInt("������ѡ��");
		switch (op) {
		case 1:
			pageNow = 1;
			return mainPage(pageNow,pageCount);
		case 2:
			return nextPage(--pageNow, pageCount);
		case 3:
			return true;
		default:
			System.out.println("��������");
			break;
		}
		return false;
	}

	/**
	 * �м�ҳ
	 * @param pageCount 
	 * @param i
	 * @return 
	 */
	private boolean nextPage(int pageNow, int pageCount) {
		if (exit) {
			return true;
		}
		System.out.println("��ǰҳ" + pageNow + ",��" + pageCount + "ҳ");
		List<ZhangWu> selectByPage = zhangWuService.selectByPage(pageNow,pageSize);
		print(selectByPage);
		System.out.println("1-->��ҳ;2-->��һҳ;3-->��һҳ;4-->βҳ;5-->�˳�");
		Integer op = InputUtils.inputInt("������ѡ��");
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
			System.out.println("��������");
			break;
		}
		return false;
	}

	/**
	 * ��ѯ�������񷽷�
	 */
	private void select() {
		/*
		 * 1. ��ȡ�û������ѯ���ڷ�Χ�� 2. ����service��select()�������������ѯ����
		 */
		String start = InputUtils.inputString("�������ѯ��ʼʱ��(��ʽ��2018-08-02)��");
		String end = InputUtils.inputString("�������ѯ����ʱ��(��ʽ��2018-08-02)��");
		List<ZhangWu> zhangWuList = zhangWuService.select(start, end);
		print(zhangWuList);
	}

	/*
	 * ������񷽷�
	 */
	private void print(List<ZhangWu> zhangWuList) {
		System.out.println("ID\t���\t\t�˻�\t\t���\t\tʱ��\t\t˵��");
		for (ZhangWu zw : zhangWuList) {
			System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t" + zw.getZhangHu() + "\t\t" + zw.getMoney()
					+ "\t\t" + zw.getCreatetime() + "\t" + zw.getDescription());
		}
	}

	/**
	 * ��ѯ����
	 */
	private void selectAll() {
		List<ZhangWu> zhangWuList = zhangWuService.selectAll();
		print(zhangWuList);
	}

	/**
	 * ɾ�����񷽷�
	 */
	private void deleteZhangWu() {
		/*
		 * 1. ��ȡ�û����룬��װ��bean�С� 2. ����service��deleteZhangWu()���������ӹ���
		 */
		Integer zwid;
		while (true) {
			zwid = InputUtils.inputInt("������ID(-1�˳�)��");
			if (zwid == -1) {
				return;
			}
			boolean findZWById = zhangWuService.findZWById(zwid);
			if (!findZWById) {
				System.out.println("����ID�����ڣ����������룡����");
				continue;
			}
			break;
		}
		zhangWuService.deleteZhangWu(zwid);
		System.out.println("ɾ������ɹ���");
	}

	/**
	 * �༭���񷽷�
	 */
	private void editZhangWu() {
		/*
		 * 1. ��ȡ�û����룬��װ��bean�С� 2. ����service��editZhangWu()���������ӹ���
		 */
		Integer zwid;
		while (true) {
			zwid = InputUtils.inputInt("������ID(-1�˳�)��");
			if (zwid == -1) {
				return;
			}
			boolean b = zhangWuService.findZWById(zwid);
			if (!b) {
				System.out.println("����ID�����ڣ����������룡����");
				continue;
			}
			break;
		}
		String flname = InputUtils.inputString("�����������(exit�˳�)��");
		if (flname.equals("exit")) {
			return;
		}
		String zhangHu = InputUtils.inputString("�����������ѷ�ʽ(exit�˳�)��");
		if (zhangHu.equals("exit")) {
			return;
		}
		Double money = InputUtils.inputDouble("�������½��(-1�˳�)��");
		if (money == -1) {
			return;
		}
		String createtime = InputUtils.inputString("��������ʱ��(exit�˳�)��");
		if (createtime.equals("exit")) {
			return;
		}
		String description = InputUtils.inputString("��������˵��(exit�˳�)��");
		if (description.equals("exit")) {
			return;
		}
		ZhangWu zw = new ZhangWu(flname, zhangHu, money, createtime, description);
		zw.setZwid(zwid);
		zhangWuService.editZhangWu(zw);
		System.out.println("�༭����ɹ���");
	}

	/**
	 * ������񷽷�
	 */
	private void addZhangWu() {
		/*
		 * 1. ��ȡ�û����룬��װ��bean�С� 2. ����service��addZhangWu()���������ӹ���
		 */
		String flname = InputUtils.inputString("���������(exit�˳�)��");
		if (flname.equals("exit")) {
			return;
		}
		String zhangHu = InputUtils.inputString("���������ѷ�ʽ(exit�˳�)��");
		if (zhangHu.equals("exit")) {
			return;
		}
		Double money = InputUtils.inputDouble("��������(-1�˳�)��");
		if (money == -1) {
			return;
		}
		String createtime = InputUtils.inputString("������ʱ��(exit�˳�)��");
		if (createtime.equals("exit")) {
			return;
		}
		String description = InputUtils.inputString("������˵��(exit�˳�)��");
		if (description.equals("exit")) {
			return;
		}

		zhangWuService.addZhangWu(new ZhangWu(flname, zhangHu, money, createtime, description));
		System.out.println("�������ɹ���");
	}

}
