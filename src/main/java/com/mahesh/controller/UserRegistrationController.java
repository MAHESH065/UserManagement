package com.mahesh.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mahesh.entity.User;

import com.mahesh.service.UserService;

@Controller
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String loadRegForm(Model model) {
		User userObj = new User();
		Map<Integer, String> findAllCountries = userService.findAllCountries();
		
		model.addAttribute("user", userObj);
		model.addAttribute("countryObjs", findAllCountries);
		return "registration-page";
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/getAllState") public String
	 * findAllState(@RequestParam("countryId") Integer countryId){
	 * System.out.println("method call"+countryId); List<State> allStateByCountryId
	 * = stateRepo.getAllStateByCountryId(countryId);
	 * System.out.println(allStateByCountryId); return "Hello";
	 * 
	 * }
	 */
}
