package org.example.one_to_one.demo;

import org.example.one_to_one.entity.Instructor;
import org.example.one_to_one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try (factory) {

            session.beginTransaction();

            int id = 2;
            Instructor instructor = session.get(Instructor.class, id);
            session.delete(instructor);

            // WITH THIS CODE WE AREN'T DELETE joined tables
            session.createQuery("delete Instructor i where i.id > 4").executeUpdate();
            session.getTransaction().commit();
        }


    }
}
