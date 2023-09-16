package org.lms.service;

import org.lms.dto.Course;
import org.lms.dto.Employee;
import org.lms.enums.RegistrationStatus;

public class CourseRegistrationDetails {
    String courseRegistrationId;
    Employee employee;
    Course course;
    RegistrationStatus status;
}
