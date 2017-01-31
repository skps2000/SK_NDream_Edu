package com.skps.nowdream.education.angular.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.skps.nowdream.education.angular.Service.AngularBbsService;

@RestController
@RequestMapping("/command")
public class CommandController {
	private static final Logger logger = LoggerFactory.getLogger(CommandController.class);
	
	@Autowired
	private AngularBbsService angularBbsService;
	
	
	@RequestMapping("/index")
	public String index(HttpServletRequest req, HttpServletResponse res){
		return "/pages/index.html";
	}

	
}
