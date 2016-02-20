package com.zet.business.base.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.util.StringUtils;

/**
 * 
 * @author man le
 *
 */
public class RowMapperUtils{

    @SuppressWarnings({"rawtypes"})
    public static void setObject(Object obj,ResultSet rs) throws Exception{
        ResultSetMetaData rsMeta= rs.getMetaData();
        
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        
        for(int col=1;col<=rsMeta.getColumnCount();col++){
            
            String colName = rsMeta.getColumnName(col);
            int colType = rsMeta.getColumnType(col);
           
            for(Field field : fields){
                String fieldName = field.getName();
                
                if(fieldName.equalsIgnoreCase(colName)){
                    invokeMethod(obj,rs,colType,fieldName,colName);
                }
                
            }
            
            
        }
        
    }
    
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static void invokeMethod(Object obj,ResultSet rs, int colType , String fieldName,String colName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException{
        Class clazz = obj.getClass();
        Method method = null;
        String setString="set";
        switch(colType){
        case Types.BIGINT:
            method = clazz.getDeclaredMethod(setString+StringUtils.capitalize(fieldName),Long.class);
            method.invoke(obj,  rs.getLong(colName));
            break;
            
        case Types.VARCHAR:
        case Types.CHAR:
            method = clazz.getDeclaredMethod(setString+StringUtils.capitalize(fieldName),String.class);
            method.invoke(obj,  rs.getString(colName));
            break;
            
        case Types.INTEGER:
            method = clazz.getDeclaredMethod(setString+StringUtils.capitalize(fieldName),Integer.class);
            method.invoke(obj,  rs.getInt(colName));
            break;
         
        }
    }
}
