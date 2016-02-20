package com.zet.business.base.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.zet.business.base.entities.User;
import com.zet.business.base.util.RowMapperUtils;

/**
 * 
 * @author man le
 *
 */
public class UserRowMapper implements RowMapper<User>{

    private final static Logger logger = Logger.getLogger(User.class);
    
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        
        try {
            RowMapperUtils.setObject(user,rs);
            
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return user;
        
        
        
        /*try {
            RowMapperUtils.setObject(webConfig,rs);
            
            Store webAccount = new Store();
            RowMapperUtils.setObject(webAccount,rs);
            webConfig.getWebAccountList().add(webAccount);
            
            WebCategory webCategory = new WebCategory();
            RowMapperUtils.setObject(webCategory,rs);
            
            Category category = new Category();
            RowMapperUtils.setObject(category,rs);
            webCategory.getCategoryList().add(category);
            
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return webConfig;*/
        
    }
}
