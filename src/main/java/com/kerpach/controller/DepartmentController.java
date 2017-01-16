package com.kerpach.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kerpach.components.entity.Department;
import com.kerpach.components.entity.request.DepartmentRequest;
import com.kerpach.services.DepartmentService;

@Configuration
@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String addDepartment(@RequestBody DepartmentRequest departmentRequest){
		departmentService.createDepartment(departmentRequest);
		return "Department was add";
	}
	
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public Department findDepartmentById(@PathVariable("id") Integer id){
		return departmentService.findDepartmentById(id);
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public Collection<Department> findAllDepartment(){
		return departmentService.findAllDepartment();
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteDepartment(@PathVariable ("id") Integer id){
		departmentService.deleteDepartment(id);
		return "Delete Department #" + id.toString();
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateDepartment(@RequestBody Department department){
		Department olddepartment = findDepartmentById(department.getId());
		departmentService.updateDepartment(department);
		return "Update Department:\n" + olddepartment.toString() + " -> " + department.toString();
	}
	
}
