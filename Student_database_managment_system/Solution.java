package com.jsp.sdbms;
import java.util.*;

import com.jsp.customexception.IvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentManagementSystem s1=new StudentManagementSystemImpl();
		while(true) {
			System.out.println(" 1.addstudent \n 2.displaystudent \n 3.displayallstudents \n 4.removestudent \n 5.removeallstudents \n 6.updatestudent \n 7.countstudents \n 8.sortstudent \n 9.getstudentwithhighestmarks \n 10.getstudentwithlowermarks \n 11.exit");
			int choice =sc.nextInt();
			switch(choice){
			case 1:
				s1.addStudent();
				break;
			case 2:
				s1.displayStudent();
				break;
			case 3:
				s1.displayAllStudents();
				break;
			case 4:
				s1.removeStudent();
				break;
			case 5:
				s1.removeAllStudents();
				break;
			case 6:
				s1.updateStudent();
				break;
			case 7:
				s1.countStudents();
			case 8:
				s1.sortStudents();
				break;
			case 9:
				s1.getStudentWithHighestMarks();
				break;
			case 10:
				s1.getStudentWithLowerMarks();
				break;
			case 11:
				System.out.println("thanks you");
				System.exit(0);
				default:
					try {
						throw new IvalidChoiceException("invalid input");
						
					}
					catch(Exception e) {

					System.out.println(e.getMessage());
						
					}

			}
			System.out.println("======================");
		}

	}

}
