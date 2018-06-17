package com.techstack.model;

public class JwtUser {

	private String userName;
	private Long id;
	private String role;
	
	public void setUserName(String userName) {
		
		this.userName=userName;
	}
	public void setId(Long id) {
		
		this.id=id;
	}
	public void setRole(String string) {
		
		this.role = role;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	

}
