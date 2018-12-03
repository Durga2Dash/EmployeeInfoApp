package com.mindtree.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Department {

		private int departmentNo;
		private String departmentName;
		private Set<Employee> employee = new LinkedHashSet<Employee>();
		public int getDepartmentNo() {
			return departmentNo;
		}
		public void setDepartmentNo(int departmentNo) {
			this.departmentNo = departmentNo;
		}
		public String getDepartmentName() {
			return departmentName;
		}
		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}
		public Set<Employee> getEmployee() {
			return employee;
		}
		public void setEmployee(Set<Employee> employee) {
			this.employee = employee;
		}
		@Override
		public String toString() {
			return "Department [departmentNo=" + departmentNo + ", departmentName=" + departmentName + "]";
		}
		
		
}
