package com.kerpach.components.services;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.kerpach.components.entity.Position;
import com.kerpach.components.entity.request.PositionRequest;
import com.kerpach.components.interfaces.IPosition;
import com.kerpach.persistence.HibernateUtil;

@Repository
public class PositionDAO implements IPosition {

	Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public void createPosition(PositionRequest positionRequest) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Position position = new Position(positionRequest.getTitlePosition(), positionRequest.getRegCodPosition(),
					positionRequest.getSalaryPosition());
			session.save(position);
			session.getTransaction().commit();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public Position findPositionById(Integer id) {
		Session session = null;
		Position position;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			position = session.get(Position.class, id);
			session.getTransaction().commit();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return position;
	}

	@Override
	public Collection<Position> findAllPosition() {
		Session session = null;
		List<Position> positions;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String hql = "select p from Position p";
			Query query = session.createQuery(hql);
			positions = query.list();
			session.getTransaction().commit();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return positions;
	}

	@Override
	public void deletePosition(Integer id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Position del = (Position) session.get(Position.class, id);
			session.delete(del);
		} finally {
			session.getTransaction().commit();
			if (session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void updatePosition(Position position) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Position update = (Position) session.get(Position.class, position.getId());
			update.setTitlePosition(position.getTitlePosition());
			update.setRegCodPosition(position.getRegCodPosition());
			update.setSalaryPosition(position.getSalaryPosition());
			session.update(update);
			session.getTransaction().commit();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

	}
}
