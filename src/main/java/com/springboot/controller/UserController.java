package com.springboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.VO.UserDetailsVO;
import com.springboot.service.ManageUserService;

@Controller
public class UserController {

	@Autowired
	ManageUserService userService;
	
	
	 @RequestMapping(value = { "/register"}, method = RequestMethod.GET)
	    public String registerUser(ModelMap model) {
		 	model.addAttribute("userVO", new UserDetailsVO());
	        return "Registration"; 
	    }
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addBook(HttpServletRequest request,
	        HttpServletResponse response,
	        @ModelAttribute("userVO")
	    UserDetailsVO userVO) { 
		System.out.println("UserController addUser()  Entry:  ");
		 ModelAndView modelAndView = new ModelAndView("Registration");
		 String message="";
		try {
			boolean insert=userService.addUser(userVO);
			if(insert){
	            message = "User Added Successfully";
	            modelAndView.addObject("isErrorMsg", false);
	            modelAndView.addObject("message", message);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	
}
