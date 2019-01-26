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

import java.sql.*;
import java.util.*;

/**
 * A MySQL Database connection.
 * 
 * @author Quinn Shultz
 */
public class DatabaseDriver {
	
	static Connection conn;
	static String url;
	
	/**
	 * @return The database connection
	 */
	public static Connection getConnection() {
		
		try {
			String url = "jdbc:mysql:" + "//localhost:3306/opalPasswordManager";
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				conn = DriverManager.getConnection(url, "jdbcopal", "Nth@Z8giog5uL3tD");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
		return conn;
	}
	
}