package org.lms.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    private final EmployeeDetails employeeDetails;
    private final List<CourseDetails> registeredCourseDetails;
    private final List<CourseDetails> allotedCourseDetails;

    public Employee(String emailId) {
        this.employeeDetails = new EmployeeDetails(emailId);
        this.registeredCourseDetails = new ArrayList<>();
        this.allotedCourseDetails = new ArrayList<>();
    }

    public EmployeeDetails getEmployeeDetails() {
        return employeeDetails;
    }

    public void addRegisteredCourseDetails(CourseDetails courseDetails){
        registeredCourseDetails.add(courseDetails);
    }

    public void removeRegisteredCourseDetails(CourseDetails courseDetails){
        registeredCourseDetails.remove(courseDetails);
    }
    public void addAllotedCourseDetails(CourseDetails courseDetails){
        allotedCourseDetails.add(courseDetails);
    }

    @Override
    public boolean equals(Object employee) {
        if (!(employee instanceof Employee))
            throw new RuntimeException("INPUT_DATA_ERROR");
        return employeeDetails.getEmail().equals(((Employee)employee).employeeDetails.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeDetails.getEmail());
    }
}
