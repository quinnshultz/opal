/*
 * Copyright (c) 2019 Quinn Shultz <vanoxite@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.backyardbees.opal.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * An user of this program.
 * @author Quinn Shultz
 *
 */
public class OpalUser {

	private String email;
	private String fullName;
	private String password;
	
	private List<String> roles;
	
	/**
	 * Create an user of this program with blank attributes
	 */
	public OpalUser() {

	}
	
	/**
	 * Create an user of this program
	 * 
	 * @param email Email address and user-name for new account
	 * @param password Password for user
	 * @param fullName Full name of user
	 * @param roles List of 
	 */
	public OpalUser(String email, String password, String fullName, String... roles) {
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		
		this.roles = new ArrayList<String>();
		if (roles != null) {
			for (String r : roles) {
				this.roles.add(r);
			}
		}
	}

	/**
	 * @return The email address
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email The email address to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return The full name
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName The full name to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return The password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password The password to set
	 */
	public void setPublicKey(String publicKey) {
		this.password = publicKey;
	}
	
	/**
	 * @return The roles
	 */
	public List<String> getRoles() {
		return roles;
	}
	
	/**
	 * @param roles The roles to set
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
