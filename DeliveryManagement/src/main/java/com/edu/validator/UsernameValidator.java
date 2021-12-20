package com.edu.validator;

import com.edu.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class UsernameValidator implements Validator{
    
    // Khai báo chỉ định lớp pojo sẽ được validate
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }
    
    // Phương thức thực hiện validate
    @Override
    public void validate(Object target, Errors errors) {
        User u = (User) target;
//        if (!u.getUsername().contains("Something")) {
//            errors.rejectValue("username", "user.username.containSomething");
//        }
    }
    
}
