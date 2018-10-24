package pl.testaarosa.movierental.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitValidator implements ConstraintValidator<DigitValid, String> {

    private static final String DIGIT_PATERN = "\\d+";
    private Matcher matcher;
    private Pattern pattern;

    public DigitValidator() {
        this.pattern = Pattern.compile(DIGIT_PATERN);
    }

    @Override
    public void initialize(DigitValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext context) {
        return validateId(id);
    }

    private boolean validateId(String id) {
        matcher = pattern.matcher(id);
        return matcher.matches();
    }
}
