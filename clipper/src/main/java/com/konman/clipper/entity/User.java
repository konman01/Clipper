package com.konman.clipper.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_detail")
public class User {
	
	// // Class Literals Mapped to user_detail SQL table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name= "last_name")
	private String lastName;
	
	@Column(name= "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_detail_id")
	private Contact contactDetail;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<ClipperCard> clipperCards;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_detail_id")
	private Account account;
	
	// Constructors
	public User() {
		
	}

	public User(String firstName, String lastName, String email, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	// Getters and Setters
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

	public Contact getContactDetail() {
		return contactDetail;
	}

	public void setContactDetail(Contact contactDetail) {
		this.contactDetail = contactDetail;
	}

	public List<ClipperCard> getClipperCards() {
		return clipperCards;
	}

	public void setClipperCards(List<ClipperCard> clipperCards) {
		this.clipperCards = clipperCards;
	}
	
	public void addCard(ClipperCard theClipperCard) {
		
		if(clipperCards == null) {
			clipperCards = new ArrayList<ClipperCard>();
		}
		clipperCards.add(theClipperCard);
		theClipperCard.setUser(this);
	}


	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", contactDetail=" + contactDetail + "]";
	}

	
	

}
