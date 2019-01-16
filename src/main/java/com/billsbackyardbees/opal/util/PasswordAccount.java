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
package com.billsbackyardbees.opal.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.billsbackyardbees.opal.db.OpalDataType;

/**
 * Best to think of this as a java password or account object that corresponds or will correspond
 * to a tuple in the account database.
 * @author Quinn Shultz
 *
 */
public class PasswordAccount implements OpalDataType {
	
	private int id;
	private String url;
	private String name;				// Name for the account
	private String username;			// Account username credential
	private String encryptedPassword;
	private String notes;
	
	private int opalUser;				// Opal user account
	private String characterEncoding;
	private String cipherTransformation;
	private String aesEncryptionAlgorithm;

	private boolean modifiedFromDB;
	
	/**
	 * Create a new credential account, may then be populated with a stored account from the database,
	 * or completed with new information and stored to the database.
	 */
	public PasswordAccount() {
		
	}
	
	/**
	 * Sets instance variables equal to specified account in database
	 * 
	 * @param accountID ID number corresponding to stored account in table: username_accounts
	 */
	public void retrieveFromDB(int accountID) {
		
	}

	/**
	 * @return the id
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the encrypted password
	 */
	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	/**
	 * @return the opal account name this belongs to
	 */
	public int getOpalName() {
		return opalUser;
	}

	/**
	 * @param opalname the opal account these stored credentials belong to
	 */
	public void setOpalName(int opalname) {
		this.opalUser = opalname;
	}

}
