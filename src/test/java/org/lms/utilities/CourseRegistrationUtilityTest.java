package org.lms.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lms.dto.Course;
import org.lms.dto.CourseRegistrationDetails;
import org.lms.dto.Employee;

import java.util.ArrayList;
import java.util.List;

class CourseRegistrationUtilityTest {

    CourseRegistrationUtility courseRegistrationUtility=new CourseRegistrationUtility();
    @Test
    void getCourseName() {
        String output=CourseRegistrationUtility.getCourseName("-Java");
        Assertions.assertEquals("Java",output);
    }

    @Test
    void getEmployeeName() {
        String output=CourseRegistrationUtility.getEmployeeName("Shubham@gmail.com");
        Assertions.assertEquals("Shubham",output);
    }

    @Test
    void getCourseRegistrationId() {
        String output=CourseRegistrationUtility.getCourseRegistrationId("Shubham","Java");
        Assertions.assertEquals("REG-COURSE-Shubham-Java",output);
    }

    @Test
    void stringAppeder() {
        Employee employee=new Employee("Shubham@gmail.com");
        Course course=new Course("Java","John","17092023",1,3);
        String courseOfferingId=CourseRegistrationUtility.getCourseOfferingId(course.getCourseDetails());
        CourseRegistrationDetails courseRegistrationDetails=new CourseRegistrationDetails("REG-COURSE-Shubham-Java",employee, course);
        StringBuilder output=CourseRegistrationUtility.stringAppeder(courseRegistrationDetails,new StringBuilder());
  StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(String.format("%s %s %s %s %s %s %s",
                        courseRegistrationDetails.getCourseRegistrationId(),
                        courseRegistrationDetails.getEmployee().getEmployeeDetails().getEmail(),
                        courseOfferingId,
                        courseRegistrationDetails.getCourse().getCourseDetails().getTitle(),
                        courseRegistrationDetails.getCourse().getCourseDetails().getInstructor(),
                        courseRegistrationDetails.getCourse().getCourseDetails().getDate(),
                        courseRegistrationDetails.getStatus()
                )
        );
        Assertions.assertEquals(stringBuilder.toString(),output.toString());
    }

    @Test
    void getCourseOfferingId() {
        Course course=new Course("Java","John","17092023",1,3);
        String courseOfferingId=CourseRegistrationUtility.getCourseOfferingId(course.getCourseDetails());
        String expectedresult="OFFERING-"+course.getCourseDetails().getTitle()+"-"+course.getCourseDetails().getInstructor();
        Assertions.assertEquals(expectedresult,courseOfferingId);
    }

    @Test
    void allotmentOutput() {
        Employee employee=new Employee("Shubham@gmail.com");
        Course course=new Course("Java","John","17092023",1,3);
        String courseOfferingId=CourseRegistrationUtility.getCourseOfferingId(course.getCourseDetails());
        CourseRegistrationDetails courseRegistrationDetails=new CourseRegistrationDetails("REG-COURSE-Shubham-Java",employee, course);
        List<CourseRegistrationDetails> courseRegistrationDetailsList=new ArrayList<>();
        courseRegistrationDetailsList.add(courseRegistrationDetails);
        StringBuilder expectedOutput=CourseRegistrationUtility.stringAppeder(courseRegistrationDetails,new StringBuilder());
        String output=CourseRegistrationUtility.allotmentOutput(courseRegistrationDetailsList);
        Assertions.assertEquals(expectedOutput.toString(),output);
    }
}