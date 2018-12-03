package com.mindtree.dao.hibernateImpl;

import java.io.Serializable;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mindtree.dao.EmployeeDao;
import com.mindtree.entity.Employee;

public class EmployeeDaoHibernateImpl implements EmployeeDao {

	public int addEmployee(Employee employee) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Serializable i = session.save(employee);
		int j = (Integer) i;
		session.getTransaction().commit();
		session.close();
		sf.close();
		System.out.println("Employee added...");
		return j;
	}

	public Employee getEmployee(int no) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Employee employee = (Employee) session.get(Employee.class, no);
		session.close();
		sf.close();
		return employee;
	}

	public void deleteEmployee(int no) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Employee c = getEmployee(no);
		session.delete(c);
		tx.commit();
		sf.close();
		System.out.println("Deleted successfully ");
	}

	public void updateEmployee(Employee employee) {
		//Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
		//SessionFactory sf = con.buildSessionFactory();
		//Session session = sf.openSession();
		//Transaction tx = session.beginTransaction();
		//session.update(employee);
		//tx.commit();
		//session.close();
		//sf.close();
		//System.out.println("Updated successfully...");
		System.out.println(employee.getSalary()+employee.getEmployeeNo());
		Configuration con1 = new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sf1 = con1.buildSessionFactory();
		Session session1 = sf1.openSession();
		Transaction tx1 = session1.beginTransaction();
		SQLQuery query1 = session1.createSQLQuery("update Employee set salary=:Salary where employeeno=:emp");
		query1.setParameter("Salary", employee.getSalary());
		
		query1.setParameter("emp", employee.getEmployeeNo());
		int up = query1.executeUpdate();
		tx1.commit();
		session1.close();
		sf1.close();
		System.out.println("Updates successfully"+up);
		
	}

}

