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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A MySQL Database connection.
 * 
 * @author Quinn Shultz
 */
public class DatabaseDriver {
	
	static Connection conn;
	static String url;
	
	/**
	 * Returns a MySQL Connection Object used for querying the database.
	 * 
	 * @param database The name of the database. Supplied identically as to MySQL Connector J (jdbc:mysql://<url or ip>:<port>/<database name>)
	 * @param username MySQL user name
	 * @param password MySQL password
	 * @return The database connection
	 * @throws ClassNotFoundException If the driver could not be loaded. Check that com.mysql.cj.jdbc.Driver is in your classpath.
	 * @throws SQLException
	 */
	public static Connection getConnection(String database, String username, String password) throws ClassNotFoundException, SQLException {

			Class.forName("com.mysql.cj.jdbc.Driver");
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/opalPasswordManager", "jdbcopal", "Nth@Z8giog5uL3tD");

		return conn;
	}
	
}