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
	 * @see com.billsbackyardbees.opal.db.OpalDataType
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
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
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
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public int getOpalUser() {
		return opalUser;
	}

	/**
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public void setOpalUser(int opalname) {
		this.opalUser = opalname;
		modifiedFromDB = true;
	}

	/**
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public String getCharacterEncoding() {
		return characterEncoding;
	}

	/**
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public void setCharacterEncoding(String characterEncoding) {
		this.characterEncoding = characterEncoding;
		modifiedFromDB = true;
	}

	/**
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public String getCipherTransformation() {
		return cipherTransformation;
	}

	/**
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public void setCipherTransformation(String cipherTransformation) {
		this.cipherTransformation = cipherTransformation;
		modifiedFromDB = true;
	}

	/**
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public String getAesEncryptionAlgorithm() {
		return aesEncryptionAlgorithm;
	}

	/**
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public void setAesEncryptionAlgorithm(String aesEncryptionAlgorithm) {
		this.aesEncryptionAlgorithm = aesEncryptionAlgorithm;
		modifiedFromDB = true;
	}

	/**
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public boolean isModifiedFromDB() {
		return modifiedFromDB;
	}
	
	/**
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public void setModifiedFromDB(boolean modified) {
		this.modifiedFromDB = modified;
	}

}
