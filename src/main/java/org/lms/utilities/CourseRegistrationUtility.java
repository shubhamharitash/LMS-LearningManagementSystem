package org.lms.utilities;

public class CourseRegistrationUtility {
    public static String getCourseName(String courseOfferingId){
        return courseOfferingId.split("-")[1];
    }

    public static String getEmployeeName(String emailId){
        return emailId.split("@")[0];
    }

    public static String getCourseRegistrationId(String employeeName, String courseName){
        return String.format("REG-COURSE-%s-%s", employeeName, courseName);
    }

    public static String[] getEmployeeNameAndCourseName(String courseRegistrationId){
        return (courseRegistrationId.replace("REG-COURSE-","")).split("-");
    }
}
