package com.bittereggs.money.config;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 楼中煊
 * @data 2019/3/28
 * @time 14:40
 */

@Configuration
public class JsonDateValueProcessor implements JsonValueProcessor {

    private String datePattern = "yyy-MM-dd HH:mm:ss";

    public JsonDateValueProcessor(){
        super();
    }

    public JsonDateValueProcessor(String datePattern) {
        super();
        this.datePattern = datePattern;
    }

    @Override
    public Object processArrayValue(Object o, JsonConfig jsonConfig) {

        try {
            if (o instanceof Date){
                SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
                Date date = (Date) o;
                return sdf.format(date);
            }
        } catch (Exception e){
            return null;
        }
        return null;
    }

    @Override
    public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
        return processArrayValue(o,jsonConfig);
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }
}
