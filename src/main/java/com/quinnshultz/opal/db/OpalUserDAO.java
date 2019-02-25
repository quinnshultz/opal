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
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	/**
	 * See if an OpalUser can be found in the database
	 * 
	 * @param user OpalUser account to validate
	 * @return OpalUser with appropriate isValid value
	 */
	public static OpalUser login(OpalUser user) {
		Statement stmt = null;
		
		String username = user.getUsername();
		
		String searchQuery =
				"select * from opalUsers where username='"
						+ username
						+ "'";
		
		try {
			currentCon = DatabaseDriver.getConnection("jdbc:mysql://localhost:3306/opalPasswordManager", "jdbcopal", "Nth@Z8giog5uL3tD");
			stmt=currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			
			// If user does not exist set the isValid variable to false
			if(!more) {
				user.setValid(false);
			}
			
			// If user exists set the isValid variable to true
			else if (more) {
				String fullName = rs.getString("fullName");
				
				user.setFullName(fullName);
				user.setValid(true);
			}
			
		} catch (Exception ex) {
			
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
		
		return user;
		
	}
	
	/**
	 * Create a new OpalUser in the database
	 * 
	 * @param user OpalUser to add
	 * @return The same OpalUser
	 */
	public static OpalUser register(OpalUser user) {
		Statement stmt = null;
		
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
			currentCon = DatabaseDriver.getConnection("jdbc:mysql://localhost:3306/opalPasswordManager", "jdbcopal", "Nth@Z8giog5uL3tD");
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(insertQuery);
		} catch (Exception ex) {
		
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {}
				rs = null;
			}
			
			if (stmt != null) {
				try {
					rs.close();
				} catch (Exception e) {}
				stmt = null;
			}
		}
		
		return user;
	}

}
