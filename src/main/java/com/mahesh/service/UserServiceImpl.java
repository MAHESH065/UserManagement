package com.mahesh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.binding.LoginForm;
import com.mahesh.binding.UnlockAccountForm;
import com.mahesh.binding.UserRegForm;
import com.mahesh.constant.AppConstant;
import com.mahesh.entity.City;
import com.mahesh.entity.Country;
import com.mahesh.entity.State;
import com.mahesh.entity.User;
import com.mahesh.props.AppProps;
import com.mahesh.repository.CityRepository;
import com.mahesh.repository.CountryRepository;
import com.mahesh.repository.StateRepository;
import com.mahesh.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private AppProps props;
	
	@Override
	public String loginUser(LoginForm loginForm) {
		User userObj = userRepository.findByEmail(loginForm.getEmail());

		Map<String, String> messages = props.getMessages();

		if (userObj != null) {
			return messages.get(AppConstant.ACCOUNT_UNLOCK);
		}
		return messages.get(AppConstant.CREDENTIAL_INVALID);
	}

	@Override
	public Map<Integer, String> findAllCountries() {
		
		List<Country> countryList = countryRepository.findAll();
		
		Map<Integer, String> countries = new HashMap<>();
		for (Country country : countryList) {
			countries.put(country.getCountryId(), country.getCountryName());
		}
		return countries;
	}

	@Override
	public Map<Integer, String> findAllStates(Integer countryId) {
		List<State> stateList = stateRepository.findByCountryId(countryId);

		Map<Integer, String> states = new HashMap<>();
		for (State state : stateList) {
			states.put(state.getStateId(), state.getStateName());
		}
		return states;
	}

	@Override
	public Map<Integer, String> findAllCities(Integer stateId) {
		List<City> cityList = cityRepository.findByStateId(stateId);

		Map<Integer, String> cities = new HashMap<>();
		for (City city : cityList) {
			cities.put(city.getCityId(), city.getCityName());
		}
		return cities;
	}

	@Override
	public boolean checkUniqueEmail(String email) {
		User userObj = userRepository.findByEmail(email);
		return userObj.getEmail() == null;
	}

	@Override
	public boolean saveUser(UserRegForm userRegForm) {
		userRegForm.setTempPassword(PasswowrdGenerator());
		userRegForm.setAccountStatus("Locked");

		try {
			User user = new User();
			BeanUtils.copyProperties(userRegForm, user);

			user = userRepository.save(user);

			BeanUtils.copyProperties(user, userRegForm);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public String PasswowrdGenerator() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String randomPwd = "";
		int length = 6;

		Random rand = new Random();

		char[] chars = new char[length];
		for (int i = 0; i < length; i++) {
			chars[i] = characters.charAt(rand.nextInt(characters.length()));
		}

		System.out.println(chars.toString());

		for (int i = 0; i < chars.length; i++) {
			randomPwd += chars[i];
		}

		System.out.println("Password :: " + randomPwd);
		return randomPwd;
	}

	@Override
	public boolean checkTempPwdValid(String email, String tempPassword) {
		User userObj = userRepository.findByEmailAndTempPassword(email, tempPassword);
		if(userObj != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean unlockAccount(UnlockAccountForm unlockAccountForm) {
		User userObj = userRepository.findByEmail(unlockAccountForm.getEmail());
		
		if(userObj == null) {
			userObj = new User();
			UserRegForm userRegForm = new UserRegForm();
			userRegForm.setTempPassword(PasswowrdGenerator());
			userRegForm.setAccountStatus("Locked");
			
			BeanUtils.copyProperties(userRegForm, userObj);
			userObj = userRepository.save(userObj);
			
			BeanUtils.copyProperties(userObj, userRegForm);
		}else {
			BeanUtils.copyProperties(unlockAccountForm, userObj);
			
		}
		
		

		return false;
		
		
	}

	@Override
	public String forgotPassword(String email) {
		User userObj = userRepository.findByEmail(email);
		if(userObj != null)
		{
			return userObj.getTempPassword();
		}
		return null;
	}
	
}
