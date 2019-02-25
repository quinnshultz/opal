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

/**
 * Methods to use OpalUser beans with the database
 * 
 * @author Quinn Shultz
 */
public class OpalUserDAO {
	
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
	 * See if an OpalUser can be found in the database
	 * 
	 * @param user OpalUser account to validate
	 * @return OpalUser with appropriate isValid value
	 */
	public OpalUser login(OpalUser user) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		
		String username = user.getUsername();
		
		String searchQuery =
				"select * from opalUsers where username='"
						+ username
						+ "'";
		
		try {
			stmt=currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			
			// If user does not exist set the isValid variable to false
			if(!more) {
				currentCon.rollback();
				user.setValid(false);
				return user;
			}
			
			// If user exists set the isValid variable to true
			user.setId(rs.getInt("id"));
			user.setFullName(rs.getString("fullName"));
			user.setUsername(rs.getString("username"));
			// TODO: Set user's password

			return user;
			
		} catch (Exception ex) {
			currentCon.rollback();
			user.setValid(false);
			return user;
			
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {}
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
	 * Create a new OpalUser in the database
	 * 
	 * @param user OpalUser to add
	 * @return The same OpalUser
	 */
	public OpalUser register(OpalUser user) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		
		String username = user.getUsername();
		String password = user.getPassword();
		String fullName = user.getFullName();
		byte[] key = user.getSerializedKey();
		
		String insertQuery =
				"call add_new_opaluser('"
						+ username
						+ "', '"
						+ fullName
						+ "', '"
						+ password
						+ "', '"
						+ key
						+ "')";

		try {
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(insertQuery);
			currentCon.commit();
			user.setValid(true);
			return user;
		} catch (Exception ex) {
			currentCon.rollback();
			user.setValid(false);
			return user;
		
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {}
				rs = null;
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {}
				stmt = null;
			}
		}
	}
}
