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

	@Transient
	private KeyStore keystore;

	@Column(name = "keystore", updatable = true, nullable = false)
	private byte[] serializedKeystore;

	@Transient
	public boolean valid;

	/**
	 * Create an user of this program with blank attributes
	 */
	public OpalUser() {

	}

	/**
	 * Create an user of this program
	 * 
	 * @param username User-name for new account
	 * @param password Password for user
	 * @param fullName Full name of user
	 */
	public OpalUser(String username, String password, String fullName) {
		this.username = username;
		this.fullName = fullName;

		char[] keystorePassword = password.toCharArray();

		// Generate a SecretKey and load it into the password
		// protected KeyStore
		try {
			this.keystore = KeyStore.getInstance("AES");
			keystore.load(null, keystorePassword);
			SecretKey sKey = KeyGen.generateKey();

			KeyStore.SecretKeyEntry ske = new KeyStore.SecretKeyEntry(sKey);
			KeyStore.ProtectionParameter pp = new KeyStore.PasswordProtection(keystorePassword);
			keystore.setEntry("secretkey", ske, pp);
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return The Id
	 */
	public int getId() {
		return id;
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
		char[] keystorePassword = password.toCharArray();
		try {
			keystore.getKey("secretkey", keystorePassword);
		} catch (UnrecoverableKeyException e) {
			// Password is incorrect
			return false;
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Set the password for this encrypted object
	 * 
	 * @param oldPassword Enter last password, or null if new user
	 * @param newPassword Enter desired password
	 * @throws IOException
	 * @throws CertificateException
	 * @throws NoSuchAlgorithmException
	 */
	public void setPassword(String oldPassword, String newPassword)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		char[] keystorePassword = newPassword.toCharArray();

		if (keystore == null) { // Brand-new user so we don't have to ask for existing password

			this.keystore = KeyStore.getInstance("AES");
			keystore.load(null, keystorePassword);

			SecretKey sKey = KeyGen.generateKey();

			KeyStore.SecretKeyEntry ske = new KeyStore.SecretKeyEntry(sKey);
			KeyStore.ProtectionParameter pp = new KeyStore.PasswordProtection(keystorePassword);
			keystore.setEntry("secretkey", ske, pp);

		} else { // First check to see that the user knows their former password
			if (isLoginTrue(oldPassword)) {
				this.keystore.deleteEntry("secretkey");
				
				this.keystore = KeyStore.getInstance("AES");
				keystore.load(null, keystorePassword);

				SecretKey sKey = KeyGen.generateKey();

				KeyStore.SecretKeyEntry ske = new KeyStore.SecretKeyEntry(sKey);
				KeyStore.ProtectionParameter pp = new KeyStore.PasswordProtection(keystorePassword);
				keystore.setEntry("secretkey", ske, pp);

			} else {
				// User entered an incorrect previous password
			}
		}
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
