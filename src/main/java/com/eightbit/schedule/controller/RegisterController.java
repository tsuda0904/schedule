package com.eightbit.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eightbit.schedule.entity.LoginUser;
import com.eightbit.schedule.model.LoginUserDto;
import com.eightbit.schedule.service.LoginUserDetailsService;

@Controller
public class RegisterController {
	
	@Autowired
	private LoginUserDetailsService loginUserDetailsService;
	
	@GetMapping("/register")
	public ModelAndView registerForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginUser", new LoginUserDto());
		mav.setViewName("register");
		return mav;
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute LoginUserDto loginUserDto) {
		LoginUser existing = loginUserDetailsService.findByEmail(loginUserDto.getEmail());
		if(existing != null) {
			return "register";
		}
		loginUserDetailsService.save(loginUserDto);
		return "login";
	}
}