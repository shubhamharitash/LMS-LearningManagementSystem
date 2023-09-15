import src.Dto.Course;
import src.Dto.Employee;

import java.util.List;
import java.util.Map;

public class Register_Course {

   public Map<Course, List<Employee>> courseEmployeeMap;
    public Map<Course, List<Employee>> getCourseEmployeeMap() {
        return courseEmployeeMap;
    }

public void addRegistration(Course course,Employee employee) throws Exception{
        if (courseEmployeeMap.get(course).size()<course.getMax_limit()){
            courseEmployeeMap.get(course).add(employee);
        }else {
            throw new Exception("COURSE_FULL_ERROR");
        }
}
}
