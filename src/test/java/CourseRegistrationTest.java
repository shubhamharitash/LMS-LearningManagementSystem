import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lms.dto.Course;
import org.lms.dto.CourseRegistrationDetails;
import org.lms.dto.Employee;
import org.lms.service.CourseRegistration;

import java.util.HashMap;
import java.util.Map;

public class CourseRegistrationTest {
    CourseRegistration courseRegistration = new CourseRegistration();

    @Test
    void addCourse() {
        //ADD-COURSE-OFFERING PYTHON JOHN 05062022 1 3
        String output = courseRegistration.addCourse("PYTHON", "JOHN", "05062022", 1, 3);
        Assertions.assertEquals("OFFERING-PYTHON-JOHN", output);
    }

    @Test
    void registerForCourse() {
        courseRegistration = getCourseRegistrationForRegisterForCourse();
        String output = courseRegistration.registerForCourse("WOO@GMAIL.COM", "OFFERING-PYTHON-JOHN");
        Assertions.assertEquals("REG-COURSE-WOO-PYTHON ACCEPTED", output);
    }

    @Test
    void courseAllotment() {
        courseRegistration = getCourseRegistrationForCourseAllotmentAndCancellation();
        String output = courseRegistration.courseAllotment("OFFERING-PYTHON-JOHN");
        Assertions.assertEquals("REG-COURSE-WOO-PYTHON WOO@GMAIL.COM OFFERING-PYTHON-JOHN PYTHON JOHN 05062022 CONFIRMED", output);
    }

    @Test
    void cancelRegistration() {
        courseRegistration = getCourseRegistrationForCourseAllotmentAndCancellation();
        String output = courseRegistration.cancelRegistration("REG-COURSE-WOO-PYTHON");
        Assertions.assertEquals("REG-COURSE-WOO-PYTHON CANCEL_ACCEPTED", output);
    }

    private static CourseRegistration getCourseRegistrationForRegisterForCourse() {
        Map<String, Course> courseMap = new HashMap<>();
        Map<String, Employee> employeeMap = new HashMap<>();
        Map<String, CourseRegistrationDetails> registrationDetailsMap = new HashMap<>();
        courseMap.put("PYTHON", new Course("PYTHON", "JOHN", "05062022", 1, 3));
        return new CourseRegistration(courseMap, employeeMap, registrationDetailsMap);
    }

    private static CourseRegistration getCourseRegistrationForCourseAllotmentAndCancellation() {
        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.addCourse("PYTHON", "JOHN", "05062022", 1, 3);
        courseRegistration.registerForCourse("WOO@GMAIL.COM", "OFFERING-PYTHON-JOHN");
        return courseRegistration;
    }
}