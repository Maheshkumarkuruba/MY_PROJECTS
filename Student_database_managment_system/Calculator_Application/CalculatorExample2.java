package com.jsp.calculator;
import java.util.*;
interface Calculator1{
	int add(int x,int y);
	int sub(int x,int y);
	int mul(int x,int y);
	int div(int x,int y);
	String displayErrorMessage();
}
//all the above methods are public and abstract
class CalculatorImpl implements Calculator1{
	public int add(int x,int y) {
		return x+y;
	}
	public int sub(int x,int y) {
		return x-y;
	}
	public int mul(int x,int y) {
		return x*y;
	}
	public int div(int x,int y) {
		if(y!=0) {
		return x/y;
		}
		return 0;
	}
	public String displayErrorMessage() {
		return "invalid choice";
	}
}
public class CalculatorExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MANU DRIVEN PROGRAMM
		Scanner sc=new Scanner(System.in);
//		UPCASTING IS DONE HERE BECAUSE OF ABSTRACTION
		Calculator1 cal=new CalculatorImpl();
		
		while(true) {
			System.out.println("1.Addition \n 2.substraction \n 3.multiplication \n divition");
			int n=0;
			int m=0;
			System.out.println("enter the number");
			int choice=sc.nextInt();
			if(choice>=1 && choice<=4) {
			System.out.println("enter the two numbers");
			 n=sc.nextInt();
			 m=sc.nextInt();
			}
			switch(choice) {
			case 1:
				System.out.println(cal.add(m,n));  // CTR + DOUBLE CLICK TO SEE ABSTRACTION IS ACHEIVED OR NOT
				break;
			case 2: 
				System.out.println(cal.sub(m, n));
				break;
				
			case 3:
				System.out.println(cal.mul(n, m));
				break;
			case 4:
				int result=cal.div(m, n);
				if(result!=0) {
				System.out.println(result);
				}
				else {
					System.out.println("kindly enter dinaminator value greater then 0");
				}
				break;
			case 5:
				System.out.println("thankyou for using");
			System.exit(0);
			default:
				System.out.println(cal.displayErrorMessage());
			
			}
			System.out.println("-----------------");
			
		}

	}

}
