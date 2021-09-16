package com.mahesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForgotPasswordController {
	
	@GetMapping("/forgot")
	public String loadForgotPwdForm() {
		return "forgot_password-page";
	}
}
