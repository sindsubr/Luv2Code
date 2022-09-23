package org.sindu.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.sindu.customvalidation.CourseCode;
import org.sindu.customvalidation.ImageFileCheck;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Student {

	@NotBlank
	@Size(min = 3, max = 10, message = "Enter your Name with atleast 3 chars to 10 chars")
	private String firstName;
	@NotBlank(message = "Enter your last Name")
	@NotNull(message = "isrequired")
	private String lastName;
	private String country;
	private String course;
	private String yearsOfExp;
	@NotNull(message = "please select your gender")
	private String gender;
	private String[] skills;
	@Max(value = 10, message = "greater than 10 not allowed")
	@Min(value = 1, message = "-ve value not allowed")
	private Integer freePasses;
	@Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", message = "Email should be in correct format")
	private String email;

	@CourseCode
	private String courseCode;
	@Past(message = "Enter your valid Birthday")
	public Date birthday;

	private List<String> courseList;
	private Map<String, String> genderMap;
	@ImageFileCheck
	private CommonsMultipartFile profilePic;

	public Student() {
		courseList = new ArrayList<>();
		courseList.add("CSE");
		courseList.add("EEE");
		courseList.add("ECE");
		courseList.add("Mech");

		genderMap = new LinkedHashMap<String, String>();
		genderMap.put("Male", "Male");
		genderMap.put("Female", "Female");
	}

	public Map<String, String> getGenderMap() {
		return genderMap;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getYearsOfExp() {
		return yearsOfExp;
	}

	public void setYearsOfExp(String yearsOfExp) {
		this.yearsOfExp = yearsOfExp;
	}

	public List<String> getCourseList() {
		return courseList;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public CommonsMultipartFile getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(CommonsMultipartFile profilePic) {
		this.profilePic = profilePic;
	}

}
