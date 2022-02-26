package org.example.dao;

import org.example.models.*;
import org.example.models.Worker;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class WorkerDAO {
    public Worker findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Worker.class, id);
    }

    public void save(Worker worker) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(worker);
        tx1.commit();
        session.close();
    }

    public void update(Worker worker) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(worker);
        tx1.commit();
        session.close();
    }

    public void delete(Worker worker) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(worker);
        tx1.commit();
        session.close();
    }
    public List<Worker> findAll() {
        List<Worker> worker = (List<Worker>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Worker").list();
        return worker;
    }
}
