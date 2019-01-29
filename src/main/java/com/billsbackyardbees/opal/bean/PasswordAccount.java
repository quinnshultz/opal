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
 * An user-name with an encrypted password.
 * 
 * @author Quinn Shultz
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
	private byte[] encryptedPassword;
	
	@Column(name="notes", updatable = true, nullable = true)
	private String notes;

	@Transient
	private boolean modifiedFromDB;
	
	@Transient
	// Opal user account
	private String opalUser;
	
	/**
	 * Create a new credential account, may then be populated with a stored account from the database,
	 * or completed with new information and stored to the database.
	 */
	public PasswordAccount() {
		
	}
	
	/**
	 * Create a new credential account with specified parameters.
	 */
	public PasswordAccount(String name, String URL, String username) {
		// TODO: Complete this constructor
		this.name = name;
		this.url = URL;
		this.username = username;
	}

	/**
	 * @see com.billsbackyardbees.opal.bean.OpalDataType
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
	 * @see com.billsbackyardbees.opal.bean.OpalDataType
	 */
	@Override
	public byte[] getEncryptedData() {
		return encryptedPassword;
	}
	
	/**
	 * @see com.billsbackyardbees.opal.bean.OpalDataType
	 */
	@Override
	public void setEncryptedData(String data, byte[] key) {
		this.encryptedPassword = DataEncrypter.encryptString(data, key).getBytes();
		modifiedFromDB = true;
	}

	/**
	 * @see com.billsbackyardbees.opal.bean.OpalDataType
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @see com.billsbackyardbees.opal.bean.OpalDataType
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
	 * @see com.billsbackyardbees.opal.bean.OpalDataType
	 */
	@Override
	public String getOpalUser() {
		return opalUser;
	}

	/**
	 * @see com.billsbackyardbees.opal.bean.OpalDataType
	 */
	@Override
	public void setOpalUser(String opalname) {
		this.opalUser = opalname;
		modifiedFromDB = true;
	}

	/**
	 * @see com.billsbackyardbees.opal.bean.OpalDataType
	 */
	@Override
	public boolean isModifiedFromDB() {
		return modifiedFromDB;
	}
	
	/**
	 * @see com.billsbackyardbees.opal.bean.OpalDataType
	 */
	@Override
	public void setModifiedFromDB(boolean modified) {
		this.modifiedFromDB = modified;
	}

}
