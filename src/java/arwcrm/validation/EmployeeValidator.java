package arwcrm.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;
import arwcrm.objects.Customer;
import arwcrm.objects.Employee;
import arwcrm.objects.Invoice;
import arwcrm.objects.JobCategory;
import arwcrm.objects.JobProfiles;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author awood
 */
@Component
public class EmployeeValidator implements Validator {

    private static final Logger logger = Logger.getLogger(EmployeeValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeLastName", "Employee.last.name.required");

        Employee employee = (Employee) target;
        if (employee.getEmployeeLastName().length() > 120) {
            errors.rejectValue("employeeName", "employee.name.length");
        }

        if (employee.getEmployeeFirstName().length() > 120) {
            errors.rejectValue("employeeName", "employee.name.length");
        }

        if (!employee.getEmployeeLastName().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("employeeName", "employee.name.pattern");
        }

        if (!employee.getEmployeeLastName().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("employeeName", "employee.name.pattern");
        }
    }
}
