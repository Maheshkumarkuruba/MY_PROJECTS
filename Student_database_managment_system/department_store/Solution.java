package com.jsp.department;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter to xyz department store");
		System.out.println("------------------------------");
		Scanner sc=new Scanner(System.in);
//		DepartmentalStrore dp=new DepartmentalStoreImpl();
		DepartmentalStrore de=new DepartmentalStoreImpl();
		de.addProduct();
		int choice=1;
		while(choice==1) {
			de.displayProduct();
			de.buyProduct();
			System.out.println("----------------------");
			System.out.println("press 1 to continue shoppping or any other number to checkout");
			choice =sc.nextInt();
		}
		
		de.checkout();

	}

}
