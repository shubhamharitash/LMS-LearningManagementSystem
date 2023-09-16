package org.lms;

import org.lms.service.CourseRegistration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {
    private static CourseRegistration courseRegistration = new CourseRegistration();

    public static boolean checkIfValidDate(String input) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("ddMMyyyy");
        Date inputDate = f.parse(input);
        Date currentDate = new Date();
        return inputDate.compareTo(currentDate) >= 0;
    }

    public static boolean validateArgs(int input, int expected) {
        return input == expected;
    }

    public static void addCourseOfferings(String[] inputArgs) {
        if (!validateArgs(inputArgs.length, 6)) {
            throw new RuntimeException("INPUT_DATA_ERROR");
        }
        System.out.println(courseRegistration.addCourse(inputArgs[1], inputArgs[2], inputArgs[3], Integer.parseInt(inputArgs[4]), Integer.parseInt(inputArgs[5])));
    }

    public static void register(String[] inputArgs) {
        if (!validateArgs(inputArgs.length, 3)) {
            throw new RuntimeException("INPUT_DATA_ERROR");
        }
        System.out.println(courseRegistration.registerForCourse(inputArgs[1], inputArgs[2]));
    }

    public static void allot(String[] inputArgs) {
        if (!validateArgs(inputArgs.length, 2)) {
            throw new RuntimeException("INPUT_DATA_ERROR");
        }
        System.out.println(courseRegistration.courseAllotment(inputArgs[1]));
    }

    public static void cancel(String[] inputArgs) {
        if (!validateArgs(inputArgs.length, 2)) {
            throw new RuntimeException("INPUT_DATA_ERROR");
        }
        System.out.println(courseRegistration.cancelRegistration(inputArgs[1]));
    }

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String input = sc.nextLine();
                String[] inputArgs = input.split(" ");
                switch (inputArgs[0]) {
                    case "ADD-COURSE-OFFERING":
                        addCourseOfferings(inputArgs);
                        break;
                    case "REGISTER":
                        register(inputArgs);
                        break;
                    case "ALLOT":
                        allot(inputArgs);
                        break;
                    case "CANCEL":
                        cancel(inputArgs);
                        break;
                    case "DEFAULT":
                        throw new RuntimeException("INPUT_DATA_ERROR");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}