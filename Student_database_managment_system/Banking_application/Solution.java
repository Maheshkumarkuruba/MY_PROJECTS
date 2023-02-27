package com.jsp.solution;
import java .util.*;
interface Bank{
	public void deposit(int amount);
	public void withdraw(int amount);
	public int getBalance();
}
class BankImpl implements Bank {
	int balance;
	public BankImpl(int balance) {
		this.balance=balance;
	}
	public void deposit(int amount) {
		System.out.println(" deposited"+amount);
		balance=balance+amount;
		System.out.println("balance after deposite"+balance);
	}
	public void withdraw(int amount) {
		if(balance>amount) {
			System.out.println("withdraw"+amount);
			balance=balance-amount;
			System.out.println("balance after withdraw"+balance);
		}
		else {
			try {
				throw new InsafficientBalance("Insufficient balance");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
	public int getBalance() {
		return balance;
	}

}
class InsafficientBalance extends Exception{
	 private String message;
	public InsafficientBalance (String message){
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	
}
class Invalid_Choice extends Exception{
	private String message;
	public Invalid_Choice(String message){
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Bank ban= new BankImpl(0);
		while(true) {
			System.out.println(" 1.Deposite\n 2.Withdraw Amount \n 3.Get Balance \n 4.Exit");
			System.out.println("enter the choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("enter the amount");
				int depositamount=sc.nextInt();     //to check visibulity use {crl+double tap}
				ban.deposit(depositamount);
				break;
			case 2:
				System.out.println("ENTER THE AMOUNT");
				int withdrawamount=sc.nextInt();
				ban.withdraw(withdrawamount);
				break;
			case 3:
				System.out.println(ban.getBalance());
				break;
			case 4:
				System.out.println("thank you for using");
				System.exit(0);
				break;
			default :
				try {
					 throw new Invalid_Choice("invalid choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
					
				}
			}
			System.out.println("======================");
		}

	}

}
/*
 * Rules to work with customer /user-Defined Exception 1.creat class with
 * Exception name 2.if class Extends Runtimeexception --> uncheckedexception
 * ovrride the getMessage()-->(variable,constructor,method) invoke the Exception
 * object using throw key word handle it using try and catch blocjk
 */
