/**
 *
 * @author awood
 */
package arwcrm.validation;

import arwcrm.objects.Interactions;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author awood
 */
@Component
public class InteractionsValidator implements Validator {

    private static final Logger logger = Logger.getLogger(InteractionsValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return Interactions.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first_name", "interactions.first_name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", "interactions.last_name.required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "interactions.status.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "method_of_contact", "interactions.method_of_contact.required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "interactions.email.required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "interactions.phone.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "notes", "interactions.notes.required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact_date", "interactions.contact_date.required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "CustomerID", "interactions.CustomerID.required");


//        if (interactions.getLast_name().length() > 45) {
//            errors.rejectValue("last_name", "interactions.last_name.length");
//        }
//        if (interactions.getStatus().length() > 45) {
//            errors.rejectValue("status", "interactions.status.length");
//        }
//        if (interactions.getMethod_of_contact().length() > 12) {
//            errors.rejectValue("method_of_contact", "interactions.method_of_contact.length");
//        }
//        if (interactions.getEmail().length() > 64) {
//            errors.rejectValue("email", "interactions.email.length");
//        }
//        if (interactions.getPhone().length() > 16) {
//            errors.rejectValue("phone", "interactions.phone.length");
//        }
//        if (interactions.getNotes().length() > 256) {
//            errors.rejectValue("notes", "interactions.notes.length");
//        }
//        if (interactions.getContact_date().length() > 45) {
//            errors.rejectValue("contact_date", "interactions.contact_date.length");
//        }
//        if (!interactions.getContact_date().matches("^([0]\\d|[1][0-2])\\/([0-2]\\d|[3][0-1])\\/([2][01]|[1][6-9])\\d{2}(\\s([0-1]\\d|[2][0-3])(\\:[0-5]\\d){1,2})?$")) {
//            errors.rejectValue("contact_date", "interactions.contact_date.pattern");
//        }
//    }
//}
//      if (interactions.getFirst_name() != null && !interactions.getFirst_name().matches("^[A-Za-z]{2,45}$")) {
//          errors.rejectValue("first_name", "interactions.first_name.pattern");
//      }
//      if (interactions.getLast_name() != null && !interactions.getLast_name().matches("^[A-Za-z]{2,45}$")) {
//          errors.rejectValue("last_name", "interactions.last_name.pattern");
//      }
//      if (interactions.getEmail() != null && !interactions.getEmail().matches("^(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])$")) {
//          errors.rejectValue("email", "interactions.email.pattern");
//      }
//      if (interactions.getPhone() != null && !interactions.getPhone().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])?$")) {
//          errors.rejectValue("phone", "interactions.phone.pattern");
      }
}
