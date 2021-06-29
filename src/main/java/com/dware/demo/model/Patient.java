package com.dware.demo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 * JPA Animal object.  Includes an example of many to one relationships.
 */
@Document("patient")
public class Patient implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String patientId;
	
	
	@Field(name="FIRST_NAME")
	private String firstName;
	
	@Field(name="LAST_NAME")
	private String lastName;
	
	@Field(name="PHONE")
	private String phoneNum;
	
	@Field(name="EMAIL")
	private String email;
	
	@Field(name="ssn")
	@Indexed(unique = true)
	private String ssn;

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	
	
	
}
