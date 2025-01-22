package com.chetan.SpringORM;


import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chetan.dao.StudentDao;
import com.chetan.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
        boolean go = true;
        
        while(go)
        {
        	System.out.println( "*********** Welcome to ORM Project *************\n\n" );
        	System.out.println("\nEnter Press 1 for Add Student Detais: ");
        	System.out.println("\nEnter Press 2 for View All Student Detais: ");
        	System.out.println("\nEnter Press 3 for View Single Student Detais: ");
        	System.out.println("\nEnter Press 4 for Update Student Detais: ");
        	System.out.println("\nEnter Press 5 for Delete Student Detais: ");
        	System.out.println("\nEnter Press 6 for Exit -->>");
        	System.out.println("\n---------------------------------------------------");
        	
        	try{
        		
        		Scanner sc = new Scanner(System.in);
        		System.out.println("Enter Key (1,2,3,4,5,6): ");
        		
        		int input = Integer.parseInt(sc.nextLine());
        		
        		System.out.println("\n---------------------------------------------------");
        		
        		switch(input)
        		{
        			case 1: 
        					System.out.println("-- Enter Student Information --\n");
        				   	System.out.println("Enter Student Id: ");
        				   	int stdId = sc.nextInt();
        				   	sc.nextLine();
        				   	
        				   	System.out.println("Enter Student Name: ");
        				   	String stdName = sc.nextLine();
        				   	
        				   	
        				   	System.out.println("Enter Student City: ");
        				   	String stdCity = sc.nextLine();
        				   	
        				   	//creating student class object
        				   	
        				   	Student student = context.getBean("student",Student.class);
        				   	
        				   	student.setStdId(stdId);
        				   	student.setStdName(stdName);
        				   	student.setStdCity(stdCity);
        				   	
        				   	//save student object to database
        				   	
        				   	int i = studentDao.insert(student);
        				   	System.out.println(1+" Student is Added.");
        				   	System.out.println("-------------------------------------------------------");
        				   	
        				   	break;
        				   	
        			case 2:
        					
        					System.out.println("--View All Students Information --\n");
        					
        					List<Student> allStudent = studentDao.getAll();
        					
        					for(Student str : allStudent)
        					{
        						System.out.println("Student Id: "+str.getStdId());
        						System.out.println("Student Name: "+str.getStdName());
        						System.out.println("Student City: "+str.getStdCity());
        						System.out.println("---------------------------------------");
        					}
        					System.out.println("-------------------------------------------------------");
        					
        					break;
        					
        			case 3:
        					
	        				System.out.println("-- View Single Student Information --");
	        				
	        				System.out.println("\n Enter Student Id: ");
	        				int id = sc.nextInt();
	        				
	        				student = (Student) studentDao.getStudent(id);
	        				System.out.println("Student Id: "+student.getStdId());
							System.out.println("Student Name: "+student.getStdName());
							System.out.println("Student City: "+student.getStdCity());
							System.out.println("-------------------------------------------------------");
	    					
	    					break;
        			case 4:
        				System.out.println("-- Update Student Information --");
        				
        				System.out.println("\n Enter Student Id: ");
        				stdId = sc.nextInt()
        						;
        				student = (Student) studentDao.getStudent(stdId);
        				
        				System.out.println("-------------------------------------------------------");
        				System.out.println("Student Id: "+student.getStdId());
						System.out.println("Student Name: "+student.getStdName());
						System.out.println("Student City: "+student.getStdCity());
						System.out.println("-------------------------------------------------------");
						
						System.out.println("Which parameter you want to update : ");
						System.out.println("Menu: \n1. Name \n3. City");
						System.out.println("Enter Key (1,2): ");
		        		
						sc.nextLine();
		        		input = Integer.parseInt(sc.nextLine());
		        		
		        		System.out.println("\n---------------------------------------------------");
						
						
						switch(input)
						{
							   
							case 1:
								  
								   System.out.println("Enter Updated Student Name: ");
								   stdName = sc.nextLine();
								   student.setStdName(stdName);;
								   studentDao.updateStudent(student);
								  
								   System.out.println("\n---------------------------------------------------");
								   break;
								   
							case 2:
								   
								   System.out.println("Enter Updated Student City: ");
								   stdCity = sc.nextLine();
								   student.setStdCity(stdCity);
								   studentDao.updateStudent(student);
								   
								   break;
								   
								   
						  default:
							  System.out.println("Enter Valid Input");
							  System.out.println("-------------------------------------------------------");
						}
						
						break;
						
        			case 5: 
        				System.out.println("-------------------------------------------------------");
        				System.out.println("-- Delete Student Information --");
        				
        				System.out.println("\n Enter Student Id: ");
        				stdId = sc.nextInt();
        				
        				studentDao.deleteStudent(stdId);
        				System.out.println("-------------------------------------------------------");
        				
        				break;
        				
        			case 6:
        				go = false;
        				
        				break;
        			default:
        					System.out.println("Invalid Input");
        		}
        		
        		
        	}catch(Exception e)
        	{
        		System.out.println("Enter Valid Input");
        		System.out.println(e.getMessage());
        	}
        }
        System.out.println("Thank You for Visiting this System...");
    }
}
