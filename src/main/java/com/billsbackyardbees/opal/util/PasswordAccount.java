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
		id = -1;
		characterEncoding = "UTF-8";
		cipherTransformation = "AES/CBC/PKCS5PADDING";
		aesEncryptionAlgorithm = "AES";
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
		modifiedFromDB = true;
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
		modifiedFromDB = true;
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
		modifiedFromDB = true;
	}
	
	/**
	 * @return the encrypted password
	 */
	public String getPassword() {
		return encryptedPassword;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.encryptedPassword = password;
		modifiedFromDB = true;
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
		modifiedFromDB = true;
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
		modifiedFromDB = true;
	}

	/**
	 * @return the characterEncoding
	 */
	public String getCharacterEncoding() {
		return characterEncoding;
	}

	/**
	 * @param characterEncoding the characterEncoding to set
	 */
	public void setCharacterEncoding(String characterEncoding) {
		this.characterEncoding = characterEncoding;
		modifiedFromDB = true;
	}

	/**
	 * @return the cipherTransformation
	 */
	public String getCipherTransformation() {
		return cipherTransformation;
	}

	/**
	 * @param cipherTransformation the cipherTransformation to set
	 */
	public void setCipherTransformation(String cipherTransformation) {
		this.cipherTransformation = cipherTransformation;
		modifiedFromDB = true;
	}

	/**
	 * @return the aesEncryptionAlgorithm
	 */
	public String getAesEncryptionAlgorithm() {
		return aesEncryptionAlgorithm;
	}

	/**
	 * @param aesEncryptionAlgorithm the aesEncryptionAlgorithm to set
	 */
	public void setAesEncryptionAlgorithm(String aesEncryptionAlgorithm) {
		this.aesEncryptionAlgorithm = aesEncryptionAlgorithm;
		modifiedFromDB = true;
	}

	/**
	 * @return the modifiedFromDB
	 */
	public boolean isModifiedFromDB() {
		return modifiedFromDB;
	}

	/**
	 * @param modifiedFromDB the modifiedFromDB to set
	 */
	public void setModifiedFromDB(boolean modifiedFromDB) {
		this.modifiedFromDB = modifiedFromDB;
	}
	
	

}
