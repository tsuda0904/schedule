package com.eightbit.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eightbit.schedule.entity.User;
import com.eightbit.schedule.model.SecuritySession;
import com.eightbit.schedule.model.UserUpdateQuery;
import com.eightbit.schedule.service.MypageService;
import com.eightbit.schedule.service.UserService;

@Controller
public class MypageController {
	
	private final MypageService mypageService;
	
	@Autowired
	private SecuritySession securitySession;
	
	@Autowired
	public MypageController(MypageService mypageService) {
		this.mypageService = mypageService;
	}
	
	@GetMapping(path = "/mypage/index")
	public String routeToMypageIndex(Model model) {
		System.out.println(securitySession.getUsername());
		User user = mypageService.searchUserById();
		model.addAttribute("user", user);
		UserUpdateQuery uuq = mypageService.getUserDto(user);
		model.addAttribute("userUpdateQuery", uuq);
		return "mypageIndex";
	}
	
	@PostMapping("/mypage/update")
	public String updateMypage(@ModelAttribute UserUpdateQuery userUpdateQuery, Model model) {
		mypageService.updateMypage(userUpdateQuery);
		
		return "redirect:/mypage/index";
	}

}