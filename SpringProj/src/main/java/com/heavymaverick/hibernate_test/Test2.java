package com.heavymaverick.hibernate_test;

import com.heavymaverick.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()){

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 1);
//            session.delete(emp);
//            session.createQuery("delete Employee where name = 'Oleg'").executeUpdate();
            Employee emp = new Employee("AAA", "BBB", "IT", 750);
            session.save(emp);
            session.getTransaction().commit();
            session.close();
        }
    }
}
