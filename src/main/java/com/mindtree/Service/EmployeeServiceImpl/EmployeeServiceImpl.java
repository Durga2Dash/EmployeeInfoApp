package com.mindtree.Service.EmployeeServiceImpl;

import com.mindtree.Service.EmployeeService;
import com.mindtree.dao.hibernateImpl.EmployeeDaoHibernateImpl;
import com.mindtree.entity.Employee;
public class EmployeeServiceImpl implements EmployeeService {

	public int addEmployee(Employee employee) {
		EmployeeDaoHibernateImpl emp = new EmployeeDaoHibernateImpl();
		return emp.addEmployee(employee);
	}

	public Employee getEmployee(Integer EmployeeNo) {
		EmployeeDaoHibernateImpl emp = new EmployeeDaoHibernateImpl();
		return emp.getEmployee(EmployeeNo);
	}

	public void deleteEmployee(int EmployeeNo) {
		EmployeeDaoHibernateImpl emp = new EmployeeDaoHibernateImpl();
		emp.deleteEmployee(EmployeeNo);
	}

	public void updateEmployee(Employee employee) {
		EmployeeDaoHibernateImpl emp = new EmployeeDaoHibernateImpl();
		emp.updateEmployee(employee);
	}
	
}
