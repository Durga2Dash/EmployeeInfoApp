package com.mindtree.dao;

import com.mindtree.entity.Employee;

public interface EmployeeDao {

		int addEmployee(Employee employee);
		Employee getEmployee(int no);
		void deleteEmployee(int no);
		void updateEmployee(Employee employee);
}
