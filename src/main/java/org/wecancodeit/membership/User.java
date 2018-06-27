package org.wecancodeit.membership;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	
	private String username;
	private String hashword;

	// Constructor
	public User() {
		// for JPA
	}
	
	public User(String username, String hashword) {
		this.username = username;
		this.hashword = hashword;
	}
	
	// Getters
	public String getUsername() {
		return username;
	}
	
	public String getHashword() {
		return hashword;
	}

	public long getId() {
		return id;
	}

	
} // End User()
