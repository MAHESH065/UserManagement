package com.mahesh.binding;

import java.util.Date;

import lombok.Data;

@Data
public class UserRegForm {
	
	private String firstName;
	private String lastName;
	private String email;
	private Long phNo;
	private Date dob;
	private String gender;
	private Integer country;
	private Integer state;
	private Integer city;
	private String tempPassword;
	private String accountStatus;
	

}
