package com.zet.framework.util;

/**
 * 
 * @author manle
 *
 */
public class StringConvert {
	
	public static String defaultIfNull(Object obj, String defaultValue){
		String result = defaultValue;
		if(null != obj) result = obj.toString();
		return result;
	}
}
