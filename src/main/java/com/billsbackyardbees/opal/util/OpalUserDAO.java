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

import java.sql.*;
import com.billsbackyardbees.opal.bean.OpalUser;
import com.billsbackyardbees.opal.db.DatabaseDriver;

/**
 * 
 * @author met.guc.edu.eg
 *
 */
public class OpalUserDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public static OpalUser login(OpalUser user) {
		Statement stmt = null;
		
		String email = user.getUsername();
		String password = user.getPassword();
		
		String searchQuery =
				"select * from opalUsers where username='"
						+ email
						+ "' AND password='"
						+ password
						+ "'";
		
		try {
			currentCon = DatabaseDriver.getConnection();
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

}
