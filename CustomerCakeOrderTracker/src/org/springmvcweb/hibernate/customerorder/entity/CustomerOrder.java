package org.springmvcweb.hibernate.customerorder.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springmvcweb.hibernate.customerorder.util.DateUtils;
import org.springmvcweb.hibernate.customerorder.validator.ImageTypeCheck;

@Entity
@Table(name = "customer_order")
public class CustomerOrder{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;
	
	@NotBlank(message = "is required")
	@Size(min=3,max=20,message = "Incorrect size.. (not less than 3 and more than 20)")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "is required")
	@Size(min=3,max=20,message = "Incorrect size.. (not less than 3 and more than 20)")
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "is required")
	@Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$",message = "Please enter your valid email format as like **example.gmail.com**")
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile_no")
	@Pattern(regexp = "^[0-9]{10}",message = "Enter Valid mobile number")
	private String mobileNo;
	
	@PastOrPresent(message = "Please Enter Valid Birthday")
	@Column(name = "dob",columnDefinition = "DATE")
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@NotBlank(message = "is required")
	@Column(name = "address")
	private String address;
	
	@NotBlank(message = "is required")
	@Column(name = "city")
	private String city;

	@NotBlank(message = "is required")
	@Column(name = "cake_flavor")
	private String cakeFlavor;
	
	@Column(name = "cake_model")
	@Lob
	@ImageTypeCheck(message ="Invalid Image")	
	private byte[] cakeModel;
	
	@Column(name = "kg")
	@Max(value = 20,message = "Max 20 kg allowed..!")
	private int kg;
	
	@Column(name = "amount")
	private int amount;
	
	@NotBlank
	@Column(name = "mode_of_payment")
	private String modeOfPayment;
	
	@Autowired
	@ManyToOne(cascade = {CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH,
			CascadeType.REMOVE
			})
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public CustomerOrder() {
	}

	public CustomerOrder(String firstName, String lastName, String email, String mobileNo, Date dob,
			String address, String city, String cakeFlavor, byte[] cakeModel, int kg, int amount, String modeOfPayment) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.cakeFlavor = cakeFlavor;
		this.cakeModel = cakeModel;
		this.kg = kg;
		this.amount = amount;
		this.modeOfPayment = modeOfPayment;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCakeFlavor() {
		return cakeFlavor;
	}

	public void setCakeFlavor(String cakeFlavor) {
		this.cakeFlavor = cakeFlavor;
	}

	public byte[] getCakeModel() {
		return cakeModel;
	}

	public void setCakeModel(byte[] cakeModel) {
		this.cakeModel = cakeModel;
	}

	public int getKg() {
		return kg;
	}

	public void setKg(int kg) {
		this.kg = kg;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerOrder [ firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", dob=" + DateUtils.format(dob) + ", address=" + address + ", city=" + city
				+ ", cakeFlavor=" + cakeFlavor + ", cakeModel=" + cakeModel + ", kg=" + kg + ", amount=" + amount
				+ ", modeOfPayment=" + modeOfPayment + "]";
	}
}
