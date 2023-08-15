package com.studentManagementSystem;

import java.util.Date;
import com.studentManagementSystem.dao.DAO.*;
import com.studentManagementSystem.DAOImpl.*;
import com.studentManagementSystem.entity.*;




import java.util.List;

public class App {
    public static void main(String[] args) {
       

       // Create DAO instances
        StudentDAO studentDAO = new StudentDAOImpl();
        CourseDAO courseDAO = new CourseDAOImpl();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAOImpl();
        AttendanceDAO attendanceDAO = new AttendanceDAOImpl();

        // Perform operations on entities
        Student newStudent = new Student("partha", "sarathi", new Date(), "123 Main St");
        studentDAO.createStudent(newStudent);

        Course newCourse = new Course("CS101", "Introduction to Computer Science", 3);
        courseDAO.addCourse(newCourse);

        Enrollment newEnrollment = new Enrollment(newStudent, newCourse,"20/12/2020","enrolled");
        enrollmentDAO.addEnrollment(newEnrollment);

        Attendance newAttendance = new Attendance(newEnrollment, new Date(), true);
        attendanceDAO.addAttendance(newAttendance);

        // Retrieve and print entities
        List<Student> allStudents = studentDAO.getAllStudents();
        System.out.println("All Students:");
        for (Student student : allStudents) {
            System.out.println(student);
        }

        List<Course> allCourses = courseDAO.getAllCourses();
        System.out.println("All Courses:");
        for (Course course : allCourses) {
            System.out.println(course);
        }

        List<Enrollment> allEnrollments = enrollmentDAO.getAllEnrollments();
        System.out.println("All Enrollments:");
        for (Enrollment enrollment : allEnrollments) {
            System.out.println(enrollment);
        }

        List<Attendance> allAttendances = attendanceDAO.getAllAttendances();
        System.out.println("All Attendances:");
        for (Attendance attendance : allAttendances) {
            System.out.println(attendance);
        }

        
    }
}
