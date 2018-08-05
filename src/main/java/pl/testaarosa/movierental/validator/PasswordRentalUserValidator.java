package pl.testaarosa.movierental.validator;

import pl.testaarosa.movierental.form.dto.UserFormDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordRentalUserValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        UserFormDto userFormDto = (UserFormDto) value;
        return userFormDto.getPassword().equals(userFormDto.getMatchingPassword());
    }
}
