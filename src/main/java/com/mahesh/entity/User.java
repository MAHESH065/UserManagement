package com.mahesh.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity(name = "user_dtls")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String email;
	
	@Column(name = "ph_no")
	private Long phNo;
	
	private Date dob;
	
	private String gender;
	
	private Integer country;
	
	private Integer state;
	
	private Integer city;
	
	@Column(name = "temp_pwd")
	private String tempPassword;
	
	@Column(name = "account_status")
	private String accountStatus;
	
	@Column(name = "created_date", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name = "updated_date", insertable = false)
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
}
