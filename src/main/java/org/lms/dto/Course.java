package org.lms.dto;

import org.lms.enums.RegistrationStatus;

import java.util.ArrayList;
import java.util.List;

public class Course {
    CourseDetails courseDetails;
    private List<Employee> registeredEmployees;

    public Course(String title, String instructor, String date, int min_limit, int max_limit) {
        this.courseDetails = new CourseDetails(title, instructor, date, min_limit, max_limit);
        this.registeredEmployees = new ArrayList<>();
    }

    public List<Employee> getRegisteredEmployees() {
        return registeredEmployees;
    }

    public CourseDetails getCourseDetails() {
        return courseDetails;
    }

    public void registerEmployee(Employee employee){
        employee.addRegisteredCourseDetails(courseDetails);
        employee.setRegistrationStatus(RegistrationStatus.ACCEPTED);
        registeredEmployees.add(employee);
    }

    public void removeFromCourse(Employee employee){
        employee.removeRegisteredCourseDetails(courseDetails);
        employee.setRegistrationStatus(RegistrationStatus.CANCELLED);
        registeredEmployees.remove(employee);
    }
    public void notifySuccessfulAllotment(){
        /*
            if registeredEmployees.size() < min_limit
                removeCourse
         */
        registeredEmployees.forEach(employee -> {employee.setRegistrationStatus(RegistrationStatus.COMPLETED);});

    }

    public void notifyCourseRemoval(){
        registeredEmployees.forEach(employee -> {employee.removeRegisteredCourseDetails(courseDetails);
       // employee.setRegistrationStatus(RegistrationStatus.CANCELLED);
        });

    }
}