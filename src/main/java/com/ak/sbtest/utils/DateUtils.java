package com.ak.sbtest.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DateUtils {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    private final static Logger log = LoggerFactory.getLogger(DateUtils.class);
    
    public static Date createDateFromString(String dateString) {
        Date result = null;
        if (dateString != null) {
            try {
                result = DATE_FORMAT.parse(dateString);
            } catch (ParseException pe) {
                result = new Date();
                log.error("Error while parsing string " + dateString + " to date.", pe);
            }
        } else {
            result = new Date();
        }
        return result;
    }
}
