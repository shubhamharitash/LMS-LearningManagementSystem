package org.lms.service;

import org.lms.dto.Course;
import org.lms.dto.CourseRegistrationDetails;
import org.lms.dto.Employee;
import org.lms.enums.RegistrationStatus;
import org.lms.utilities.CourseRegistrationUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseRegistration {
    Map<String, Course> courseMap = new HashMap<>(); // key: courseName
    Map<String, Employee> employeeMap = new HashMap<>(); // key: emailId
    Map<String, CourseRegistrationDetails> registrationDetailsMap = new HashMap<>();

    public String addCourse(String courseName, String instructor, String date, int minEmployee, int maxEmployee){
        Course course = new Course(courseName, instructor, date, minEmployee, maxEmployee);
        courseMap.put(courseName, course);
        return CourseRegistrationUtility.getCourseOfferingId(course.getCourseDetails());
    }

    public String registerForCourse(String emailId, String courseOfferingId){
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
        // Date Logic
        if(!CourseRegistrationUtility.checkIfValidDate(course.getCourseDetails().getDate()) && course.getRegisteredEmployees().size() < course.getCourseDetails().getMin_limit()){
            course.notifyCourseRemoval();
            courseMap.remove(CourseRegistrationUtility.getCourseName(courseOfferingId));
            throw new RuntimeException("COURSE_CANCELED");
        }
        // Register Logic
        course.registerEmployee(employee);
        employeeMap.put(emailId, employee);
        String courseRegistrationId = CourseRegistrationUtility.getCourseRegistrationId(CourseRegistrationUtility.getEmployeeName(emailId), CourseRegistrationUtility.getCourseName(courseOfferingId));
        registrationDetailsMap.put(courseRegistrationId, new CourseRegistrationDetails(courseRegistrationId, employee, course));
        return String.format("%s %s", courseRegistrationId, RegistrationStatus.ACCEPTED);
    }
    public String courseAllotment(String courseOfferingId){
        if(!courseMap.containsKey(CourseRegistrationUtility.getCourseName(courseOfferingId))){
            throw new RuntimeException("INPUT_DATA_ERROR");
        }
        Course course = courseMap.get(CourseRegistrationUtility.getCourseName(courseOfferingId));
        List<CourseRegistrationDetails> result = new ArrayList<>();
        if(course.getRegisteredEmployees().size() < course.getCourseDetails().getMin_limit()){
            course.getRegisteredEmployees().forEach(employee -> {
                String courseRegistrationId = CourseRegistrationUtility.getCourseRegistrationId(employee.getEmployeeDetails().getName(), CourseRegistrationUtility.getCourseName(courseOfferingId));
                CourseRegistrationDetails courseRegistrationDetails = registrationDetailsMap.get(courseRegistrationId);
                result.add(courseRegistrationDetails);
            });
            course.notifyCourseRemoval();
            courseMap.remove(CourseRegistrationUtility.getCourseName(courseOfferingId));
        } else {
            List<Employee> recentAllotments = course.notifySuccessfulAllotment();
            recentAllotments.forEach(employee -> {
                String courseRegistrationId = CourseRegistrationUtility.getCourseRegistrationId(employee.getEmployeeDetails().getName(), CourseRegistrationUtility.getCourseName(courseOfferingId));
                CourseRegistrationDetails courseRegistrationDetails = registrationDetailsMap.get(courseRegistrationId);
                courseRegistrationDetails.setStatus(RegistrationStatus.COMPLETED);
                result.add(courseRegistrationDetails);
            });
        }
        return CourseRegistrationUtility.allotmentOutput(result);
    }
    public String cancelRegistration(String courseRegistrationId){
        if(!registrationDetailsMap.containsKey(courseRegistrationId)){
            throw new RuntimeException("INPUT_DATA_ERROR");
        }
        CourseRegistrationDetails courseRegistrationDetails = registrationDetailsMap.get(courseRegistrationId);
        if(courseRegistrationDetails.getStatus().equals(RegistrationStatus.COMPLETED)){
            throw new RuntimeException("CANCEL_REJECTED");
        }
        courseRegistrationDetails.setStatus(RegistrationStatus.CANCELLED);
        courseRegistrationDetails.getCourse().removeFromCourse(courseRegistrationDetails.getEmployee());
        return String.format("%s %s", courseRegistrationId, RegistrationStatus.CANCELLED);
    }
}
