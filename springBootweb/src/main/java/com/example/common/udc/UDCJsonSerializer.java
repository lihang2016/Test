package com.example.common.udc;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectSerializer;

import java.io.IOException;

/**
 * @Author:lihang
 * @Description:
 * @Date Create in 20:56 2017/12/11
 */
@JsonComponent
public class UDCJsonSerializer extends JsonObjectSerializer<UDC> {
    @Override
    protected void serializeObject(UDC value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStringField("itemCode", value.getItem().getCode());
        gen.writeNumberField("itemId", value.getItem().getId().longValue());
        gen.writeStringField("itemName", value.getItem().getName());
        gen.writeNumberField("itemValue", value.getItem().getValue().intValue());
        gen.writeStringField("typeCode", value.getTypeCode());
    }
}
