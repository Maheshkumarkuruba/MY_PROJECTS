package com.jsp.department;

public class Product {
	private String name;
	private int quantity;
	private int cost;
	public  Product(String name,int quantity,int cost) {
		this.name=name;
		this.quantity=quantity;
		this.cost=cost;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setCost(int cost) {
		this.cost=cost;
	}
	public int getCost() {
		return cost;
	}
	public String toString() {
		return "name:"+name+"quantity:"+quantity+"cost:"+cost;
	}
}
