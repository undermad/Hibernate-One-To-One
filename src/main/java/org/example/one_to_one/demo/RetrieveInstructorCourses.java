package org.example.one_to_one.demo;

import org.example.one_to_one.entity.Course;
import org.example.one_to_one.entity.Instructor;
import org.example.one_to_one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RetrieveInstructorCourses {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try (factory; session) {
            session.beginTransaction();

            Instructor tempInstructor = session.get(Instructor.class, 1);
            List<Course> tempCourses = tempInstructor.getCourses();

            tempCourses.forEach(course -> System.out.println(course.getTitle()));

            session.getTransaction().commit();
        }

    }
}
