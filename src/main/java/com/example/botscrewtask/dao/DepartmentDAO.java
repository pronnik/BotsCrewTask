package com.example.botscrewtask.dao;

import com.example.botscrewtask.entities.DepartmentEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DepartmentDAO {
    private final SessionFactory sessionFactory;


    public  DepartmentEntity getDepartment(String departmentName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        DepartmentEntity entity = session.createQuery("from DepartmentEntity where departmentName='" + departmentName + "'", DepartmentEntity.class).getSingleResult();
        transaction.commit();
        session.close();
        return entity;
    }
}
