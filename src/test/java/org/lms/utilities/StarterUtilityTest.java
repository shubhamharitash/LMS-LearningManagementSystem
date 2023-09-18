package org.lms.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lms.service.Starter;

import static org.junit.jupiter.api.Assertions.*;

class StarterUtilityTest {

    @Test
    void addCourseOfferings() {
        StarterUtility.addCourseOfferings(new String[]{"f","Java","b","c","1","3"});
    }

    @Test
    void register() {
        //courseName=a, instructor, date, minEmployee, maxEmployee
        addCourseOfferings();
        StarterUtility.register(new String[]{"f","Shubham@gmail.com","-Java"});
    }

    @Test
    void allot() {
        register();
        StarterUtility.allot(new String[]{"f","-Java"});
    }

    @Test
    void cancel() {
        register();
        StarterUtility.cancel(new String[]{"f","REG-COURSE-Shubham-Java"});
    }

    @Test
    void validateArgs() {
       boolean output =StarterUtility.validateArgs(1,1);
        Assertions.assertEquals(true,output);
    }
}