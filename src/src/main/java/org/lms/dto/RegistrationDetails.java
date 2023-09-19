package org.lms.dto;

import org.lms.enums.RegistrationStatus;

public class RegistrationDetails {
    String registrationId;
    EmployeeDetails employee;
    Course course;
    RegistrationStatus registrationStatus;

    public RegistrationDetails(String registrationId, EmployeeDetails employee, Course course, RegistrationStatus registrationStatus) {
        this.registrationId = registrationId;
        this.employee = employee;
        this.course = course;
        this.registrationStatus = registrationStatus;
    }

    public void setRegistrationStatus(RegistrationStatus registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public EmployeeDetails getEmployee() {
        return employee;
    }

    public Course getCourse() {
        return course;
    }

    public RegistrationStatus getRegistrationStatus() {
        return registrationStatus;
    }
}
