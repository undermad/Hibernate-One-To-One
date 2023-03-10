package org.example.one_to_one.demo;

import org.example.one_to_one.entity.Course;
import org.example.one_to_one.entity.Instructor;
import org.example.one_to_one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try (factory; session) {

            session.beginTransaction();

//            Instructor tempInstructor = session.get(Instructor.class, 2)
//                    .add(session.get(Course.class, 11))
//                    .add(session.get(Course.class, 12));
//
//            session.update(tempInstructor);
            Instructor tempInstructor = session.get(Instructor.class, 2);
            tempInstructor.getCourses().forEach(course -> System.out.println(course.getTitle()));

            session.getTransaction().commit();
            System.out.println("Done successfully!");
        }
    }

}
