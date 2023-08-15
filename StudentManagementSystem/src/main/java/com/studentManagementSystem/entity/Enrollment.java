package com.studentManagementSystem.entity;

import javax.persistence.*;

@Entity
@Table(name="Enrollment")

public class Enrollment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "Enrollment_Id")
	private int enrollId;
	
	@OneToOne
	
	private Student student_Id;
	
	@ManyToOne
	
	private Course courseId;
	
	@Column(name = "Enrollment_Date")
	private String enrollmentDate;
	
	@Column(name = "Status")
	private String status;

	public Enrollment(Student student_Id, Course courseId, String enrollmentDate, String status) {
		
		this.student_Id = student_Id;
		this.courseId = courseId;
		this.enrollmentDate = enrollmentDate;
		this.status = status;
	}
	

	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student getStudent_Id() {
		return student_Id;
	}

	public void setStudent_Id(Student student_Id) {
		this.student_Id = student_Id;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	public String getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(String enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEnrollId() {
		return enrollId;
	}
	
	
}
