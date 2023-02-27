package com.jsp.department;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DepartmentalStoreImpl implements DepartmentalStrore {
	Scanner sc=new Scanner(System.in);
	Map<Integer,Product> mp=new LinkedHashMap<Integer,Product>();
	int totalbill;
	@Override
	public void addProduct() {
		// TODO Auto-generated method stub
		//		System.out.println("enter your productname");
		//		String name=sc.next();
		//		System.out.println("enter your quantity");
		//		int quantity=sc.nextInt();
		mp.put(1,new Product("chocolate",20,20));
		mp.put(2,new Product("biscuit",10,25));
		mp.put(3,new Product("icecream",20,50));

	}

	@Override
	public void displayProduct() {
		// TODO Auto-generated method stub
		Set<Integer> keys=mp.keySet();
		for(Integer val:keys) {
			Product p=mp.get(val);
			System.out.println("enter :"+val+"to get :"+p.getName());
			System.out.println("available quantities :"+p.getCost());
			System.out.println("cost :"+p.getCost());
			System.out.println("=========================");
		}
	}

	@Override
	public void buyProduct() {
		// TODO Auto-generated method stub
		System.out.println("enter your choice");
		int choice=sc.nextInt();
		Product p=mp.get(choice);
		if(p!=null) {
			System.out.println("enter the quantity");
			int quantity=sc.nextInt();
			if(quantity<=p.getQuantity()) {
				//calculating the cost of the product
int productcost=quantity*p.getCost();
//addibd the cost to the totalbill
 totalbill+=productcost;
// setting the product cost again by using setter method
        p.setQuantity(p.getQuantity()-quantity);
        System.out.println("ordered quantity "+quantity+" "+p.getName());
        System.out.println("product cost "+productcost);
        System.out.println("totalbill as of now is "+totalbill);
				
			}
			else {
				try {
					throw new IvalidQuantityException("invalid quantity"+p.getName() +"is not available");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				throw new IvalidException("invalid choice entered");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void checkout() {
		// TODO Auto-generated method stub
		System.out.println("toltal bill:"+totalbill);
		System.out.println("thankyou for shopping");

	}

}
