package java8.streamtest;

public class Person {
	private int no;
	private String name;
	private int age;

	public Person(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public Person(int no, String name, int age) {
		this.no = no;
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person:[no=" + this.no + ",name=" + this.name + ",age=" + this.age + "]";
	}
}
