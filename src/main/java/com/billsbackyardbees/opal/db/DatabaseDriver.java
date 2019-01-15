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
package com.billsbackyardbees.opal.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A MySQL Database connection.
 * 
 * @author Quinn Shultz
 */
public class DatabaseDriver {
	
	private Connection conn;
	private StringBuilder queryBuilder[];
	private final int QUERY_BUILDER_ARRAY_BOUNDS = 3;

	/**
	 * Create a new database connection
	 */
	public DatabaseDriver() {
		queryBuilder = new StringBuilder[QUERY_BUILDER_ARRAY_BOUNDS];
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// It is recommended that you at least change the MySQL password to maximize security
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/opalPasswordManager", "jdbcopal", "Nth@Z8giog5uL3tD");
		
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Executes a MySQL statement on the currently connected database
	 * 
	 * @param sqlStatement Statement to be executed
	 * @return ResultSet returned by JDBC, if exception occurs returns null
	 */
	public java.sql.ResultSet executeStatement(String sqlStatement) {
		java.sql.ResultSet rs;
		try {
			java.sql.Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlStatement);
			return rs;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * Closes the currently running JDBC connection.
	 */
	public void closeConnection() {
		try {
			conn.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
}