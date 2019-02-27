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
package com.quinnshultz.opal.db;

import java.sql.*;

import com.quinnshultz.opal.bean.OpalUser;
import com.quinnshultz.opal.bean.PasswordAccount;

/**
 * Methods to use PasswordAccount beans with the database
 * 
 * @author Quinn Shultz
 */
public class PasswordAccountDAO {
	
	private Connection currentCon;
	
	/**
	 * Connect to the MySQL Database
	 * @throws SQLException if a database access error occurs
	 */
	public void connect() throws SQLException {
		disconnect();
		currentCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/opalPasswordManager", "jdbcopal", "Nth@Z8giog5uL3tD");
		currentCon.setAutoCommit(false);
	}
	
	/**
	 * Disconnect from the MySQL Database
	 * @throws SQLException if a database access error occurs
	 */
	public void disconnect() throws SQLException {
		if (null != currentCon) {
			currentCon.close();
			currentCon = null;
		}
	}

	/**
	 * See if a PasswordAccount can be found in the database
	 * 
	 * @param currentUser The OpalUser account table to search, also the currentSessionAttribute
	 * @param passwordAccount The PasswordAccount (with valid name)
	 * @return If passwordAccount exists, the same PasswordAccount is returned with its data initialized
	 */
	public PasswordAccount findAccount(OpalUser currentUser, PasswordAccount passwordAccount) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		
		String name = passwordAccount.getName();
		String opalname = passwordAccount.getOpalUser();

		String searchQuery = "select * from " 
		+ opalname 
		+ "_accounts where name='" 
		+ name 
		+ "'";
		
		try {
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			if (!more) {
				currentCon.rollback();
				return null;
			}
			
			int id = rs.getInt("id");
			String url = rs.getString("url");
			String username = rs.getString("username");
			byte[] encryptedPass = rs.getBytes("encryptedPassword");
			String notes = rs.getString("notes");

			passwordAccount.setId(id);
			passwordAccount.setUrl(url);
			passwordAccount.setUsername(username);
			passwordAccount.setEncryptedData(encryptedPass);
			passwordAccount.setNotes(notes);
			
			return passwordAccount;

		} catch (Exception ex) {
			currentCon.rollback();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
	}
	
	/**
	 * Create a new PasswordAccount in the database
	 * 
	 * @param currentUser The OpalUser account table to search, also the currentSessionAttribute
	 * @param passwordAccount The PasswordAccount (instantiated with appropriate data)
	 * @return The same PasswordAccount
	 */
	public PasswordAccount createAccount(OpalUser currentUser, PasswordAccount  passwordAccount) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		
		String url = passwordAccount.getUrl();
		String name = passwordAccount.getName();
		String opalUserName = passwordAccount.getOpalUser();
		String username = passwordAccount.getUsername();
		byte[] encryptedPass = passwordAccount.getEncryptedData();
		String notes = passwordAccount.getNotes();
		
		String insertQuery = "call add_account('"
								+ name
								+ "', '"
								+ opalUserName
								+ "', '"
								+ url
								+ "', '"
								+ username
								+ "', "
								+ encryptedPass
								+ ", '"
								+ notes
								+ "')";
		
		try {
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(insertQuery);
			currentCon.commit();
			return passwordAccount;
		} catch (Exception ex) {
			currentCon.rollback();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
		}
	}
}
