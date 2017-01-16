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
public class PositionDAO implements IPosition{

     Session session = HibernateUtil.getSessionFactory().openSession();
     
     public void createPosition(PositionRequest positionRequest){
    	 Session session = HibernateUtil.getSessionFactory().openSession();
    	 session.beginTransaction();
         Position position = new Position(positionRequest.getTitlePosition(), positionRequest.getRegCodPosition(), positionRequest.getSalaryPosition());
         session.save(position);
         session.getTransaction().commit();
         if (session.isOpen()) {
			 session.close();
		 }
     }
     
     public Position findPositionById(Integer id){
    	 Session session = HibernateUtil.getSessionFactory().openSession();
    	 session.beginTransaction();
         
         Position position = session.get(Position.class, id);
         
         session.getTransaction().commit();
         if (session.isOpen()) {
			 session.close();
		 }
         return position;
     }
     
     public Collection<Position> findAllPosition(){
    	 Session session = HibernateUtil.getSessionFactory().openSession();
    	 session.beginTransaction();     
    	 String hql = "select p from Position p";
    	 Query query = session.createQuery(hql);
    	 List<Position> positions = query.list();          
         session.getTransaction().commit();
         if (session.isOpen()) {
			 session.close();
		 }
         return positions;
     }

	@Override
	public void deletePosition(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Position del = (Position) session.get(Position.class, id);
        session.delete(del);
        
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }	
	}

	@Override
	public void updatePosition(Position position) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Position update = (Position) session.get(Position.class, position.getId());
        update.setTitlePosition(position.getTitlePosition());
        update.setRegCodPosition(position.getRegCodPosition());
        update.setSalaryPosition(position.getSalaryPosition());
        session.update(update);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
		
	}
}
