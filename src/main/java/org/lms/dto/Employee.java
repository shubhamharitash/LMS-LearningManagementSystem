package org.lms.dto;

import enums.RegistrationStatus;

public class Employee {


    int registrationNumber;
    String email;
    String name;
    RegistrationStatus registrationStatus;
    String courseRegistered;

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCourseRegistered() {
        return courseRegistered;
    }

    public void setCourseRegistered(String courseRegistered) {
        this.courseRegistered = courseRegistered;
    }
    public RegistrationStatus getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(RegistrationStatus registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
