package com.studentManagementSystem.DAOImpl;

import com.studentManagementSystem.dao.DAO.StudentDAO;

import java.util.List;

import org.hibernate.*;

import org.hibernate.Transaction;

import com.studentManagementSystem.entity.HibernateUtil;
import com.studentManagementSystem.entity.Student;


public class StudentDAOImpl implements StudentDAO {

    


    @Override
    public Student createStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Long studentId = (Long) session.save(student);
            transaction.commit();
            return getStudentById(studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student getStudentById(Long studentId) {
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            return session.get(Student.class, studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student updateStudent(Student student) {
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            Transaction transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteStudent(Long studentId) {
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.delete(student);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            
            
        }
    }
    
    @Override
    public List<Student> getAllStudents() {
        try (Session session =  HibernateUtil.getSessionFactory().openSession())  {
            return session.createQuery("FROM Student", Student.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    
    
    
}