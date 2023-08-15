package com.studentManagementSystem.dao;

import java.util.List;

import com.studentManagementSystem.entity.Attendance;
import com.studentManagementSystem.entity.Course;
import com.studentManagementSystem.entity.Enrollment;
import com.studentManagementSystem.entity.Student;

public class DAO {
	
	public interface StudentDAO {

	    Student createStudent(Student student);

	    Student getStudentById(Long studentId);

	    Student updateStudent(Student student);

	    void deleteStudent(Long studentId);

		List<Student> getAllStudents();

		
	}
	
	public interface AttendanceDAO {
	    void addAttendance(Attendance attendance);
	    void updateAttendance(Attendance attendance);
	    void deleteAttendance(long attendanceId);
	    Attendance getAttendanceById(long attendanceId);
	    List<Attendance> getAllAttendances();
	}

	
	public interface CourseDAO {
		void addCourse(Course course);
	    void updateCourse(Course course);
	    void deleteCourse(long courseId);
	    Course getCourseById(long courseId);
	    List<Course> getAllCourses();
	}
	
	public interface EnrollmentDAO {
	    void addEnrollment(Enrollment enrollment);
	    void updateEnrollment(Enrollment enrollment);
	    void deleteEnrollment(long enrollmentId);
	    Enrollment getEnrollmentById(long enrollmentId);
	    List<Enrollment> getAllEnrollments();
	}


}
