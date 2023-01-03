package org.example.one_to_one.demo;

import org.example.one_to_one.entity.Course;
import org.example.one_to_one.entity.Instructor;
import org.example.one_to_one.entity.InstructorDetail;
import org.example.one_to_one.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseReview {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try (factory; session) {

            session.beginTransaction();

//            Course tempCourse = new Course("Temporary Course");
//            tempCourse.addReview(new Review("This course is amazing."));
//            tempCourse.addReview(new Review("Just finished this course, i'm surprised"));
//            tempCourse.addReview(new Review("Test test"));
//
//            session.save(tempCourse);

            Review review = session.get(Review.class, 1);
            session.delete(review);
            session.getTransaction().commit();
            System.out.println("Done!");

        }


    }
}
