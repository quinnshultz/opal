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

import com.billsbackyardbees.opal.db.DatabaseDriver;

/**
 * Uses the DatabaseDriver to load instantiable OpalDataType(s) to the MySQL database.
 * Every method checks with OpalUserAuthenticator to see if you have authenticated to a database table.
 * 
 * @author Quinn Shultz
 */
public class DataLoader {

	private DatabaseDriver opalConnection;
	
	/**
	 * Creates a new DataLoader
	 */
	public DataLoader() {
		opalConnection = new DatabaseDriver();
	}
	
	/**
	 * Uploads a PasswordAccount to a MySQL database table
	 * @param passwordAccount The PasswordAccount Object to upload
	 */
	public void UploadPasswordAccount(PasswordAccount passwordAccount) {
		opalConnection.executeStatement("CALL add_account('" + passwordAccount.getName() + "', '" + passwordAccount.getOpalUser() + "', '"
				+ passwordAccount.getUrl() + "', '" + passwordAccount.getUsername() + "', '" + passwordAccount.getEncryptedData() + "', '"
				+ passwordAccount.getNotes() + "', '" + passwordAccount.getCharacterEncoding() + "', '" + passwordAccount.getCipherTransformation() + "', '"
				+ passwordAccount.getAesEncryptionAlgorithm() + "');");
	}
	
	/**
	 * Deletes a PasswordAccount from a MySQL database table
	 * @param passwordAccount The PasswordAccount Object to delete
	 */
	public void DeletePasswordAccount(PasswordAccount passwordAccount) {
		opalConnection.executeStatement("CALL remove_account('" + passwordAccount.getName() + "', '" + passwordAccount.getOpalUser() + "');");
	}
	
	/**
	 * Gets the id and primary key of a entry in the opalUsers table
	 * @param username The username of the opal account holder
	 */
	public int getOpalUserId(String username) {
		// TODO: Get id from username
		return 0;
	}
	
	

}
