package com.example.member.app.dto;

import com.example.Annto.Phone;
import com.example.common.udc.UDC;
import com.example.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


/**
 * Created by 96230 on 2017/6/10.
 */
@Getter
@Setter
public class LoginDto extends BaseDto {

    @Phone(message = "手机号码有问题")
    private String phone;

    private String password;

    private UDC sex;

    public interface Update{

    }
}
