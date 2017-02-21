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
public class InvoiceValidator implements Validator {

    private static final Logger logger = Logger.getLogger(InvoiceValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return Invoice.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "invoiceID", "invoice.invoiceID.required");

        Invoice invoice = (Invoice) target;
        if (invoice.getInvoiceID().length() > 120) {
            errors.rejectValue("invoiceID", "invoice.invoiceID.length");
        }

        if (!invoice.getInvoiceID().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("name", "invoiceID.name.pattern");
        }
    }
}
