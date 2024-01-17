package com.sabanciuniv.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	@Id private String id;

	private String name;
	private String age;
	private String NativeLang;
	private String DesiredLang;
	
	
	public User(String name, String age, String id, String nativeLang, String desiredLang) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
		this.NativeLang = nativeLang;
		this.DesiredLang = desiredLang;
	}
	
	
	public User() {
		
	}

	public String getUserName() {
		return name;
	}

	public void setUserName(String userName) {
		this.name = userName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNativeLang() {
		return NativeLang;
	}

	public void setNativeLang(String nativeLang) {
		this.NativeLang = nativeLang;
	}

	public String getDesiredLang() {
		return DesiredLang;
	}

	public void setDesiredLang(String desiredLang) {
		this.DesiredLang = desiredLang;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	
}
