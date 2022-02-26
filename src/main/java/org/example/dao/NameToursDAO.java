package org.example.dao;

import org.example.models.*;
import org.example.models.NameTours;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NameToursDAO {
    public NameTours findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(NameTours.class, id);
    }

    public void save(NameTours nameTours) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(nameTours);
        tx1.commit();
        session.close();
    }

    public void update(NameTours nameTours) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(nameTours);
        tx1.commit();
        session.close();
    }

    public void delete(NameTours nameTours) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(nameTours);
        tx1.commit();
        session.close();
    }
    public List<NameTours> findAll() {
        List<NameTours> nameTours = (List<NameTours>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From NameTours").list();
        return nameTours;
    }
}
