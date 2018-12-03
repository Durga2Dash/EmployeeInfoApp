package com.mindtree.Service;

import com.mindtree.entity.Employee;

public interface EmployeeService {
	int addEmployee(Employee employee);
	Employee getEmployee(Integer EmployeeNo);
	void deleteEmployee(int EmployeeNo);
	void updateEmployee(Employee employee);
}
