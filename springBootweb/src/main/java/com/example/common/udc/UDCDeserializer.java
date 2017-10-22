
package com.example.common.udc;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.example.exception.Exceptions;
import com.example.util.SplitConstants;
import com.google.common.base.Splitter;

import java.lang.reflect.Type;
import java.util.List;

/**
 *
 */
public class UDCDeserializer implements ObjectDeserializer {
    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        int token = parser.getLexer().token();
        if (token == JSONToken.NULL) {
            parser.getLexer().nextToken(JSONToken.COMMA);
            return null;
        }
        Object value = parser.parse();
        if (value == null) {
            return null;
        }
        if (token == JSONToken.LITERAL_STRING) {
            List<String> list = Splitter.on(SplitConstants.SEPARATOR_CHAR_COMMA).trimResults().splitToList(value.toString());
            if (list.size() == 2) {
                return (T) UDC.newUDCWithItemValue(list.get(0), Integer.parseInt(list.get(1)));
            } else {
                throw Exceptions.newRuntimeException("UDC类型json值类型为字符串,格式为:typeCode,itemValue");
            }
        } else if(token == JSONToken.LBRACE){
            JSONObject json = (JSONObject)value;
            return (T) UDC.newUDCWithItemValue(json.getString("typeCode"), json.getIntValue("itemValue"));
        } else{
            throw Exceptions.newRuntimeException("UDC类型json值类型为字符串,格式为:typeCode,itemValue;或者json对象,格式为{typeCode:xxx,itemValue:xxx}");
        }
    }

    @Override
    public int getFastMatchToken() {
        return 105;
    }
}
