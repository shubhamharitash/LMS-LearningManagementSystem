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

    public void addCourse(String courseName, String instructor, String date, int minEmployee, int maxEmployee){
        courseMap.put(courseName, new Course(courseName, instructor, date, minEmployee, maxEmployee));
    }
    public void registerForCourse(String emailId, String courseOfferingId){
        if(!courseMap.containsKey(CourseRegistrationUtility.getCourseName(courseOfferingId))){
            throw new RuntimeException("INPUT_DATA_ERROR");
        }
        Course course = courseMap.get(CourseRegistrationUtility.getCourseName(courseOfferingId));
        Employee employee = new Employee(emailId);
        if(course.getRegisteredEmployees().size()  == course.getCourseDetails().getMax_limit()){
            throw new RuntimeException("COURSE_FULL_ERROR");
        }
        course.registerEmployee(employee);
        employeeMap.put(employee.getEmployeeDetails().getName(),employee);
    }
    public void courseAllotment(String courseOfferingId){
        String courseName=CourseRegistrationUtility.getCourseName(courseOfferingId);

        if (!courseMap.containsKey(courseName)){
            throw new RuntimeException("INPUT_DATA_ERROR");
        }
        Course course=courseMap.get(courseName);
        if (course.getRegisteredEmployees().size()<course.getCourseDetails().getMin_limit()){
            courseMap.remove(courseName);
        }

        course.notifySuccessfulAllotment();
        course.getRegisteredEmployees().forEach(employee -> {
            employeeMap.get(employee.getEmployeeDetails().getName()).setRegistrationStatus(RegistrationStatus.COMPLETED);
        });
         }
    public void cancelRegistration(String courseRegistrationId){
        String[] details = CourseRegistrationUtility.getEmployeeNameAndCourseName(courseRegistrationId);
        if(!courseMap.containsKey(details[1]) || !employeeMap.containsKey(details[0])){
            throw new RuntimeException("INPUT_DATA_ERROR");
        }
        Course course=courseMap.get(details[1]);
        Employee employee=employeeMap.get(details[0]);
        if (employee.getRegistrationStatus().equals(RegistrationStatus.COMPLETED)){
            throw  new RuntimeException("CANCEL_REJECTED");
        }
        course.removeFromCourse(employee);
        employeeMap.remove(employee);

    }

    // courseRegistrationId employee course status
}
