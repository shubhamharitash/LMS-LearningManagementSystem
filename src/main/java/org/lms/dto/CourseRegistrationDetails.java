package org.lms.dto;

import org.lms.dto.Course;
import org.lms.dto.Employee;
import org.lms.enums.RegistrationStatus;

public class CourseRegistrationDetails {
    private final String courseRegistrationId;
    private final Employee employee;
    private final Course course;
    private RegistrationStatus status;

    public CourseRegistrationDetails(String courseRegistrationId, Employee employee, Course course) {
        this.courseRegistrationId = courseRegistrationId;
        this.employee = employee;
        this.course = course;
        this.status = RegistrationStatus.ACCEPTED;
    }

    public void setStatus(RegistrationStatus status) {
        this.status = status;
    }

    public String getCourseRegistrationId() {
        return courseRegistrationId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Course getCourse() {
        return course;
    }

    public RegistrationStatus getStatus() {
        return status;
    }
}
