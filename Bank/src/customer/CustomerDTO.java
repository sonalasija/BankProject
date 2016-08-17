package customer;

import java.sql.Date;

public class CustomerDTO {
	
	private String fName,lName,email,street,city,picture;
	private java.sql.Date dob;
	private long phone,zip;
	public CustomerDTO(String fName, String lName, String email, String street,
			String city, java.sql.Date doB, String picture, long phone, long zip) {
		
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.street = street;
		this.city = city;
		this.dob = doB;
		this.picture = picture;
		this.phone = phone;
		this.zip = zip;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public long getZip() {
		return zip;
	}
	public void setZip(long zip) {
		this.zip = zip;
	}
	
	

}
