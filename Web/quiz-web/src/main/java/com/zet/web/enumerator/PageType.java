package com.zet.web.enumerator;

import java.util.EnumSet;

public enum PageType {

	MY_PAGE("mypage/linkTemplate",1),
	COMMENT_MANAGER("commentManager/linkTemplate",2),
	AUTOPOST("autopost/linkTemplate",3),
	MY_PROFILE("myprofile/linkTemplate",4),
	LOGIN("access/login/linkTemplate",5),
	;
	
	private static EnumSet<PageType> pageTypes=  EnumSet.allOf(PageType.class);
	
	private String pageName;
	private Integer pageCode;
	
	PageType(String pageName,Integer pageCode){
		this.setPageName(pageName);
		this.pageCode=pageCode;
		
	}

	public Integer getPageCode() {
		return pageCode;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	
	public static PageType getPageType(Integer code){
		PageType result = PageType.MY_PAGE;
		for(PageType pageType:pageTypes){
			if(pageType.getPageCode()==code){
				result = pageType;
				break;
			}
		}
		return result;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
}
