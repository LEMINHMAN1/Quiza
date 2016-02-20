package com.zet.web.autopost.controller;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zet.web.enumerator.PageType;
import com.zet.web.util.ModelUtil;

@Controller
public class AutopostController extends AutopostBaseController{

	private final static Logger logger = Logger.getLogger(AutopostController.class);
	
	@RequestMapping(value = "/autopost.htm", method = RequestMethod.GET)
	public ModelAndView indexGet(
			ModelMap modelMap
			) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, RemoteException{
		
		ModelAndView model = ModelUtil.getPage(PageType.AUTOPOST, modelMap);
		return model;
		
	}
	
}
