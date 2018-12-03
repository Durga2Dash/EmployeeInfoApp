package com.mindtree.EmployeeInfoApp;

import java.util.Date;
import java.util.Scanner;

import com.mindtree.Service.EmployeeServiceImpl.DepartmentServiceImpl;
import com.mindtree.Service.EmployeeServiceImpl.EmployeeServiceImpl;
import com.mindtree.dao.hibernateImpl.DepartmentDaoHibernateImpl;
import com.mindtree.entity.Department;
import com.mindtree.entity.Employee;

public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Scanner sc1 = new Scanner(System.in);
        int flag = 1;
        while(flag == 1)
        {
        	System.out.println("*******************************");
        	System.out.println("1. Employee Functions");
        	System.out.println("2. Department Functions");
        	System.out.println("3. Exit");
        	System.out.println();
        	System.out.println("Enter your choice.. ");
        	int input1 = sc1.nextInt();
        	switch(input1)
        	{
        	case 1:
        		System.out.println("************************************");
        		System.out.println("1. Add Employees details ");
        		System.out.println("2. Get employee details ");
        		System.out.println("3. Delete employee by Id ");
        		System.out.println("4. Update Employee details ");
        		System.out.println();
        		
        		System.out.println("Enter the choice of operation ");
        		int input2 = sc1.nextInt();
        		Employee e = new Employee();
        		EmployeeServiceImpl e1 = new EmployeeServiceImpl();
        		DepartmentServiceImpl d12 = new DepartmentServiceImpl();
        		switch(input2)
        		{
        		case 1:
//        			System.out.println("Enter employee number");
//        			e.setEmployeeNo(sc1.nextInt());
        			System.out.println("Enter employee name");
        			e.setEmployeeName(sc1.next());
        			System.out.println("Enter emailId");
        			e.setEmail(sc1.next());
        			System.out.println("Enter dateOfBirth");
        			System.out.println("Enter date");
        			int date = sc1.nextInt();
        			System.out.println("Enter month");
        			int month = sc1.nextInt();
        			System.out.println("Enter year");
        			int year = sc1.nextInt();
        			e.setDateOfBirth(new Date(year,month-1,date));
        			System.out.println("Enter salary");
        			e.setSalary(sc1.nextDouble());
        			System.out.println("Enter department no");
        			e.setDepartment(d12.getDepartment(sc1.nextInt()));
        			e1.addEmployee(e);
        			break;
        		case 2:
        			System.out.println("Enter employee number");
        			System.out.println(e1.getEmployee(sc1.nextInt()));
        			break;
        		case 3:
        			System.out.println("Enter employee id");
        			e1.deleteEmployee(sc1.nextInt());
        			break;
        		case 4:
        			System.out.println("Enter employee number");
        			e.setEmployeeNo(sc1.nextInt());
        			System.out.println("Enter employee name");
        			e.setEmployeeName(sc1.next());
        			System.out.println("Enter emailId");
        			e.setEmail(sc1.next());
        			System.out.println("Enter dateOfBirth");
        			System.out.println("Enter date");
        			date = sc1.nextInt();
        			System.out.println("Enter month");
        			month = sc1.nextInt();
        			System.out.println("Enter year");
        			year = sc1.nextInt();
        			e.setDateOfBirth(new Date(year,month,date));
        			System.out.println("Enter salary");
        			e.setSalary(sc1.nextDouble());
        			System.out.println("Enter department no");
        			e.setDepartment(d12.getDepartment(sc1.nextInt()));
        			e1.updateEmployee(e);
        			break;
        		default:
        			System.out.println("Stopped running");
        			break;
        		}
        		break;
        	case 2:
        		System.out.println("*********************************************");
        		System.out.println("1. Create Department");
        		System.out.println("2. Add Employee to Department");
        		System.out.println("3. Remove Employee from Department");
        		System.out.println("4. Get all employees");
        		System.out.println("5. Get department by id");
        		System.out.println();
        		
        		System.out.println("Enter your choice of operation ");
        		int input3 = sc1.nextInt();
        		e = new Employee();
        		e1 = new EmployeeServiceImpl();
        		
        		Department d = new Department();
        		DepartmentDaoHibernateImpl d1 = new DepartmentDaoHibernateImpl();
        		switch(input3)
        		{
        		case 1:
//        			System.out.println("Enter department no");
//        			d.setDepartmentNo(sc1.nextInt());
        			System.out.println("Enter department name");
        			d.setDepartmentName(sc1.next());
        			d1.createDepartment(d);
        			break;
        		case 2:
        			System.out.println("Enter employee id");
        			e = e1.getEmployee(sc1.nextInt());
        			System.out.println("Enter department id");
        			d = d1.getDepartment(sc1.nextInt());
        			
        			d1.addEmployeeToDepartment(e, d);
        			break;
        		case 3:
        			System.out.println("Enter employee id");
        			e = e1.getEmployee(sc1.nextInt());
        			System.out.println("Enter department id");
        			d = d1.getDepartment(sc1.nextInt());
        			d1.removeEmployeeFromDepartment(e, d);
        			break;
        		case 4:
        			// Use for loop to print  the set
        			System.out.println(d1.getEmployees());
        			break;
        		case 5:
        			System.out.println("Enter department id");
        			d = d1.getDepartment(sc1.nextInt());
        			System.out.println(d);
        			break;
        		default:
        			System.out.println("Stopped running");
        			break;
        		}
        		break;
        	case 3:
        		System.out.println("Program terminated");
        		flag = 0;
        		break;
        	default:
        		System.out.println("Wrong input");
        		break;
        	}
        }
        sc1.close();
    }
}
