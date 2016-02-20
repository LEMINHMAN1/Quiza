package com.zet.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author man le
 *
 */
public class ValidateKidUtil {

	private static Pattern pattern;
	private static Matcher matcher;

	private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static final String VI_DATE="dd/mm/yyyy";
	
	public static boolean validateEmail(String value){
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(value);
		return matcher.matches();
	}
	
	public static boolean validateDate(String value, String formatTemplate){
			
			if(StringUtils.isBlank(value)){
				return false;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(formatTemplate);
			sdf.setLenient(false);
			
			try {
				Date date = sdf.parse(value);
			
			} catch (ParseException e) {
				return false;
			}
			return true;
	}
	
}
