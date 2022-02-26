package org.example.dao;

import org.example.models.Contract;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ContractDAO {
    public Contract findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Contract.class, id);
    }

    public void save(Contract contract) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(contract);
        tx1.commit();
        session.close();
    }

    public void update(Contract contract) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(contract);
        tx1.commit();
        session.close();
    }

    public void delete(Contract contract) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(contract);
        tx1.commit();
        session.close();
    }
    public List<Contract> findAll() {
        List<Contract> contract = (List<Contract>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Contract").list();
        return contract;
    }
}
