package com.jsp.sdbms;

public class Student {
	private String id;
	private int age;
	private String name;
	private int marks;
    static int count=101;
	public Student(int age, int marks, String name) {
		this.id = "A"+count;
		this.age = age;
		this.name = name;
		this.marks = marks;
		count++;
	}
	public void setId(String id) {
		this.id=id;
	}
		public String getId() {
		return id;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setMarks(int marks) {
		this.marks=marks;
	}
	public int getMarks() {
		return marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + ", marks=" + marks + "]";
	}

}
