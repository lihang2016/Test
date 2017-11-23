package com.example.Annto.AnntoImpl;

import com.example.Annto.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author:lihang
 * @Description:
 * @Date Create in 15:16 2017/11/1
 */
public class PhoneValidator  implements ConstraintValidator<Phone, String> {
   private String msg;
    @Override
    public void initialize(Phone phone) {
        msg=phone.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s==null){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("手机号码不能为空").
                    addConstraintViolation();
            return false;
        }
       if(s.length()==11){
           return false;
       }
        return false;
    }
}
