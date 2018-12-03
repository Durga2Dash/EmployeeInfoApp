package com.mindtree.Service;

import java.util.Set;

import com.mindtree.entity.Department;
import com.mindtree.entity.Employee;

public interface DepartmentService {

	void createDepartment(Department dept);
	void addEmployeeToDepartment(Employee emp, Department dept);
	void removeEmployeeFromDepartment(Employee emp, Department dept);
	Department getDepartment(int id);
	Set<Employee> getEmployees();
}
