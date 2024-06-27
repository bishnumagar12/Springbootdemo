package com.appsoft.springbootdemo.service;

import java.util.List;

import com.appsoft.springbootdemo.model.Department;

public interface DepartmentService {
 
	void addDept(Department dept);
	
	void deleteDept(int id);
	
	void updateDept(Department dept);
	
	Department getById(int id);
	
	List<Department> getAllDepts();
}
