package org.example.dao;

import org.example.models.*;
import org.example.models.Feed;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FeedDAO {
    public Feed findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Feed.class, id);
    }

    public void save(Feed feed) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(feed);
        tx1.commit();
        session.close();
    }

    public void update(Feed feed) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(feed);
        tx1.commit();
        session.close();
    }

    public void delete(Feed feed) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(feed);
        tx1.commit();
        session.close();
    }

    public List<Feed> findAll() {
        List<Feed> feed = (List<Feed>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Feed").list();
        return feed;
    }
}
