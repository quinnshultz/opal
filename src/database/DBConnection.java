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
package database;

import java.sql.*;
/**
 * A MySQL Database connection.
 * 
 * @author Quinn Shultz
 */
public class DBConnection {
	
	private Connection con;
	
	/**
	 * Create a new database connection
	 */
	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// It is recommended that you at least change the MySQL password to maximize security
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/opalPasswordManager", "jdbcopal", "password");
		
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
	public ResultSet executeStatement(String sqlStatement) {
		ResultSet rs;
		try {
			Statement stmt = con.createStatement();
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
			con.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
}