package org.example.one_to_one.demo;

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
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Instructor dtworek = new Instructor("Dominik", "Tworek", "dtworek94@gmail.com");
        InstructorDetail dtworekDetail = new InstructorDetail("www.youtube.com", "Computer Games");
        dtworek.setInstructorDetail(dtworekDetail);

        try {
            session.beginTransaction();
            session.save(dtworek);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }
}
