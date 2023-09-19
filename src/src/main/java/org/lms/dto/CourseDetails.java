package org.lms.dto;

public class CourseDetails {
    private final String title;
    private final String instructor;
    private final String date;
    private final int min_limit;
    private final int max_limit;

    public CourseDetails(String title, String instructor, String date, int min_limit, int max_limit) {
        this.title = title;
        this.instructor = instructor;
        this.date = date;
        this.min_limit = min_limit;
        this.max_limit = max_limit;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDate() {
        return date;
    }

    public int getMin_limit() {
        return min_limit;
    }

    public int getMax_limit() {
        return max_limit;
    }
}
