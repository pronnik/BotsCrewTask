package com.example.botscrewtask.dao;

import com.example.botscrewtask.entities.LectorEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LectorDAO {
    private final SessionFactory sessionFactory;

    public LectorEntity lectorByID(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LectorEntity lector = session.get(LectorEntity.class, id);
        transaction.commit();
        session.close();
        return lector;
    }

    public List<LectorEntity> lectorsByTemplate(String template) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LectorEntity> lectors = session.createQuery("from LectorEntity where lectorName like '%" + template + "%'", LectorEntity.class).getResultList();
        transaction.commit();
        session.close();
        return lectors;
    }


}
