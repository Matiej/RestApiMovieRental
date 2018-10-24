package pl.testaarosa.movierental.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DigitValidator.class)
@Documented
public @interface DigitValid {

    String message() default "Invalid format! Accepts only digits";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
