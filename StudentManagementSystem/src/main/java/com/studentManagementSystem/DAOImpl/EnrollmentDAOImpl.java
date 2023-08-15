package com.studentManagementSystem.DAOImpl;
import com.studentManagementSystem.dao.DAO.EnrollmentDAO;
import org.hibernate.Session;

import org.hibernate.Transaction;


import com.studentManagementSystem.entity.Enrollment;
import com.studentManagementSystem.entity.HibernateUtil;

import java.util.List;

public class EnrollmentDAOImpl implements EnrollmentDAO {
    
    @Override
    public void addEnrollment(Enrollment enrollment) {
        Transaction transaction = null;
        try (Session session =  HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(enrollment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void updateEnrollment(Enrollment enrollment) {
        Transaction transaction = null;
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            transaction = session.beginTransaction();
            session.update(enrollment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEnrollment(long enrollmentId) {
        Transaction transaction = null;
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            transaction = session.beginTransaction();
            Enrollment enrollment = session.get(Enrollment.class, enrollmentId);
            if (enrollment != null) {
                session.delete(enrollment);
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
    public Enrollment getEnrollmentById(long enrollmentId) {
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            return session.get(Enrollment.class, enrollmentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Enrollment", Enrollment.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
