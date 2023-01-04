package org.example.one_to_one.demo;

import org.example.one_to_one.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try (factory; session) {
            session.beginTransaction();

            Student tempStudent = session.get(Student.class, 6);
            tempStudent.getCourses().forEach(course -> System.out.println(course.getTitle()));

            session.getTransaction().commit();
            System.out.println("Done!");
        }

    }
}
