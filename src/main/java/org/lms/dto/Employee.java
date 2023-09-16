package org.lms.dto;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private final EmployeeDetails employeeDetails;
    private final List<CourseDetails> registeredCourseDetails;
    private final List<CourseDetails> allotedCourseDetails;

    public Employee(String emailId) {
        this.employeeDetails = new EmployeeDetails(emailId);
        this.registeredCourseDetails = new ArrayList<>();
        this.allotedCourseDetails = new ArrayList<>();
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
}
