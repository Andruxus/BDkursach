package org.example.dao;

import org.example.models.Countries;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CountriesDAO {
    public Countries findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Countries.class, id);
    }

    public void save(Countries countries) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(countries);
        tx1.commit();
        session.close();
    }

    public void update(Countries countries) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(countries);
        tx1.commit();
        session.close();
    }

    public void delete(Countries countries) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(countries);
        tx1.commit();
        session.close();
    }
    public List<Countries> findAll() {
        List<Countries> countries = (List<Countries>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Countries").list();
        return countries;
    }
}
