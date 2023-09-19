package org.lms.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseRegistrationTest {

    CourseRegistration courseRegistration=new CourseRegistration();

    @Test
    void addCourse() {
        //ADD-COURSE-OFFERING PYTHON JOHN 05062022 1 3
        String output=courseRegistration.addCourse("PYTHON","JOHN","05062022",1,3);
        boolean result= output.equals("OFFERING-PYTHON-JOHN");
    }

    @Test
    void registerForCourse() {
       // String output=courseRegistration.registerForCourse("WOO@GMAIL.COM","OFFERING-PYTHON-JOHN");
     //   boolean result= output.equals("REG-COURSE-WOO-PYTHON ACCEPTED");
    }

    @Test
    void courseAllotment() {
        //String output=courseRegistration.courseAllotment("OFFERING-PYTHON-JOHN");
        //boolean result= output.equals("REG-COURSE-ANDY-PYTHON ANDY@GMAIL.COM OFFERING-PYTHON-JOHN PYTHON JOHN 05062022 CONFIRMED");
    }

    @Test
    void cancelRegistration() {
        //String output=courseRegistration.cancelRegistration("REG-COURSE-BOBY-PYTHON");
        //boolean result= output.equals("REG-COURSE-BOBY-PYTHON CANCEL_ACCEPTED");
    }
}