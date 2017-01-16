package com.kerpach.components.interfaces;

import java.util.Collection;

import com.kerpach.components.entity.Department;
import com.kerpach.components.entity.request.DepartmentRequest;

public interface IDepartment {
	public void createDepartment(DepartmentRequest departmentRequest);
	
	public Department findDepartmentById(Integer id);
	
	public Collection<Department> findAllDepartment();
	
	public void deleteDepartment(Integer id);
	
	public void updateDepartment(Department department);
}
