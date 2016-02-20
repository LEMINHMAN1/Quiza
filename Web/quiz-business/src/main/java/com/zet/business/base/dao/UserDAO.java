package com.zet.business.base.dao;

import java.util.List;

import com.zet.business.base.entities.User;

/**
 * 
 * @author man le
 *
 */
public interface UserDAO {

    public int save(User user);
    
    public void delete(int userId);
     
    public List<User> list(long userId);
    
}
