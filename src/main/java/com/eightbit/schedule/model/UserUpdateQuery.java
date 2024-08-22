package com.eightbit.schedule.model;

public class UserUpdateQuery {

	private int userId;
	private String lastName;
	private String firstName;
	private String tel;
//	private String mail;
	private String address;
	private String course;
	private String position;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

//	public String getMail() {
//		return mail;
//	}
//
//	public void setMail(String mail) {
//		this.mail = mail;
//	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "UserUpdateQuery [userId=" + userId + ", lastName=" + lastName + ", firstName=" + firstName + ", tel="
				+ tel +  ", address=" + address + ", course=" + course + ", position=" + position
				+ "]";
	}

}
