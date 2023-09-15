import src.Dto.Course;

import java.util.List;

public class Offer_Course {
    List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(Course course) {
        courses.add(course);
    }

}
