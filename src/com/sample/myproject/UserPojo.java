package com.sample.myproject;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class UserPojo {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}
	
	@Persistent
	private String username;
	
	@Persistent
	private String email;
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username ) {
		this.username = username;
	}

	public String getEmail(){
		return this.email;
		
	}
   public void setEmail(String email){
	   this.email= email;
   }
}


