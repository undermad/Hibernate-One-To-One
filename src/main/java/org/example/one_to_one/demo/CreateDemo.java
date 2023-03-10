package org.example.one_to_one.demo;

import org.example.one_to_one.entity.Course;
import org.example.one_to_one.entity.Instructor;
import org.example.one_to_one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Instructor dtworek = new Instructor("Bob", "Marley", "bob@gmail.com");
        InstructorDetail dtworekDetail = new InstructorDetail("www.youtube.com", "reggae");
        dtworek.setInstructorDetail(dtworekDetail);

        try(factory; session) {
            session.beginTransaction();
            session.save(dtworek);
            session.getTransaction().commit();
            System.out.println("Done!");
        }

    }
}
