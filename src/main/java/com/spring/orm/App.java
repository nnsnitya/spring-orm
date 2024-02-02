package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
       StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
       /*Student student = new Student(2324, "Nityanand Singh", "Gorakhpur");
       int r = studentDao.insert(student);
       System.out.println("done "+r);*/
       
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       boolean go = true;
       while(go) {
    	   System.out.println("PRESS 1: to add new Student ");
    	   System.out.println("PRESS 2: to display All Students ");
    	   System.out.println("PRESS 3: to get detail of single Student ");
    	   System.out.println("PRESS 4: to delete Students ");
    	   System.out.println("PRESS 5: to update Student ");
    	   System.out.println("PRESS 6: to exit ");
       
	       try {
	    	   int input = Integer.parseInt(br.readLine());
	    	   switch(input) {
	    	   case 1:
	    		   //add a new student
	    		   System.out.println("Enter Student id: ");
	    		   int stId = Integer.parseInt(br.readLine());
	    		   System.out.println("Enter Student Name: ");
	    		   String stName = br.readLine();
	    		   System.out.println("Enter Student City: ");
	    		   String stCity = br.readLine();
	    		   Student s = new Student();
	    		   s.setStudentId(stId);
	    		   s.setStudentName(stName);
	    		   s.setStudentCity(stCity);
	    		   int r = studentDao.insert(s);
	    		   System.out.println(r+" student added");
	    		   System.out.println("*********************");
	    		   System.out.println();
	    		   break;
	    	   case 2:
	    		   //display all students
	    		   System.out.println("*********************");
	    		   List<Student> allStudents = studentDao.getAllStudents();
	    		   for(Student st: allStudents) {
	    			   System.out.println("Id: "+st.getStudentId());
	    			   System.out.println("Name: "+st.getStudentName());
	    			   System.out.println("City: "+st.getStudentCity());
	    			   System.out.println("-----------------------");
	    		   }
	    		   System.out.println("*********************");
	    		   break;
	    	   case 3:
	    		   //get single student data
	    		   System.out.println("*********************");
	    		   System.out.println("Enter Student Id: ");
	    		   int studId = Integer.parseInt(br.readLine());
	    		   Student student = studentDao.getStudent(studId);
	    		   System.out.println("Id: "+student.getStudentId());
	    		   System.out.println("Name: "+student.getStudentName());
	    		   System.out.println("City: "+student.getStudentCity());
	    		   System.out.println("*********************");
	    		   break;
	    	   case 4:
	    		   //delete student
	    		   System.out.println("*********************");
	    		   System.out.println("Enter student Id: ");
	    		   int id = Integer.parseInt(br.readLine());
	    		   studentDao.deleteStudent(id);
	    		   System.out.println("Student deleted with id: "+id);
	    		   System.out.println("*********************");
	    		   break;
	    	   case 5:
	    		   //update the student
	    		   break;
	    	   case 6:
	    		   //exit
	    		   go = false;
	    		   break;
	    	   }
	    	   
	       } catch(Exception e) {
	    	   System.out.println("Invalid input.., Try with another option: ");
	    	   System.out.println(e.getMessage());
	       }
       }
       System.out.println("Thankyou for using my Applicaion");
       System.out.println("See You Soon! ");
    }
}
