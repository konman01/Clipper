package com.konman.clipper.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


//@EqualsAndHashCode(callSuper = false)
public class ContactJSON implements Serializable{
	
	@JsonProperty("Id")
	private int Id;
	
	@JsonProperty("line1")
	private String line1;
	
	@JsonProperty("line2")
	private String line2;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("zip")
	private String zip;
	
	public ContactJSON() {
		
	}
	
	public ContactJSON(String line1, String line2, String city, String state, String zip) {
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "ContactJSON [line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", state=" + state + ", zip="
				+ zip + "]";
	}

	
	
}
