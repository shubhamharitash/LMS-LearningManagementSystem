package org.lms.service;

import org.lms.dto.Course;
import org.lms.dto.Employee;
import org.lms.dto.EmployeeDetails;
import org.lms.dto.RegistrationDetails;
import org.lms.enums.RegistrationStatus;
import org.lms.utilities.CourseRegistrationUtility;

import java.util.Map;

public class CourseRegistration {
    Map<String, Course> courseMap;
    Map<String, Employee> employeeMap;
    Map<String, CourseRegistrationDetails> registrationDetailsMap;

    public void addCourse(String courseName, String instructor, String date, int minEmployee, int maxEmployee){
        courseMap.put(courseName, new Course(courseName, instructor, date, minEmployee, maxEmployee));
    }
    public void registerForCourse(String emailId, String courseOfferingId){
        if(!courseMap.containsKey(CourseRegistrationUtility.getCourseName(courseOfferingId))){
            throw new RuntimeException("INPUT_DATA_ERROR");
        }
        Course course = courseMap.get(CourseRegistrationUtility.getCourseName(courseOfferingId));
        // Find if any employee with same email id exists;
        Employee employee;
        if(employeeMap.containsKey(emailId)){
            employee = employeeMap.get(emailId);
        } else {
            employee = new Employee(emailId);
        }
        if(course.getRegisteredEmployees().size() + course.getAllotedEmployees().size() == course.getCourseDetails().getMax_limit()){
            throw new RuntimeException("COURSE_FULL_ERROR");
        }
        course.registerEmployee(employee);
        registrationDetailsMap.put(CourseRegistrationUtility.getCourseRegistrationId())
    }
    public void courseAllotment(String courseOfferingId){

    }
    public void cancelRegistration(String courseRegistrationId){
        String[] details = CourseRegistrationUtility.getEmployeeNameAndCourseName(courseRegistrationId);
        if(!courseMap.containsKey(details[1]) || !employeeMap.containsKey(details[0])){
            throw new RuntimeException("INPUT_DATA_ERROR");
        }
    }

    // courseRegistrationId employee course status
}
