package com.example.Pojo;

public class Signup 
{
	private int id;
	private String fullname;
	private String email;
	private String password;
	private String confirm_password;
	@Override
	public String toString() {
		return "Signup [id=" + id + ", fullname=" + fullname + ", email=" + email + ", password=" + password
				+ ", confirm_password=" + confirm_password + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	
}
