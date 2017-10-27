package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by 96230 on 2017/4/17.
 */
@Setter
@Getter
public class PersonDto extends PageDto{

    @NotNull
    private String name;

    private Integer studentAge;

    private String address;

}
