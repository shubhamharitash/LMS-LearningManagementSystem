package org.lms.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Course {
    CourseDetails courseDetails;
    private Map<String, Employee> employeeMap;
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
    public void notifySuccessfulAllotment(){
        /*
            if registeredEmployees.size() > max_limit
                register till max_limit, for rest, give error
            if registeredEmployees.size() < min_limit
                removeCourse
         */
        registeredEmployees.subList(0, courseDetails.getMax_limit()-1).forEach(employee -> {
            employee.removeRegisteredCourseDetails(courseDetails);
            employee.addAllotedCourseDetails(courseDetails);
        });
        allotedEmployees.addAll(registeredEmployees.subList(0, courseDetails.getMax_limit()-1));
        registeredEmployees = registeredEmployees.subList(courseDetails.getMax_limit(), registeredEmployees.size());
    }

    public void notifyCourseRemoval(){
        registeredEmployees.forEach(employee -> employee.removeRegisteredCourseDetails(courseDetails));
        registeredEmployees = new ArrayList<>();
    }
}