package com.zet.business.base.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zet.business.base.dao.UserDAO;
import com.zet.business.base.entities.User;
import com.zet.framework.util.DateUtil;

/**
 * 
 * @author man le
 *
 */
public class UserDAOImpl  implements UserDAO{

    private JdbcTemplate jdbcTemplate;
    
    public UserDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int save(User user) {

        String sql=null;
        if(user.getUserId() == null || user.getUserId()==0){
            sql = "INSERT INTO s_user (name, email, timeAntiSpam)"
                    +    "VALUES (?, ?, ?)";
        }else{
            
        }
        
        int save = jdbcTemplate.update(sql,
                new Object[]{
                            user.getName(),
                            user.getEmail(),
                            StringUtils.defaultIfBlank(user.getTimeAntiSpam(), "0000")
                            }                       
                );
        return save;
    }

    public void delete(int userId) {

        // TODO Auto-generated method stub
        
    }

    public List<User> list(long userId) {

        // TODO Auto-generated method stub
        return null;
    }
    


}
