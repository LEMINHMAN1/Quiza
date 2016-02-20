package com.zet.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;

/**
 * @author manle
 * 
 */
public final class DateUtil {

    /**
     * Full date format
     */
    public static final String DATE_FORMAT_FULL = "dd/MM/yyyy";
    /**
     * Day short name format, ex: Sun, Mon, Tue, ...
     */
    public static final String DAY_FORMAT = "E";
    /**
     * Daty full name format, ex: Sunday, Monday, Tuesday, ...
     */
    public static final String DAY_FORMAT_FULL_NAME = "EEEE";
    /**
     * Year format
     */
    public static final String YEAR_FORMAT = "yyyy";
    /**
     * date format
     */
    public static final String DATE_FORMAT = "dd";
    
    /**
     * month format
     */
    public static final String MONTH_FORMAT = "MM";
    
    /**
     * hour format
     */
    public static final String HOUR_FORMAT = "HH";
    
    /**
     * minute format
     */
    public static final String MINUTE_FORMAT = "mm";
    
    /**
     * second format
     */
    public static final String SECOND_FORMAT = "ss";
    
    /**
     * Format day, full month name
     */
    public static final String FORMAT_FULL_MONTH = "MMMM dd";
    
    /**
     * Format style Fri Oct 18 2013
     */
    public static final String FORMAT_DATE_MONTH_YEAR = "E MMM dd yyyy";
    /**
     * FORMAT_MMDD
     */
    public static final String FORMAT_MMDD = "MMdd";
    /**
     * Time format with style like 12:24 am
     */
    public static final String TIME_FORMAT = "h:mma";

    /**
     * Time format with style like 12:24
     */
    public static final String TIME_FORMAT_2 = "h:mm";

    /**
     * The numeric format for storing dates in the database, i.e. yyyyMMdd (in Java, equivalent to YYYYMMDD in Oracle).
     */
    public static final String DB_DATE_FORMAT = "yyyyMMdd";

    /**
     * Format full date time, ex. 20142011100911
     */
    public static final String DB_DATE_TIME_FORMAT = "yyyyMMddHHmmss";
    
    /**
     * Logger
     */
    private static Log log = LogFactory.getLog(DateUtil.class);

    /**
     * Checkstyle rule: utility classes should not have public constructor
     */
    private DateUtil() {

    }

    /**
     * Convert DB date number to java date
     * 
     * @param inputNumber Number
     * @return Date
     * @throws ParseException Exception
     */
    public static Date convertNumberToDate(Integer inputNumber) throws ParseException {
        if (inputNumber == null || inputNumber == 0) {
            return null;
        }
        return parseDate(DB_DATE_TIME_FORMAT, inputNumber.toString());
    }

    public static String formatToday(){
    	return formatWithTemplate(DB_DATE_TIME_FORMAT,new Date());
    }
    
    /**
     * format date by format string
     * 
     * @param format {@link String}
     * @param date {@link Date}
     * @return {@link String}
     */
    public static String formatWithTemplate(String format, Date date) {

        String result = "";
        if (date != null) {
            SimpleDateFormat timeFormat = new SimpleDateFormat(format);
            result = timeFormat.format(date);
        }
        return result;
    }

    /**
     * format date with formatting
     * 
     * @param format {@link String}
     * @param date {@link String}
     * @return {@link Date}
     * @throws ParseException {@link ParseException}
     */
    public static Date parseDate(String format, String date) throws ParseException {
        Date result = null;
        if (StringUtils.isNotBlank(date)) {
            SimpleDateFormat timeFormat = new SimpleDateFormat(format);
            if (log.isDebugEnabled()) {
                log.debug("converting '" + date + "' to date with format '" + format + "'");
            }
            result = timeFormat.parse(date);
        }
        return result;
    }
    
