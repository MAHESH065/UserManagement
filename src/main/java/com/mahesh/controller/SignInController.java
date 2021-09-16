package com.mahesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {
	
	@GetMapping("/")
	public String loadSingInPage() {
		return "sign_in-page";
	}
}
