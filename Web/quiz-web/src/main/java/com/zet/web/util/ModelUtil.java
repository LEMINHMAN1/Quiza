package com.zet.web.util;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.zet.web.enumerator.PageType;

/**
 * 
 * @author man le
 *
 */
public class ModelUtil {

	public static ModelAndView getPage(PageType pageType, ModelMap modelMap){
		modelMap.addAttribute("pageCode",pageType.getPageCode());
		ModelAndView model = new ModelAndView(pageType.getPageName(),modelMap);
		return model;
	}
	
}