    public static String getDateFriendly(Long createDate,MessageSource messageSource) throws ParseException {

    	String result="";
    	
    	Date currentDate  = new Date();
    	int currentDay = Integer.parseInt(formatWithTemplate(DATE_FORMAT,currentDate));
    	int currentMonth = Integer.parseInt(formatWithTemplate(MONTH_FORMAT,currentDate));
    	int currentHour = Integer.parseInt(formatWithTemplate(HOUR_FORMAT,currentDate));
    	int currentMinute= Integer.parseInt(formatWithTemplate(MINUTE_FORMAT,currentDate));
    	int currentSecond= Integer.parseInt(formatWithTemplate(SECOND_FORMAT,currentDate));
    	
    	Date createDateParsed = parseDate(DB_DATE_TIME_FORMAT, createDate.toString());
    	int createDay = Integer.parseInt(formatWithTemplate(DATE_FORMAT,createDateParsed));
    	int createMonth = Integer.parseInt(formatWithTemplate(MONTH_FORMAT,createDateParsed));
    	int createHour = Integer.parseInt(formatWithTemplate(HOUR_FORMAT,createDateParsed));
    	int createMinute= Integer.parseInt(formatWithTemplate(MINUTE_FORMAT,createDateParsed));
    	int createSecond= Integer.parseInt(formatWithTemplate(SECOND_FORMAT,createDateParsed));
    	
    	int monthAgo =Math.abs(currentMonth - createMonth);
    	int dayAgo = Math.abs(currentDay- createDay);
    	int hourAgo=Math.abs(currentHour - createHour);
    	int minuteAgo=Math.abs(currentMinute-createMinute);
    	int secondAgo=Math.abs(currentSecond-createSecond);
    	
    	boolean showTimeDetail = true;
    	
    	// Validate to show time detail, check time no check minute, check minute no check second,...
    	if(monthAgo<=2) showTimeDetail=false;
    	else if(monthAgo>2)dayAgo=-1;
    	
    	if(dayAgo<=3) showTimeDetail=false;
    	else if(dayAgo>1)hourAgo=-1;
    	
    	if(hourAgo<=3) showTimeDetail=false;
    	else if(hourAgo>3)minuteAgo=-1;
    	
    	if(minuteAgo<=15) showTimeDetail=false;
    	else if(minuteAgo>15)secondAgo=-1;
    	
    	if(secondAgo<=59) showTimeDetail=false;
    	
    	
    	
    	if( monthAgo >0 && !showTimeDetail){
    		result = buildMessage(messageSource, "frienly.date.monthAgo",monthAgo);
    		
    	}else if(dayAgo>0 && !showTimeDetail){
    		if(dayAgo==1){
    			String todayText = buildMessage(messageSource, "frienly.date.yesterdayText");
    			result = buildMessage(messageSource, "frienly.date.dateDetail",todayText,DateUtil.formatWithTemplate(TIME_FORMAT_2,createDateParsed));
    		}else{
    			result = buildMessage(messageSource, "frienly.date.dayAgo",dayAgo);
    		}
    		
    	}else if(hourAgo>0 && !showTimeDetail){
    		result = buildMessage(messageSource, "frienly.date.hourAgo",hourAgo);
    		
    	}else if(minuteAgo>0 && !showTimeDetail){
    		result = buildMessage(messageSource, "frienly.date.minuteAgo",minuteAgo);
    		
    	}else if(secondAgo>0  && !showTimeDetail){
    		result = buildMessage(messageSource, "frienly.date.secondAgo",secondAgo);
    		
    	}else{
    		
    		if(dayAgo==0){
    			String todayText = buildMessage(messageSource, "frienly.date.todayText");
    			result = buildMessage(messageSource, "frienly.date.dateDetail",todayText,DateUtil.formatWithTemplate(TIME_FORMAT_2,createDateParsed));
    		}else{
    			result = buildMessage(messageSource, "frienly.date.dateDetail",DateUtil.formatWithTemplate(DATE_FORMAT_FULL,createDateParsed),DateUtil.formatWithTemplate(DateUtil.TIME_FORMAT_2,createDateParsed));
    		}
    	}
    	
        return result;
    }

    
    public static String getTimer(Long second){
    	String result ="";
    	int hour = (int) Math.floor(second.longValue()/3600);
    	second = second%3600;
    	int minute = (int) Math.floor(second.longValue()/60);
    	second = second%60;
    	
    	int sec = (int) Math.floor(second);
    	
    	String prettyHour = prettyTime(hour);
    	String prettyMin = prettyTime(minute);
    	String prettySec = prettyTime(sec);
    	
    	result = prettyHour+":"+prettyMin+":"+prettySec;
        return result;
    }
    
    private static String prettyTime(Integer value){
    	String result ="";
    	if(value.intValue()<10){
    		result = "0"+value;
    	}else{
    		result=value.toString();
    	}
    	return result;
    }
    
    
    /**
     * Build message from resource file
     * 
     * @param messageSource
     *            {@link MessageSource}
     * @param key
     *            {@link String}
     * @param value
     *            array of object
     * @return {@link String}
     */
    private static String buildMessage(final MessageSource messageSource, final String key, Object... value) {

        return messageSource.getMessage(key, value, new Locale("vie"));
    }
 
    
}
