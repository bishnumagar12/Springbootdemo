package com.appsoft.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appsoft.springbootdemo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
