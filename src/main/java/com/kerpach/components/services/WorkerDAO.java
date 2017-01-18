package com.kerpach.components.services;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.kerpach.components.entity.Worker;
import com.kerpach.components.entity.request.WorkerRequest;
import com.kerpach.components.interfaces.IWorker;
import com.kerpach.persistence.HibernateUtil;

@Repository
public class WorkerDAO implements IWorker {


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

			Worker del = (Worker) session.get(Worker.class, id);
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
