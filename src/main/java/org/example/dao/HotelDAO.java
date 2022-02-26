package org.example.dao;

import org.example.models.*;
import org.example.models.Hotel;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HotelDAO {
    public Hotel findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Hotel.class, id);
    }

    public void save(Hotel hotel) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(hotel);
        tx1.commit();
        session.close();
    }

    public void update(Hotel hotel) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(hotel);
        tx1.commit();
        session.close();
    }

    public void delete(Hotel hotel) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(hotel);
        tx1.commit();
        session.close();
    }
    public List<Hotel> findAll() {
        List<Hotel> hotel = (List<Hotel>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Hotel").list();
        return hotel;
    }
}
