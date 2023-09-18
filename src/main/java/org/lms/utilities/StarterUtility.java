package org.lms.utilities;

import org.lms.service.CourseRegistration;

public class StarterUtility {
    private static CourseRegistration courseRegistration = new CourseRegistration();

    public  static boolean validateArgs(int input, int expected) {
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
}
