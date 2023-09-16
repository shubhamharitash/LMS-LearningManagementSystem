package org.lms.dto;

public class EmployeeDetails {
    private final String email;
    private final String name;

    public EmployeeDetails(String email) {
        this.email = email;
        this.name = email.split("@")[0];
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
