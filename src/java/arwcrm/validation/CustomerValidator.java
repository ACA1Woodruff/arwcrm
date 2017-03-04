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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerName", "customer.name.required");

        Customer customer = (Customer) target;
        if (customer.getCustomerName().length() > 120) {
            errors.rejectValue("customerName", "customer.name.length");
        }

        if (!customer.getCustomerName().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("customerName", "customer.name.pattern");
        }

       
        }
    }

