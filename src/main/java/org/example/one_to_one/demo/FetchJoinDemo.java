package org.example.one_to_one.demo;

import org.example.one_to_one.entity.Course;
import org.example.one_to_one.entity.Instructor;
import org.example.one_to_one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i " +
                                    "join fetch i.courses " +
                                    "where i.id=:theInstructorId",
                            Instructor.class);

            query.setParameter("theInstructorId", 1);

            Instructor tempInstructor = query.getSingleResult();

            session.getTransaction().commit();
            session.close();

            // courses are loaded by custem query code join fetch even if it's set to lazy loading
            System.out.println("Temp Instructor: " + tempInstructor);
            tempInstructor.getCourses().forEach(course -> System.out.println(course.getTitle()));


        }

    }

}
