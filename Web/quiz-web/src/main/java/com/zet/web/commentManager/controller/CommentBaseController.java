package com.zet.web.commentManager.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

/**
 * 
 * @author man le
 *
 */
@Controller
public class CommentBaseController {

	@Autowired
	@Resource(name = "messageSource")
	protected MessageSource messageSource;	

}
