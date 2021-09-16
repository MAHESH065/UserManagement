package com.mahesh.service;

import java.util.Map;

import com.mahesh.binding.LoginForm;
import com.mahesh.binding.UnlockAccountForm;
import com.mahesh.binding.UserRegForm;

public interface UserService {

	// For Login Functionality
	public String loginUser(LoginForm loginForm);

	// For User Registration Functionality
	public Map<Integer, String> findAllCountries();
	public Map<Integer, String> findAllStates(Integer countryId);
	public Map<Integer, String> findAllCities(Integer stateId);
	public boolean checkUniqueEmail(String email);
	public boolean saveUser(UserRegForm userRegForm);

	// For Un-Lock Account Functionality
	public boolean checkTempPwdValid(String email, String tempPwd);
	public boolean unlockAccount(UnlockAccountForm unlockAccountForm);
	
	//For Forgot Password Functionality
	public String forgotPassword(String email);

}
