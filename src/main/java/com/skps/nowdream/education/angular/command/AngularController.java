package com.skps.nowdream.education.angular.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctr")
public class AngularController {
	
	private static final Logger logger = LoggerFactory.getLogger(AngularController.class);
	
	@RequestMapping("/void")
	public String voided(){
		logger.info("startss");
		return "/void";
	}
	
	@RequestMapping("/angularBbss")
	public String angularBbs(){
		logger.info("startss");
		return "/angularBbs/angularBbs";
	}
	
	

}
