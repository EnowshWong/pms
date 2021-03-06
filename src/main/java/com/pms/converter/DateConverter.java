package com.pms.converter;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:wong
 */
public class DateConverter implements Converter<String,Date> {

    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date convert(String s) {
        if (StringUtils.isBlank(s)){
            return null;
        }
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
