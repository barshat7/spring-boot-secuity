package com.techstack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {

	@Id @GeneratedValue
	private int roledId;
	private String role;
	/**
	 * @return the roledId
	 */
	public int getRoledId() {
		return roledId;
	}
	/**
	 * @param roledId the roledId to set
	 */
	public void setRoledId(int roledId) {
		this.roledId = roledId;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
