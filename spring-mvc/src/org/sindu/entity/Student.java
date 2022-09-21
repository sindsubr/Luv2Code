package org.sindu.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String course;
	private String yearsOfExp;
	private String gender;
	private String[] skills;

	private List<String> courseList;

	public Student() {
		courseList = new ArrayList<>();
		courseList.add("CSE");
		courseList.add("EEE");
		courseList.add("ECE");
		courseList.add("Mech");
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
	
}
