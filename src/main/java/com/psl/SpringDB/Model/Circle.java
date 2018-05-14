package com.psl.SpringDB.Model;

public class Circle {
	private int id;
	private String name;
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
	public Circle(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Circle() {
	
	}
	@Override
	public String toString() {
		return "Circle [id=" + id + ", name=" + name.trim() + "]";
	}	
}