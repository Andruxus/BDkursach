package org.example.dao;

import org.example.models.Comment;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CommentDAO {
    public Comment findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Comment.class, id);
    }

    public void save(Comment comment) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(comment);
        tx1.commit();
        session.close();
    }

    public void update(Comment comment) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(comment);
        tx1.commit();
        session.close();
    }

    public void delete(Comment comment) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(comment);
        tx1.commit();
        session.close();
    }
    public List<Comment> findAll() {
        List<Comment> comments = (List<Comment>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Comment").list();
        return comments;
    }
}
