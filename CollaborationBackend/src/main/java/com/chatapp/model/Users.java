package com.chatapp.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Users {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;

private String name;
private String password;
private String address;
private String dateofbirth;
private String role;
private String email;
private String contact;

@Transient	
private String imageData;
@Transient
private MultipartFile file;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getDateofbirth() {
	return dateofbirth;
}
public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getImageData() {
	return imageData;
}
public void setImageData(String imageData) {
	this.imageData = imageData;
}
public MultipartFile getFile() {
	return file;
}
public void setFile(MultipartFile file) {
	this.file = file;
}



	
	
	
}

