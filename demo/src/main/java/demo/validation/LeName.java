package demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LeNameValidator.class) // Liên kết với class Validator
@Target({ElementType.FIELD, ElementType.METHOD}) // Áp dụng cho field hoặc method
@Retention(RetentionPolicy.RUNTIME) // Giữ lại lúc runtime
public @interface LeName {
    String message() default "Tên phải bắt đầu bằng 'Le'"; // Thông báo lỗi mặc định
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}