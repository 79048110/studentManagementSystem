package com.studentManagementSystem.DAOImpl;
import com.studentManagementSystem.dao.DAO.CourseDAO;
import org.hibernate.Session;

import org.hibernate.Transaction;

import com.studentManagementSystem.entity.Course;
import com.studentManagementSystem.entity.HibernateUtil;

import java.util.List;

public  class CourseDAOImpl implements CourseDAO {


    @Override
    public void addCourse(Course course) {
        Transaction transaction = null;
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void updateCourse(Course course) {
        Transaction transaction = null;
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            transaction = session.beginTransaction();
            session.update(course);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(long courseId) {
        Transaction transaction = null;
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            if (course != null) {
                session.delete(course);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Course getCourseById(long courseId) {
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            return session.get(Course.class, courseId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Course> getAllCourses() {
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            return session.createQuery("FROM Course", Course.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
