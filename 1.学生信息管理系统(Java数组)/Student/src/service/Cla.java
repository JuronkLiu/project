package service;

import java.util.Arrays;
import java.util.Scanner;

import bean.Student;

public class Cla {
	//��¼ѧ��������
	static int numStudent = 0 ;
	//��¼ѧ�������id
	static int maxId=0;
	//��¼ѧ�����������
	static int maxNumStudent = 1;
	//����StudentMessage��������
	Student s1[] = new Student[maxNumStudent];

	//ϵͳ��ʾ������
	public void xueSheng() {
		while (true) {
			System.out.println("---------------------------------");
			System.out.println("��ʱϵͳ���������Ϊ"+maxNumStudent+"(���Զ�����)����ǰѧ������Ϊ"+numStudent);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("---------------------------------");
			System.out.println("-----------ѧ����Ϣ����ϵͳ----------");
			System.out.println("          1.��ʾѧ��ȫ����Ϣ");
			System.out.println("          2.���ѧ����Ϣ");
			System.out.println("          3.ɾ��ѧ����Ϣ");
			System.out.println("          4.����ѧ����Ϣ");
			System.out.println("          5.�޸�ѧ����Ϣ");
			System.out.println("          6.�˳�");
			System.out.println("---------------------------------");
			System.out.print("�������ţ�");
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

	//��ѧ��id�޸�ѧ����Ϣ
	private void update(Scanner s) {
		System.out.println("---------��ѧ��id�޸�ѧ����Ϣ---------");
		System.out.print("������Ҫ�޸ĵ�ѧ��id��");
		int i = s.nextInt();
		
		//����Ѱ��ѧ����id�ķ���
		int id = findById(i);
		
		if (id != -1) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("---������ѧ����������");
			String nString = scanner.nextLine();
			System.out.print("---������ѧ�������䣺");
			int a = s.nextInt();
			
			s1[id].changeStudent(nString, a);
		}else{
			System.out.println("---���������id�����ڣ�����");
		}
	}

	//��ѧ��id����ѧ����Ϣ
	private void query(Scanner s) {
		System.out.println("---------��ѧ��id����ѧ����Ϣ---------");
		System.out.print("������Ҫ��ѯ��ѧ��id��");
		int i = s.nextInt();
		
		//����Ѱ��ѧ����id�ķ���
		int id = findById(i);
		
		if (id != -1) {
			s1[id].showStudent();
		}else{
			System.out.println("---���������id�����ڣ�����");
		}
		
	}

	//����Scanner����ɼ����ڴ������
	//��ѧ��idɾ��ѧ����Ϣ
	private  void delete(Scanner s) {
		System.out.println("---------��ѧ��idɾ��ѧ����Ϣ---------");
		System.out.print("������Ҫɾ����ѧ��id��");
		int i = s.nextInt();
		
		//����Ѱ��ѧ����id�ķ���
		int id = findById(i);
		
		if (id != -1) {
			for (int n = id; n < numStudent-1; n++) {
				//�����ѧ����ǰ�ƶ�
				s1[n] = s1[n+1];
			}
			numStudent--;
		}else{
			System.out.println("---���������id�����ڣ�����");
		}
		
	}
	
	//���ѧ����Ϣ
	private void add(Scanner s) {
		System.out.println("-------------���ѧ����Ϣ-----------");
		
		//���ö�����������ݷ���
		dilatation(numStudent);
		
		System.out.print("-������ѧ����������");
		Scanner scanner = new Scanner(System.in);
		String n=scanner.nextLine();
		System.out.print("-������ѧ�������䣺");
		int a = s.nextInt();
		//������ʵ�����µ�ѧ������
		s1[numStudent]=new Student(maxId+1,n,a);
		
		numStudent++;
		maxId++;
		
	}
	
	//Ѱ��ѧ����id�����ҵ��򷵻�ѧ������ĽǱ꣬���򷵻�-1
	private int  findById(int i) {
		for (int j = 0; j < numStudent; j++) {
			if (i ==s1[j].getId()) {
				return j;
			}
		}
		return -1;
	}
	
	//������������� 
	private void dilatation(int numStu) {
		if (numStudent == s1.length) {
			int oldNum = s1.length;
			int newNum = oldNum + 2;
			s1 = Arrays.copyOf(s1, newNum);
			maxNumStudent = newNum;
		}
	}
	
	//��ʾȫ����ѧ����Ϣ
	public void show() {
		System.out.println("----------��ʾȫ����ѧ����Ϣ----------");
		for (int i = 0;i< numStudent;i++) {
			s1[i].showStudent();
		}
		
	}
	
}
