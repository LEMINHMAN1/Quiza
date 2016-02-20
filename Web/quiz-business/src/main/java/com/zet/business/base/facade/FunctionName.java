package com.zet.business.base.facade;

/**
 * 
 * @author man le
 *
 */
public enum FunctionName {
    READ_ARTICLE("ReadArticle"),
    UPDATE_ARTICLE("UpdateArticle"),
    DELETE_ARTICLE("DeleteArticle"),
    GET_LIST_SITE_USERID("GetListWebSiteByUserId");
    
    
    
    private String name;
    FunctionName(String name){
        this.name = name;
    }
    
    
    public String getName(){
        return name;
    }
}
