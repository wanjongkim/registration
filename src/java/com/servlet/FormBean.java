/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.Serializable;

/**
 *
 * @author wankim
 */
public class FormBean implements Serializable {

    private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String verifyPassword;
	private String displayName;
	private String country;
	private String city;
	private String language;
	private String securityQuestion;
	private String securityAnswer;
	private String NC_CHECK_EMAIL;
	private String NC_CHECK_OTHER;
	
	public String getNC_CHECK_EMAIL() {
		return NC_CHECK_EMAIL;
	}
	public void setNC_CHECK_EMAIL(String nC_CHECK_EMAIL) {
		NC_CHECK_EMAIL = nC_CHECK_EMAIL;
	}
	public String getNC_CHECK_OTHER() {
		return NC_CHECK_OTHER;
	}
	public void setNC_CHECK_OTHER(String nC_CHECK_OTHER) {
		NC_CHECK_OTHER = nC_CHECK_OTHER;
	}
	public boolean isValid() {
		email.trim();
		if(email.equals("")) {
			return false;
		}
		return true;
	}
	public String getVerifyPassword() {
		return verifyPassword;
	}
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
}
