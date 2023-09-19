package org.lms.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Course {
    CourseDetails courseDetails;
    private List<Employee> registeredEmployees;
    private List<Employee> allotedEmployees;

    public Course(String title, String instructor, String date, int min_limit, int max_limit) {
        this.courseDetails = new CourseDetails(title, instructor, date, min_limit, max_limit);
        this.registeredEmployees = new ArrayList<>();
        this.allotedEmployees = new ArrayList<>();
    }

    public List<Employee> getRegisteredEmployees() {
        return registeredEmployees;
    }

    public List<Employee> getAllotedEmployees() {
        return allotedEmployees;
    }

    public CourseDetails getCourseDetails() {
        return courseDetails;
    }

    public void registerEmployee(Employee employee){
        if(registeredEmployees.contains(employee))
            throw new RuntimeException("INPUT_DATA_ERROR");
        registeredEmployees.add(employee);
        employee.addRegisteredCourseDetails(courseDetails);
    }

    public void removeFromCourse(Employee employee){
        employee.removeRegisteredCourseDetails(courseDetails);
        registeredEmployees.remove(employee);
    }
    public List<Employee> notifySuccessfulAllotment(){
        registeredEmployees.forEach(employee -> {
            employee.removeRegisteredCourseDetails(courseDetails);
            employee.addAllotedCourseDetails(courseDetails);
        });
        allotedEmployees.addAll(registeredEmployees);
        List<Employee> successfulAllotments = new ArrayList<>(registeredEmployees);
        registeredEmployees = new ArrayList<>();
        return successfulAllotments;
    }

    public void notifyCourseRemoval(){
        registeredEmployees.forEach(employee -> employee.removeRegisteredCourseDetails(courseDetails));
        registeredEmployees = new ArrayList<>();
    }
}