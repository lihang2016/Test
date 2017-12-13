package com.example.obs.app.dto;

import com.example.dto.CPResponse;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.util.Assert;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @Author:lihang
 * @Description:
 * @Date Create in 17:12 2017/12/13
 */
@Getter
@Setter
public class ObsResult  extends CPResponse {

    private Long id;
    private byte[] content;
    private String fileName;

    private long fileSize;
    public InputStream getInputStream() {
        Assert.notNull(this.content);
        return new ByteArrayInputStream(this.content);
    }
}
