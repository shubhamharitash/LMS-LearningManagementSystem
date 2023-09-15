import enums.RegistrationStatus;
import src.Dto.Employee;

public class Cancel_Registration {
    Register_Course register_course;
    public void cancel(Employee employee) throws Exception{
        if (employee.getRegistrationStatus().equals(RegistrationStatus.COMPLETED)){
            throw new Exception("CANCEL_REJECTED");
        }else {
            register_course.getCourseEmployeeMap().get(employee.getCourseRegistered()).remove(employee);
        }
    }
}
