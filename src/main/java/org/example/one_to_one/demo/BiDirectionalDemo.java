package org.example.one_to_one.demo;

import org.example.one_to_one.entity.Instructor;
import org.example.one_to_one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectionalDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try (factory; session) {
            session.beginTransaction();

            int id = 3;
            InstructorDetail tempDetail = session.get(InstructorDetail.class, id);
            System.out.println(tempDetail.getInstructor().toString());

            tempDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempDetail);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }

    }



}
