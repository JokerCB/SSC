package com.ssc.demo.web.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssc.demo.web.controller.base.MessageController;

@Controller
public class IndexController extends MessageController{
	
	
	private static final String UNSYSAUTHORIZED = "unSysAuthorized";
	

//	@SuppressWarnings("static-access")
//	@RequestMapping(value = "index", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String username = null;
//		ModelAndView modle = new ModelAndView();
//		
//		return modle;
//	}


	
	
}
