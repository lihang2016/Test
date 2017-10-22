
package com.example.common.udc;

import com.example.exception.Exceptions;
import com.example.util.SplitConstants;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import org.springframework.core.convert.converter.Converter;

import java.util.List;


/**
 *
 */
public class StringToUDCConverter implements Converter<String, UDC> {

    @Override
    public UDC convert(String source) {
        if (Strings.isNullOrEmpty(source)) {
            return null;
        } else {
            List<String> list = Splitter.on(SplitConstants.SEPARATOR_CHAR_COMMA).trimResults().splitToList(source);
            if (list.size() != 2) {
                throw Exceptions.newRuntimeException("UDC类型必须用逗号隔开");
            }
            return UDC.newUDCWithItemValue(list.get(0), Integer.parseInt(list.get(1)));
        }
    }
}
