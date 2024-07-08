package com.heavymaverick.hibernate_test;

import com.heavymaverick.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            List employees = session.createQuery("from Employee where name = 'Elena' AND salary > 650").getResultList();
            for (Object employee : employees) {
                System.out.println(employee);
            }

            session.getTransaction().commit();
            System.out.println("!DONE!");

        }
    }
}
