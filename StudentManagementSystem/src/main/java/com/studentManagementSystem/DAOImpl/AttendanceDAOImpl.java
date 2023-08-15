package com.studentManagementSystem.DAOImpl;
import com.studentManagementSystem.dao.DAO.AttendanceDAO;
import org.hibernate.Session;

import org.hibernate.Transaction;


import com.studentManagementSystem.entity.Attendance;
import com.studentManagementSystem.entity.HibernateUtil;

import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO {
   

    @Override
    public void addAttendance(Attendance attendance) {
        Transaction transaction = null;
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            transaction = session.beginTransaction();
            session.save(attendance);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        Transaction transaction = null;
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            transaction = session.beginTransaction();
            session.update(attendance);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAttendance(long attendanceId) {
        Transaction transaction = null;
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            transaction = session.beginTransaction();
            Attendance attendance = session.get(Attendance.class, attendanceId);
            if (attendance != null) {
                session.delete(attendance);
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
    public Attendance getAttendanceById(long attendanceId) {
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            return session.get(Attendance.class, attendanceId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Attendance> getAllAttendances() {
        try (Session session =  HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Attendance", Attendance.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
