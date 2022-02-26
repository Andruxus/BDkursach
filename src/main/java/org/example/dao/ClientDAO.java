package org.example.dao;

import org.example.models.Client;
import org.example.models.Tour;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ClientDAO {
    public Client findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Client.class, id);
    }


    public void save(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(client);
        tx1.commit();
        session.close();
    }

    public void update(Client user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(session.get(Client.class, id));
        tx1.commit();
        session.close();
    }

    //public Client findAutoById(int id) {
    //   return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Client.class, id);
    //}
    public List<Client> findAll() {
        List<Client> clients = (List<Client>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Client").list();
        return clients;
    }

    public Client find() {
        Client client = (Client) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("select max(id) from Client");
        ;
        return client;
    }
    public String toString(List<Client> clients) {
        String s = "";
        for (Client tou : clients) {
            s += "Client:"+tou.getFirstName() + " " + tou.getSecondName() + " " + tou.getNumbers() + "\n";
        }
        return s;
    }
}

