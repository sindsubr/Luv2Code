package org.springmvcjavaconfig.bakery.entity;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springmvcjavaconfig.bakery.validator.ImageType;

public class CustomerOrder {

	@NotNull(message = "please enter your First Name")
	@NotBlank
	@Size(min = 3,max = 20,message = "3 to 20 chars allowed")
	private String firstName;
	@NotNull(message = "please enter your Last Name")
	@NotBlank
	@Size(min = 3,max = 20,message = "3 to 20 chars allowed")
	private String lastName;
	@PastOrPresent(message = "please enter your valid DOB")
	private Date dob;
	@Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$",message = "Please enter your valid email format as like **example.gmail.com**")
	private String email;
	private String deliveryAddress;
	private String state;
	private String pincode;
	private String country;
	private String countryCode;
	@NotNull
	@Pattern(regexp = "^[0-9]{10}",message = "please Enter valid mobile number")
	private String mobileNo;
	private String cakeFlavour;
	@ImageType
	private CommonsMultipartFile cakeTheme;
	@Max(value = 20,message = "please order maximum of 20kg")
	private String kg;
	@NotNull(message = "please select mode of payment")
	private String payment;

	private Map<String, String> countryMap;
	
	public Map<String, String> getCountryMap() {
		return countryMap;
	}
	public CustomerOrder(){
		countryMap = new LinkedHashMap<String, String>();
		countryMap.put("India", "India");
		countryMap.put("UAE", "UAE");
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCakeFlavour() {
		return cakeFlavour;
	}

	public void setCakeFlavour(String cakeFlavour) {
		this.cakeFlavour = cakeFlavour;
	}

	public CommonsMultipartFile getCakeTheme() {
		return cakeTheme;
	}

	public void setCakeTheme(CommonsMultipartFile cakeTheme) {
		this.cakeTheme = cakeTheme;
	}

	public String getKg() {
		return kg;
	}

	public void setKg(String kg) {
		this.kg = kg;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

}
