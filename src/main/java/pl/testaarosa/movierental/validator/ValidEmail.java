package pl.testaarosa.movierental.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailRentalUserValidator.class)
@Documented
public @interface ValidEmail {
    String message() default "Invalid e-email format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
