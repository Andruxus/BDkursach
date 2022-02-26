package org.example.dao;

import org.example.models.Discounts;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DiscountsDAO {
    public Discounts findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Discounts.class, id);
    }

    public void save(Discounts discounts) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(discounts);
        tx1.commit();
        session.close();
    }

    public void update(Discounts discounts) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(discounts);
        tx1.commit();
        session.close();
    }

    public void delete(Discounts discounts) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(discounts);
        tx1.commit();
        session.close();
    }
    public List<Discounts> findAll() {
        List<Discounts> discounts = (List<Discounts>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Discounts").list();
        return discounts;
    }
}
