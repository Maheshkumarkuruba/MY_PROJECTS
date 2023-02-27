package com.jsp.sdbms;
import java.util.*;
import com.jsp.customexception.IvalidChoiceException;
import com.jsp.customexception.StudentNotFoundException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByNmae;
public class StudentManagementSystemImpl implements StudentManagementSystem{
	Scanner sc=new Scanner(System.in);
	Map<String,Student> db=new LinkedHashMap<String,Student>();

	@Override
	public void addStudent() {
		// TODO Auto-generated method stub
		System.out.println("ENTER STUDENT AGE");
		int age=sc.nextInt();
		System.out.println("Enter Student Marks");
		int marks=sc.nextInt();
		System.out.println("Enter Student Name");
		String name=sc.next();
		Student s1=new Student(age,marks,name);
		db.put(s1.getId(),s1);
		System.out.println("Student Records Entered Succesfully");
		System.out.println("Student Id Is "+s1.getId());
	}

	@Override
	public void displayStudent() {
		// TODO Auto-generated method stub
		System.out.println("Enter The Student Id");
		String id=sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) { //checking student is present are not
			  Student std=db.get(id); //getting the student id
			  System.out.println("id :"+std.getId());
			  System.out.println("age :"+std.getAge());
			  System.out.println("name :"+std.getName());
			  System.out.println("marks :"+std.getMarks());
			System.out.println(db.get(id));
		}
		else {
			String message="student id :"+id+"is not present";
			try {
				throw new  StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void displayAllStudents() {
		// convert the map into set==> using keyset()
		if(db.size()!=0) {
			System.out.println("student records as follow");
			System.out.println("---------------------------");
			Set<String> keys=db.keySet();//101 102
			for(String val:keys) {
				Student std=db.get(val);  //System.out.println(db.get(val));
//				System.out.println("Std Id:"+ std.getId());
//				System.out.println("Std Name:"+std.getName());
//				System.out.println("Std Age:"+std.getAge());
//				System.out.println("Std Marks:"+std.getMarks());
				System.out.println(std);
				System.out.println("------------------");
			}
		}
		else {
			String message="Student database management system is not present";
			try {
				throw new  StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeStudent() {
		// TODO Auto-generated method stub
		System.out.println("Enter The Student Id");
		String id=sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student id is Found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("student id is removed");
		}
		else {
			String message="student id :"+id+"is not present";
			try {
				throw new  StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void removeAllStudents() {
		// TODO Auto-generated method stub
		if(db.size()!=0) {
			System.out.println("Student recordes present "+db.size());
			db.clear();
			System.out.println("Student recordes present "+db.size());
			System.out.println("student records are succeefully removed");
			}
		else {
			try {
				String message="Student database management is empty,nothing to delete";
				throw new  StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void updateStudent() {
		// TODO Auto-generated method stub
System.out.println("Enter Student Id");
String id=sc.next();
 id=id.toUpperCase();
 if(db.containsKey(id)) {
	 Student std=db.get(id);
	 System.out.println(" 1.update name\n 2.update age\n 3.update marks");
	 int choice=sc.nextInt();
	 switch(choice) {
	 case 1:
		 System.out.println("enter the name");
		 String name=sc.next();
		 std.setName(name); //   singel name std.setNmae(sc.next()
		 break;
	 case 2:
		 System.out.println("enter the age");
		 std.setAge(sc.nextInt());
		 break;
	 case 3:
		 System.out.println("enter the marks");
		 std.setMarks(sc.nextInt());
		 break;
		 default:
			 try {
					throw new IvalidChoiceException("invalid input");
					
				}
				catch(Exception e) {

				System.out.println(e.getMessage());
					
				}
			 System.out.println("---------------------------");
	 }
	 
 }
 else {
	 String message="student id :"+id+"is not present";
		try {
			throw new  StudentNotFoundException(message);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	 
 }
	}

	private String toUpperCase(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void countStudents() {
		// TODO Auto-generated method stub
		System.out.println("no of students :"+db.size());

	}

	@Override
	public void sortStudents() {
		// TODO Auto-generated method stub
		if(db.size()>=2) {
	Set<String>keys=db.keySet();
	List<Student> li= new ArrayList<Student>();
	for(String val:keys) {
		li.add(db.get(val));
	}

	System.out.println(" 1.sort by id\n 2.sort by name\n 3.sort by age \n 4.sort by marks");
	int choice=sc.nextInt();
	switch(choice) {
	case 1:
		Collections.sort(li,new SortStudentById());
		display(li);
		break;
	case 2:
		Collections.sort(li,new SortStudentByNmae());
		display(li);
		break;
	case 3:
		Collections.sort(li,new SortStudentByAge());
		display(li);
		break;
	case 4:
		Collections.sort(li,new SortStudentByMarks());
		display(li);
		break;
		default:
			try {
				throw new IvalidChoiceException("invalid input");
				
			}
			catch(Exception e) {

			System.out.println(e.getMessage());
				
			}
	}
		}
		else {
			String message="no sufficient records to sort";
			try {
				throw new  StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
private static void display(List<Student> li) {
	for(Student key:li) {
		System.out.println(key);
	}
}

	@Override
	public void getStudentWithHighestMarks() {
		// TODO Auto-generated method stub
		if(db.size()>=2) {
		Set<String> key=db.keySet();
		List<Student> li=new ArrayList<Student>();
		for(String val:key) {
			li.add(db.get(val));
		}
Collections.sort(li,new SortStudentByMarks());
System.out.println(li.get(li.size()-1));
		}
		else {
			String message="no sufficient records to compare";
			try {
				throw new  StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void getStudentWithLowerMarks() {
		// TODO Auto-generated method stub
		if(db.size()>=2) {
		Set<String> key=db.keySet();
		List<Student> li=new ArrayList<Student>();
		for(String val:key) {
			li.add(db.get(val));
		}
Collections.sort(li,new SortStudentByMarks());
System.out.println(li.get(0));
		}
		else {
			String message="no sufficient records to compare";
			try {
				throw new  StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


}
