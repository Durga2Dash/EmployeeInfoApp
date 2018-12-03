package com.mindtree.Service.EmployeeServiceImpl;

import java.util.Set;

import com.mindtree.Service.DepartmentService;
import com.mindtree.dao.hibernateImpl.DepartmentDaoHibernateImpl;
import com.mindtree.entity.Department;
import com.mindtree.entity.Employee;

public class DepartmentServiceImpl implements DepartmentService{

	public void createDepartment(Department dept) {
		DepartmentDaoHibernateImpl d = new DepartmentDaoHibernateImpl();
		d.createDepartment(dept);
	}

	public void addEmployeeToDepartment(Employee emp, Department dept) {
		DepartmentDaoHibernateImpl d = new DepartmentDaoHibernateImpl();
		d.addEmployeeToDepartment(emp, dept);
	}

	public void removeEmployeeFromDepartment(Employee emp, Department dept) {
		DepartmentDaoHibernateImpl d = new DepartmentDaoHibernateImpl();
		d.removeEmployeeFromDepartment(emp, dept);
	}

	public Set<Employee> getEmployees() {
		DepartmentDaoHibernateImpl d = new DepartmentDaoHibernateImpl();
		return d.getEmployees();
	}

	public Department getDepartment(int id) {
		DepartmentDaoHibernateImpl d = new DepartmentDaoHibernateImpl();
		return d.getDepartment(id);
	}

}
