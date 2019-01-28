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

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.billsbackyardbees.opal.util.DataEncrypter;
import com.billsbackyardbees.opal.util.OpalSerializer;

/**
 * Best to think of this as a java password or account object that corresponds or will correspond
 * to a tuple in the account database.
 * @author Quinn Shultz
 *
 */
@Entity
public class PasswordAccount implements OpalDataType {
	
	private static final long serialVersionUID = OpalSerializer.getSerialVersionUID();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", updatable = false, nullable = false)
	private int id;

	@Column(name="url", updatable = true, nullable = true)
	private String url;
	
	// Name for the account
	@Column(name="name", updatable = true, nullable = false)
	private String name;
	
	// Account username credential
	@Column(name="username", updatable = true, nullable = false)
	private String username;
	
	@Column(name="encryptedPassword", updatable = true, nullable = false)
	private String encryptedPassword;
	
	@Column(name="notes", updatable = true, nullable = true)
	private String notes;
	
	@Column(name="characterEncoding", updatable = true, nullable = false)
	private String characterEncoding;
	
	@Column(name="cipherTransformation", updatable = true, nullable = false)
	private String cipherTransformation;
	
	@Column(name="aesEncryptionAlgorithm", updatable = true, nullable = false)
	private String aesEncryptionAlgorithm;

	@Transient
	private boolean modifiedFromDB;
	
	@Transient
	// Opal user account
	private String opalUser;
	
	@Transient
	private DataEncrypter encrypter;
	
	/**
	 * Create a new credential account, may then be populated with a stored account from the database,
	 * or completed with new information and stored to the database.
	 */
	public PasswordAccount() {
		id = -1;
		characterEncoding = "UTF-8";
		cipherTransformation = "AES/CBC/PKCS5PADDING";
		aesEncryptionAlgorithm = "AES";
		encrypter = new DataEncrypter();
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
	public String getEncryptedData() {
		return encryptedPassword;
	}
	
	public String getData(String masterPassword) {
		String data = encrypter.decryptString(encryptedPassword, masterPassword, cipherTransformation, characterEncoding, aesEncryptionAlgorithm);
		return data;
	}
	
	/**
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public void setEncryptedData(String data, String masterPassword) {
		// TODO: Fix hardcoded publicKey so it finds it in the table
		this.encryptedPassword = encrypter.encryptString(data, masterPassword, cipherTransformation, characterEncoding, aesEncryptionAlgorithm);
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
	public String getOpalUser() {
		return opalUser;
	}

	/**
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public void setOpalUser(String opalname) {
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
