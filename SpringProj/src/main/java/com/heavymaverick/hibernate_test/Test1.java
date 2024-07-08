package com.heavymaverick.hibernate_test;

import com.heavymaverick.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()){
            Session session = sessionFactory.openSession();
            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 1);
//            emp.setSalary(2000);
            session.createQuery("update Employee set salary = 1000 where name = 'Elena'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("DOne");
        }
    }
}
