package org.lms.utilities;

import org.lms.dto.CourseDetails;
import org.lms.dto.CourseRegistrationDetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class CourseRegistrationUtility {
    public static String getCourseName(String courseOfferingId) {
        return courseOfferingId.split("-")[1];
    }
    public static String getEmployeeName(String emailId) {
        return emailId.split("@")[0];
    }

    public static String getCourseRegistrationId(String employeeName, String courseName) {
        return String.format("REG-COURSE-%s-%s", employeeName, courseName);
    }
    public static StringBuilder stringAppeder(CourseRegistrationDetails courseRegistrationDetails,StringBuilder result){
        result.append(String.format("%s %s %s %s %s %s %s",
                        courseRegistrationDetails.getCourseRegistrationId(),
                        courseRegistrationDetails.getEmployee().getEmployeeDetails().getEmail(),
                        getCourseOfferingId(courseRegistrationDetails.getCourse().getCourseDetails()),
                        courseRegistrationDetails.getCourse().getCourseDetails().getTitle(),
                        courseRegistrationDetails.getCourse().getCourseDetails().getInstructor(),
                        courseRegistrationDetails.getCourse().getCourseDetails().getDate(),
                        courseRegistrationDetails.getStatus()
                )
        );
    return result;
    }

    public static String getCourseOfferingId(CourseDetails courseDetails) {
        return String.format("OFFERING-%s-%s", courseDetails.getTitle(), courseDetails.getInstructor());
    }

    public static String allotmentOutput(List<CourseRegistrationDetails> courseRegistrationDetailsList) {
        StringBuilder result = new StringBuilder();
        Collections.sort(courseRegistrationDetailsList, Comparator.comparing(CourseRegistrationDetails::getCourseRegistrationId));
        for (int i = 0; i < courseRegistrationDetailsList.size(); i++) {
            CourseRegistrationDetails courseRegistrationDetails = courseRegistrationDetailsList.get(i);
            if (i != (courseRegistrationDetailsList.size() - 1)) {
           result=CourseRegistrationUtility.stringAppeder(courseRegistrationDetails,result);
           result.append("\n");
            } else {
                result=CourseRegistrationUtility.stringAppeder(courseRegistrationDetails,result);
            }
        }
        return result.toString();
    }
}
