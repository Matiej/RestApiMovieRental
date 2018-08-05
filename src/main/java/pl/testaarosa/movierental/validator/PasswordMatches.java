package pl.testaarosa.movierental.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;

@Target({TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordRentalUserValidator.class)
@Documented
public @interface PasswordMatches {

    String message() default "Passwords don't match each others";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
