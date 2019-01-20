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

public class SecretNote implements OpalDataType {

	private int id;
	private String name;				// Name for the note
	private String encryptedNote;
	
	private String opalUser;				// Opal user account
	private String characterEncoding;
	private String cipherTransformation;
	private String aesEncryptionAlgorithm;

	private boolean modifiedFromDB;
	
	private DataEncrypter encrypter;
	
	/**
	 * Create a new SecretNote
	 */
	public SecretNote() {
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
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public String getEncryptedData() {
		return encryptedNote;
	}
	
	/**
	 * @see com.billsbackyardbees.opal.db.OpalDataType
	 */
	@Override
	public void setEncryptedData(String data) {
		// TODO: Fix hardcoded publicKey so it finds it in the table
		this.encryptedNote = encrypter.encrpytString(data, "ABCDEFGHIJKLMNOP", cipherTransformation, characterEncoding, aesEncryptionAlgorithm);
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
	public void setOpalUser(String opalUser) {
		this.opalUser = opalUser;
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
