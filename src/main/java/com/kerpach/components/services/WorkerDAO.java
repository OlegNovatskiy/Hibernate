package com.kerpach.components.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kerpach.components.entity.Worker;
import com.kerpach.components.entity.request.WorkerRequest;
import com.kerpach.components.interfaces.IWorker;
import com.kerpach.persistence.HibernateUtil;

@Repository
public class WorkerDAO implements IWorker {
	
	public Collection<Worker> getTest1() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query sqlQuery = session.createSQLQuery("SELECT fname FROM Workers");
		//Query hqlQuery = session.createQuery("SELECT workers FROM Worker workers");
		List<Worker> workers = sqlQuery.list();
		session.getTransaction().commit();
		session.close();
		return workers;
	}
	
	public Collection<Worker> getTest(DetachedCriteria query) {
		Session session = HibernateUtil.getSessionFactory().openSession();
//		Collection<Worker> workers = session.createCriteria(Worker.class)
//				 -.createAlias("fnameWorker", "fw")
//				 .add(Restrictions.like("fnameWorker", "No",
//				 MatchMode.ANYWHERE))
//				 .addOrder(Order.asc("fnameWorker"))
//				 .add(Restrictions.between("position", 1, 5))
//				 .setFirstResult(2)
//				 .setMaxResults(2)
//				 .createCriteria("position").add(Restrictions.eq("id", 1))
//				.list();
		Collection<Worker> workers = query.getExecutableCriteria(session).list();
		session.close();
		return workers;
	}

	public void createWorker(WorkerRequest workerRequest) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Worker worker = new Worker(workerRequest.getFnameWorker(), workerRequest.getSnameWorker(),
					workerRequest.getTnameWorker(), workerRequest.getDateBirth());
			session.save(worker);
			session.getTransaction().commit();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}

	public Worker findWorkerById(Integer id) {
		Worker worker;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			worker = session.get(Worker.class, id);

			session.getTransaction().commit();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return worker;
	}

	public Collection<Worker> findAllWorker() {
		List<Worker> workers;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String hql = "select p from Worker p";
			Query query = session.createQuery(hql);
			workers = query.list();
			session.getTransaction().commit();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return workers;
	}

	@Override
	public void deleteWorker(Integer id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Worker del = new Worker();// (Worker) session.get(Worker.class, id);
			del.setId(id);
			session.delete(del);

			session.getTransaction().commit();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void updateWorker(Worker worker) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Worker update = (Worker) session.get(Worker.class, worker.getId());
			update.setFnameWorker(worker.getFnameWorker());
			update.setSnameWorker(worker.getSnameWorker());
			update.setTnameWorker(worker.getTnameWorker());
			update.setDateBirth(worker.getDateBirth());
			session.update(update);
			session.getTransaction().commit();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

	}

}
