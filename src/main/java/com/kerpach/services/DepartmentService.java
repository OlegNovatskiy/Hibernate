package com.kerpach.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kerpach.components.entity.Department;
import com.kerpach.components.entity.request.DepartmentRequest;
import com.kerpach.components.interfaces.IDepartment;

@Service
public class DepartmentService {

	@Autowired
	private IDepartment iDepartment;
	
	public void createDepartment(DepartmentRequest departmentRequest) {
		iDepartment.createDepartment(departmentRequest);
	}

	public Department findDepartmentById(Integer id) {
		return iDepartment.findDepartmentById(id);
	}

	public Collection<Department> findAllDepartment() {
		return iDepartment.findAllDepartment();
	}

	public void deleteDepartment(Integer id) {
		iDepartment.deleteDepartment(id);
	}

	public void updateDepartment(Department department) {
		iDepartment.updateDepartment(department);
	}
	
}
