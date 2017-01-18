package com.kerpach.components.services;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.kerpach.components.entity.Department;
import com.kerpach.components.entity.request.DepartmentRequest;
import com.kerpach.components.interfaces.IDepartment;
import com.kerpach.persistence.HibernateUtil;

@Repository
public class DepartmentDAO implements IDepartment {


	public void createDepartment(DepartmentRequest departmentRequest) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Department department = new Department(departmentRequest.getTitleDepartmnet(),
					departmentRequest.getDateCreate());
			session.save(department);
		} finally {
			session.getTransaction().commit();
			if (session.isOpen()) {
				session.close();
			}
		}
	}

	public Department findDepartmentById(Integer id) {
		Session session = null;
		Department department;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			department = session.get(Department.class, id);

			session.getTransaction().commit();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return department;
	}

	public Collection<Department> findAllDepartment() {
		Session session = null;
		List<Department> departments;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String hql = "select d from Department d";
			Query query = session.createQuery(hql);
			departments = query.list();
			session.getTransaction().commit();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return departments;
	}

	@Override
	public void deleteDepartment(Integer id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Department del = (Department) session.get(Department.class, id);
			session.delete(del);

			session.getTransaction().commit();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void updateDepartment(Department department) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Department update = (Department) session.get(Department.class, department.getId());
			update.setTitleDepartmnet(department.getTitleDepartmnet());
			update.setDateCreate(department.getDateCreate());
			session.update(update);
			session.getTransaction().commit();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

	}

}
