package com.eightbit.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eightbit.schedule.entity.User;
import com.eightbit.schedule.model.UserUpdateQuery;
import com.eightbit.schedule.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(path = "/user/index")
	public String routeToUserIndex(Model model) {
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		
		return "userIndex";
	}
	
	@GetMapping("/user/search")
	public String searchUser(Model model, @RequestParam("name") String name) {
		List<User> userList = userService.searchUser(name);
		model.addAttribute("userList", userList);
		model.addAttribute("searchName", name);
		
		return "userIndex";
	}
	
	@GetMapping("/user/search/id")
	public String searchUserById(Model model, @RequestParam("id") int userId) {
		User user = userService.searchUserById(userId);
		model.addAttribute("user", user);
		UserUpdateQuery uuq = userService.getUserDto(user);
		model.addAttribute("userUpdateQuery", uuq);

		return "userDetail";
	}
	
	@PostMapping("/user/update")
	public String updateUser(@ModelAttribute UserUpdateQuery userUpdateQuery, Model model) {
		userService.updateUser(userUpdateQuery);
		String param = "?id=" + userUpdateQuery.getUserId();
		return "redirect:/user/search/id" + param;
	}
	
	@PostMapping("/user/delete")
	public String deleteUser(@RequestParam("id") int userId) {
		userService.deleteUserData(userId);
		return "redirect:/user/index";
	}
	
	@GetMapping("/user/regist")
	public String userRegist(Model model) {
		model.addAttribute("userEntity", new User());
		return "userRegist";
	}
	
	@PostMapping("/user/registExecute")
	public String userRegistExecute(@ModelAttribute User user, @RequestParam("birthday") String birth) {
		userService.userRegist(user, birth);
		
		return "redirect:/user/index";
	}
}