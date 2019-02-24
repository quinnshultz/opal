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
package com.billsbackyardbees.opal.bean;

import java.io.IOException;
import java.io.Serializable;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.SecretKey;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.billsbackyardbees.opal.util.OpalSerializer;
import com.billsbackyardbees.opal.util.KeyGen;

/**
 * An user of this program.
 * 
 * @author Quinn Shultz
 *
 */
@Entity
@Table(name = "opalUsers")
public class OpalUser implements Serializable {

	static final long serialVersionUID = OpalSerializer.getSerialVersionUID();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column(name = "username", updatable = true, nullable = false)
	private String username;

	@Column(name = "fullName", updatable = true, nullable = true)
	private String fullName;
	
	@Column(name = "password", updatable = true, nullable = false)
	private String password;

	@Transient
	private SecretKey key;

	@Column(name = "keystore", updatable = true, nullable = false)
	private byte[] serializedKeystore;

	@Transient
	public boolean valid;

	/**
	 * Create an user of this program with blank attributes
	 */
	public OpalUser() {
		valid = false;
	}

	/**
	 * Create an user of this program
	 * 
	 * @param username User-name for new account
	 * @param password Password for user
	 * @param fullName Full name of user
	 * @throws NoSuchAlgorithmException 
	 */
	public OpalUser(String username, String password, String fullName) throws NoSuchAlgorithmException {
		this.username = username;
		this.fullName = fullName;
		this.password = password;
		this.key = KeyGen.generateKey();
		valid = false;
	}

	/**
	 * @return The Id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id The Id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return The user-name
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username The user-name to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * Checks to see if user entered the correct password
	 * 
	 * @param password Current user password
	 * @return True if password matches, false otherwise
	 */
	public boolean isLoginTrue(String password) {
		if (password == this.password) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getPassword() {
		return this.password;
	}

	/**
	 * Set the password for this encrypted object
	 * 
	 * @param oldPassword Enter last password, or null if new user
	 * @param newPassword Enter desired password
	 * @throws Exception
	 * @throws NoSuchAlgorithmException
	 */
	public void setPassword(String oldPassword, String newPassword) throws NoSuchAlgorithmException, Exception {

		if (key == null) { // Brand-new user so we don't have to ask for existing password

			this.key = KeyGen.generateKey();
			password = newPassword;

		} else { // First check to see that the user knows their former password
			if (isLoginTrue(oldPassword)) {
				this.key = KeyGen.generateKey();
				password = newPassword;

			} else {
				throw new Exception();
			}
		}
	}
	
	public byte[] getSerializedKey() {
		return key.getEncoded();
	}

	/**
	 * @return True if valid, false otherwise
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param newValid Flag showing if user is in database
	 */
	public void setValid(boolean newValid) {
		valid = newValid;
	}

}
