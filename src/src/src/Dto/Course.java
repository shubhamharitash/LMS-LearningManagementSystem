package src.Dto;

public class Course {
    String title;
    String instructor;
    long date;

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", instructor='" + instructor + '\'' +
                ", date=" + date +
                ", min_limit=" + min_limit +
                ", max_limit=" + max_limit +
                '}';
    }

    int min_limit;

    public Course(String title, String instructor, long date, int min_limit, int max_limit) {
        this.title = title;
        this.instructor = instructor;
        this.date = date;
        this.min_limit = min_limit;
        this.max_limit = max_limit;
    }

    int max_limit;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getMin_limit() {
        return min_limit;
    }

    public void setMin_limit(int min_limit) {
        this.min_limit = min_limit;
    }

    public int getMax_limit() {
        return max_limit;
    }

    public void setMax_limit(int max_limit) {
        this.max_limit = max_limit;
    }

}
