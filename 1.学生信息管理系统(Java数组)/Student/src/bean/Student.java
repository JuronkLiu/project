package bean;

public class Student {
	
	private int id;
	private String name;
	private int age;
	
	
	public Student() {
		
	}

	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int a) {
		this.age = a;
	}
	
	public void changeStudent(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void showStudent() {
		System.out.println("---学生id："+id+",姓名："+name+",年龄："+age);
	}
}
