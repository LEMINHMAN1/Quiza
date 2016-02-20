package com.zet.web.access.controller;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zet.business.base.entities.BusinessResponse;
import com.zet.web.access.host.AccessHost;
import com.zet.web.access.model.AccessModel;
import com.zet.web.enumerator.PageType;
import com.zet.web.util.ModelUtil;

@Controller
public class LoginController extends AccessBaseController{

private final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	@Resource(name="accessHost")
	private AccessHost accessHost;

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public ModelAndView indexGet(
			ModelMap modelMap
			) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, RemoteException{
		
		ModelAndView model = ModelUtil.getPage(PageType.LOGIN, modelMap);
		return model;
		
	}
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public @ResponseBody AccessModel indexPost(@RequestBody AccessModel accessModel,
			ModelMap modelMap
			) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, RemoteException{
		BusinessResponse res = accessHost.login(accessModel);
		
		return accessModel;
		
	}
	
}
