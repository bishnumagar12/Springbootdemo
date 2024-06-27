package com.appsoft.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.appsoft.springbootdemo.model.Department;
import com.appsoft.springbootdemo.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/department")
	public String getDepartment() {
		return "DepartmentForm";
		
	}
	@PostMapping("/department")
	public String postDepartment(@ModelAttribute Department dept) {
		deptService.addDept(dept);
		return "DepartmentForm";
		
	}
	@GetMapping("/departmentList")
	public String deptList( Model model) {
		model.addAttribute("dlist", deptService.getAllDepts());
		return "DepartmentList";
		
	}
	
	@GetMapping("/dept/delete")
	public String deleteDepartment(@RequestParam int id) {
		deptService.deleteDept(id);
		return "redirect:/departmentList";
		
	}
	
	@GetMapping("/dept/edit")
	public String editDepartment(@RequestParam int id, Model model) {
		model.addAttribute("dModel", deptService.getById(id));
		return "DepartmentEditForm";
		
	}
	@PostMapping("/dept/update")
	public String updateDepartment(@ModelAttribute Department dept) {
		deptService.updateDept(dept);
		return "redirect:/departmentList";
		
	}
}
