package arwcrm.validation;

import arwcrm.objects.User;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author awood
 */
@Component
public class UserValidator implements Validator {

    private static final Logger logger = Logger.getLogger(UserValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "user.username.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password.required");
    }
}
