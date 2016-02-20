package com.zet.business.base.facade;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zet.business.base.dao.UserDAO;
import com.zet.business.base.entities.ActionType;
import com.zet.business.base.entities.BusinessRequest;
import com.zet.business.base.entities.BusinessResponse;
import com.zet.business.base.entities.StatusType;
import com.zet.business.base.entities.User;
import com.zet.business.base.util.ObjectUtils;

/**
 * 
 * @author man le
 *
 */

@Component("userFacade")
public class UserFacade {

    @Autowired
    @Resource(name = "userDAO")
    protected UserDAO userDAO;
    
    public void adapt(BusinessRequest req, BusinessResponse res) {
       ActionType actionType = req.getActionType();
       switch(actionType){
       case SIGNIN:
           signIn(req, res);
           break;
       }
    }
    
    private void signIn(BusinessRequest req,BusinessResponse res){
        User user =(User) ObjectUtils.getObject(req.getUserList(),User.class);
        int save= userDAO.save(user);
        if(save<0){
            res.setStatusType(StatusType.FAILED);
            res.setReason("Cannot save the user");
        }
    }
    
}
