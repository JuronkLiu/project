package service;

import java.util.Arrays;
import java.util.Scanner;

import bean.Student;

public class Cla {
	//记录学生的数量
	static int numStudent = 0 ;
	//记录学生的最大id
	static int maxId=0;
	//记录学生的最大容量
	static int maxNumStudent = 1;
	//声明StudentMessage对象数组
	Student s1[] = new Student[maxNumStudent];

	//系统显示主界面
	public void xueSheng() {
		while (true) {
			System.out.println("---------------------------------");
			System.out.println("此时系统的最大容量为"+maxNumStudent+"(可自动扩容)，当前学生数量为"+numStudent);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("---------------------------------");
			System.out.println("-----------学生信息管理系统----------");
			System.out.println("          1.显示学生全部信息");
			System.out.println("          2.添加学生信息");
			System.out.println("          3.删除学生信息");
			System.out.println("          4.查找学生信息");
			System.out.println("          5.修改学生信息");
			System.out.println("          6.退出");
			System.out.println("---------------------------------");
			System.out.print("请输入编号：");
			int i = sc.nextInt();
			switch (i) {
			case 1:
				show();
				break;
			case 2:
				add(sc);
				break;
			case 3:
				delete(sc);
				break;
			case 4:
				query(sc);
				break;
			case 5:
				update(sc);
				break;
			case 6:
				exit();
				break;
			default:
				break;
			}
		}
	}
	
	private void exit() {
		System.exit(-1);
	}

	//按学生id修改学生信息
	private void update(Scanner s) {
		System.out.println("---------按学生id修改学生信息---------");
		System.out.print("请输入要修改的学生id：");
		int i = s.nextInt();
		
		//调用寻找学生的id的方法
		int id = findById(i);
		
		if (id != -1) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("---请输入学生的姓名：");
			String nString = scanner.nextLine();
			System.out.print("---请输入学生的年龄：");
			int a = s.nextInt();
			
			s1[id].changeStudent(nString, a);
		}else{
			System.out.println("---您所输入的id不存在！！！");
		}
	}

	//按学生id查找学生信息
	private void query(Scanner s) {
		System.out.println("---------按学生id查找学生信息---------");
		System.out.print("请输入要查询的学生id：");
		int i = s.nextInt();
		
		//调用寻找学生的id的方法
		int id = findById(i);
		
		if (id != -1) {
			s1[id].showStudent();
		}else{
			System.out.println("---您所输入的id不存在！！！");
		}
		
	}

	//传入Scanner对象可减少内存的消耗
	//按学生id删除学生信息
	private  void delete(Scanner s) {
		System.out.println("---------按学生id删除学生信息---------");
		System.out.print("请输入要删除的学生id：");
		int i = s.nextInt();
		
		//调用寻找学生的id的方法
		int id = findById(i);
		
		if (id != -1) {
			for (int n = id; n < numStudent-1; n++) {
				//后面的学生向前移动
				s1[n] = s1[n+1];
			}
			numStudent--;
		}else{
			System.out.println("---您所输入的id不存在！！！");
		}
		
	}
	
	//添加学生信息
	private void add(Scanner s) {
		System.out.println("-------------添加学生信息-----------");
		
		//调用对象数组的扩容方法
		dilatation(numStudent);
		
		System.out.print("-请输入学生的姓名：");
		Scanner scanner = new Scanner(System.in);
		String n=scanner.nextLine();
		System.out.print("-请输入学生的年龄：");
		int a = s.nextInt();
		//声明并实例化新的学生对象
		s1[numStudent]=new Student(maxId+1,n,a);
		
		numStudent++;
		maxId++;
		
	}
	
	//寻找学生的id，若找到则返回学生对象的角标，否则返回-1
	private int  findById(int i) {
		for (int j = 0; j < numStudent; j++) {
			if (i ==s1[j].getId()) {
				return j;
			}
		}
		return -1;
	}
	
	//对象数组的扩容 
	private void dilatation(int numStu) {
		if (numStudent == s1.length) {
			int oldNum = s1.length;
			int newNum = oldNum + 2;
			s1 = Arrays.copyOf(s1, newNum);
			maxNumStudent = newNum;
		}
	}
	
	//显示全部的学生信息
	public void show() {
		System.out.println("----------显示全部的学生信息----------");
		for (int i = 0;i< numStudent;i++) {
			s1[i].showStudent();
		}
		
	}
	
}
