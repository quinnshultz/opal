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

import java.io.Serializable;

/**
 * Defines an Object type that is perfectly compatible with the Opal database
 * tables.
 * 
 * @author Quinn Shultz
 */
public interface OpalDataType extends Serializable {

	/**
	 * All classes that implement this interface are Objects that correspond to
	 * tuples in the RDBMS. The id is the primary key of all tables. It has option
	 * auto increment so there will not be a java method to set the id.
	 * 
	 * @return id and primary key of tuple
	 */
	public int getId();

	/**
	 * Sets the name of this Object, corresponding to a column entry in the
	 * database.
	 * 
	 * @param name Name of this Object
	 */
	public void setName(String name);

	/**
	 * Gets the name of this Object, corresponding to a column entry in the
	 * database.
	 * 
	 * @return Name of this Object
	 */
	public String getName();

	/**
	 * Sets obfuscated data to be stored in this Object and synced to the database.
	 * 
	 * @param data Plain-text data to be encrypted with the user's public key and
	 * 				stored in the database
	 * @param masterPassword The user's provided password
	 */
	public void setEncryptedData(String data, String masterPassword);

	/**
	 * Gets obfuscated data that may be deciphered with the user's private key.
	 * 
	 * @return Encrypted data
	 */
	public String getEncryptedData();

	/**
	 * Sets the owner of this Object, corresponding to the primary key of a tuple in
	 * the opalUsers table.
	 * 
	 * @param opalUser Integer id and primary key of account tuple in opalUsers
	 */
	public void setOpalUser(String opalUser);

	/**
	 * Gets the owner of this Object, corresponding to the primary key of a tuple in
	 * the opalUsers table.
	 * 
	 * @return Integer id and primary key of account tuple in opalUsers
	 */
	public String getOpalUser();

	/**
	 * 
	 * @return true if Object parameters have changed since being stored as a tuple,
	 *         false otherwise
	 */
	public boolean isModifiedFromDB();

	/**
	 * 
	 * @param modifed true if Object parameters have changed since being stored as a
	 *                tuple, false otherwise
	 */
	public void setModifiedFromDB(boolean modifed);
}
