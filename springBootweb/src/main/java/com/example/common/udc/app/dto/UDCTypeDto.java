package com.example.common.udc.app.dto;


import com.example.dto.BaseDto;
import com.example.dto.PageDto;

import javax.validation.constraints.NotNull;

/**
 *
 */
public class UDCTypeDto extends BaseDto {

    @NotNull(groups = Update.class)
    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public interface Update {

    }
}
