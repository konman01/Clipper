package com.konman.clipper.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	@JsonProperty("contact_detail")
	private ContactDTO contactDetailDto;
	
	@JsonProperty("clipper_cards")
	private List<ClipperCardDTO> clipperCardsDto;
	
	public UserDTO() {
		
	}

	public UserDTO(String firstName, String lastName, String email, String phoneNumber,
			ContactDTO contactDetailDto, List<ClipperCardDTO> clipperCardsDto) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.contactDetailDto = contactDetailDto;
		this.clipperCardsDto = clipperCardsDto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public ContactDTO getContactDetailDto() {
		return contactDetailDto;
	}

	public void setContactDetailDto(ContactDTO contactDetailDto) {
		this.contactDetailDto = contactDetailDto;
	}

	public List<ClipperCardDTO> getClipperCardsDto() {
		return clipperCardsDto;
	}

	public void setClipperCardsDto(List<ClipperCardDTO> clipperCardsDto) {
		this.clipperCardsDto = clipperCardsDto;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", contactDetailDto=" + contactDetailDto + ", clipperCardsDto="
				+ clipperCardsDto + "]";
	}
	
}
