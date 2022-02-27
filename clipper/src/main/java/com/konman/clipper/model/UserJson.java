package com.konman.clipper.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserJson implements Serializable{
	
	@JsonProperty("Id")
	private int Id;
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	@JsonProperty("contact_detail")
	private ContactJSON contactCreateJson;
	
	public UserJson() {
		
	}
	

	public UserJson(String firstName, String lastName, String email, String phoneNumber,
			ContactJSON contactCreateJson) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.contactCreateJson = contactCreateJson;
	}
	
	

	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public ContactJSON getContactCreateJson() {
		return contactCreateJson;
	}


	public void setContactCreateJson(ContactJSON contactCreateJson) {
		this.contactCreateJson = contactCreateJson;
	}


	@Override
	public String toString() {
		return "UserJson [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", contactCreateJson=" + contactCreateJson + "]";
	}
	
	


}
