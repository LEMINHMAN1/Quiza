package com.zet.business.base.util;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.zet.business.base.entities.AccountType;
import com.zet.business.base.entities.Article;
import com.zet.business.base.entities.Autopost;
import com.zet.business.base.entities.User;


public class ObjectUtils {

    @SuppressWarnings("rawtypes")
    public static Object getObject(List<?> objects, Class classes){
        Object result = null;
        
        if(!CollectionUtils.isEmpty(objects)){
            result = objects.get(0);
        
        }else{
            if(User.class.equals(classes)){
                result = new User();
            }else if(AccountType.class.equals(classes)){
                result = new AccountType();
            }else if(Article.class.equals(classes)){
                result = new Article();
            }else if(Autopost.class.equals(classes)){
                result = new Autopost();
            }
        }
        return result;
    }
    
}
