package org.example.dao;

import org.example.models.*;
import org.example.models.Tour;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
@Component
public class TourDAO {
    public Tour findById(int id) {
        Tour tour = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Tour.class, id);
        return tour;

    }

    public void save(Tour tour) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(tour);
        tx1.commit();
        session.close();
    }

    public void update(Tour tour) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(tour);
        tx1.commit();
        session.close();
    }
    @Transactional
    public void delete(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Tour tour = (Tour)session.load(Tour.class,id);
        session.delete(tour);
        session.close();
    }
    public List<Tour> findAll() {
        List<Tour> tour = (List<Tour>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Tour").list();
        return tour;
    }
    public String toString(List<Tour> tour) {
        String s="";
        for (Tour tou :tour){
            s+="Tour:"+tou.getName()+" "+tou.getCountry()+" "+tou.getOperator()+" "+tou.getPrice()+" "+tou.getDate()+"\n";
        }
        return s;
    }
    }

