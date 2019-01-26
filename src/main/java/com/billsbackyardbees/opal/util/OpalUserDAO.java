package com.billsbackyardbees.opal.util;

import java.text.*;
import java.util.*;
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
		
		String email = user.getEmail();
		String password = user.getPassword();
		
		String searchQuery =
				"select * from users where email='"
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
