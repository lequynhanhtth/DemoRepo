package demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LeNameValidator implements ConstraintValidator<LeName, String> {
    @Override
    public void initialize(LeName constraintAnnotation) {
        // Không cần khởi tạo gì đặc biệt trong trường hợp này
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (name == null) {
            return false; // Không cho phép null
        }
        return name.trim().startsWith("Le"); // Kiểm tra xem tên có bắt đầu bằng "Le" không
    }
}