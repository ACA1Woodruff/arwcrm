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
public class CustomerValidator implements Validator {

    private static final Logger logger = Logger.getLogger(CustomerValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "customer.name.required");

        Customer customer = (Customer) target;
        if (customer.getName().length() > 120) {
            errors.rejectValue("name", "customer.name.length");
        }

        if (!customer.getName().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("name", "customer.name.pattern");
        }

        if (!customer.getEmail().isEmpty()) {
            if (!customer.getEmail().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
                errors.rejectValue("Email", "customers.Email.pattern", "default");
            }
        }
    }
}
