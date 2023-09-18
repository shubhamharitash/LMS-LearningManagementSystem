package org.lms.service;

import org.lms.utilities.StarterUtility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Starter {

public static void startMethod(Scanner sc){
    try {
        String input = sc.nextLine();
        String[] inputArgs = input.split(" ");
        switch (inputArgs[0]) {
            case "ADD-COURSE-OFFERING":
                StarterUtility.addCourseOfferings(inputArgs);
                break;
            case "REGISTER":
                StarterUtility.register(inputArgs);
                break;
            case "ALLOT":
                StarterUtility.allot(inputArgs);
                break;
            case "CANCEL":
                StarterUtility.cancel(inputArgs);
                break;
            case "DEFAULT":
                throw new RuntimeException("INPUT_DATA_ERROR");
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
}
