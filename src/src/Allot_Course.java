import enums.RegistrationStatus;
import src.Dto.Employee;
import java.util.Collections;
import java.util.Map;

public class Allot_Course {
    Register_Course register_course;
    Employee employee;
    public void allot(){
        register_course.getCourseEmployeeMap().forEach((course, employees) -> {
            if (course.getMax_limit()>=employees.size())
                employees.stream().forEach(employee -> employee.setRegistrationStatus(RegistrationStatus.COMPLETED));
        });
        Collections.sort(register_course.getCourseEmployeeMap(),employee.getRegistrationNumber()<employee.getRegistrationNumber());
    }
}
