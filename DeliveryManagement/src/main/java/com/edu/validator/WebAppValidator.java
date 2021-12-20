// Cấu hình để sử dụng bean validator song song với spring validator tự làm
package com.edu.validator;

import com.edu.pojo.User;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

// Phải khai báo là component
@Component
public class WebAppValidator implements Validator {

    // Móc vào bean validator
    @Autowired
    private javax.validation.Validator beanValidator;
    // Khai báo set các validator tự làm
    private Set<Validator> springValidators;
    // Và setter của nó
    public void setSpringValidators(Set<Validator> springValidators) {
        this.springValidators = springValidators;
    }
    
    // Cho biết validator có được phép kiểm tra một lớp (mình chỉ định) hay không (phải chỉ định nó mới chạy)
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Phương thức được gọi để kiểm tra dữ liệu của đối tượng lớp
    @Override
    public void validate(Object target, Errors errors) {
        // Duyệt qua bean validator
        Set<ConstraintViolation<Object>> beans  = this.beanValidator.validate(target);
        for (ConstraintViolation<Object> obj: beans) {
            errors.rejectValue(obj.getPropertyPath().toString(),
                    obj.getMessageTemplate(),
                    obj.getMessage());
        }
        
        // Duyệt qua spring validator tự mình làm
        for (Validator v: this.springValidators) {
            v.validate(target, errors);
        }
    }
    
}
