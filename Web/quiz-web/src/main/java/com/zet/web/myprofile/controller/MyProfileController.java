package com.zet.web.myprofile.controller;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zet.web.enumerator.PageType;
import com.zet.web.mypage.controller.HomeController;
import com.zet.web.util.ModelUtil;

/**
 * 
 * @author man le
 *
 */
@Controller
public class MyProfileController extends ProfileBaseController{

	private final static Logger logger = Logger.getLogger(MyProfileController.class);
	
	@RequestMapping(value = "/myprofile.htm", method = RequestMethod.GET)
	public ModelAndView indexGet(
			ModelMap modelMap
			) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, RemoteException{
		
		ModelAndView model = ModelUtil.getPage(PageType.MY_PROFILE, modelMap);
		return model;
		
	}
	
}
