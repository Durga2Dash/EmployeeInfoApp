package com.mindtree.dao.hibernateImpl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mindtree.dao.DepartmentDao;
import com.mindtree.entity.Department;
import com.mindtree.entity.Employee;

public class DepartmentDaoHibernateImpl implements DepartmentDao {

	public void createDepartment(Department dept) {
		try {
			Configuration con = new Configuration().configure();
			SessionFactory sf = con.buildSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(dept);
			session.getTransaction().commit();
			session.close();
			sf.close();
			System.out.println("Added Department...");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void addEmployeeToDepartment(Employee emp, Department dept) {
		emp.setDepartment(dept);
		try {
		Configuration con = new Configuration().configure().addAnnotatedClass(Department.class).addAnnotatedClass(Employee.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(emp);
		session.getTransaction().commit();
		session.close();
		sf.close();
		System.out.println("Employee added to department...");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void removeEmployeeFromDepartment(Employee emp, Department dept) {
		if(emp.getDepartment().getDepartmentNo() == dept.getDepartmentNo())
		{
			try {
			Configuration con = new Configuration().configure().addAnnotatedClass(Department.class).addAnnotatedClass(Employee.class);
			SessionFactory sf = con.buildSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			session.update(dept);
			session.getTransaction().commit();
			session.close();
			sf.close();
			System.out.println("Employee removed succefully...");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		}

	public Set<Employee> getEmployees() {
		try {
			Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);
			SessionFactory sf = con.buildSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from  Employee");   // HQL
			List<Employee> list1 = query.list();
			session.getTransaction().commit();
			session.close();
			sf.close();
			Set<Employee> set = new LinkedHashSet<Employee>(list1);
			return set;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public Department getDepartment(int id) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Department.class).addAnnotatedClass(Employee.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Department d = (Department) session.get(Department.class, id);
		session.getTransaction().commit();
		session.close();
		sf.close();
		return d;
	}

}
