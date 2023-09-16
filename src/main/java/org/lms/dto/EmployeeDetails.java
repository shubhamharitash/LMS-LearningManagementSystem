package org.lms.dto;

import org.lms.utilities.CourseRegistrationUtility;

public class EmployeeDetails {
    private final String email;
    private final String name;

    public EmployeeDetails(String email) {
        this.email = email;
        this.name = CourseRegistrationUtility.getEmployeeName(email);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
