package com.studentManagementSystem.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "attendances")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    @Column(name = "attendance_date")
    private Date date;

    @Column(name = "present")
    private boolean present;

    public Attendance() {
        // Default constructor
    }

    public Attendance(Enrollment enrollment, Date date, boolean present) {
        this.enrollment = enrollment;
        this.date = date;
        this.present = present;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", enrollment=" + enrollment +
                ", date=" + date +
                ", present=" + present +
                '}';
    }
}
