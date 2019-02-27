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
package com.quinnshultz.opal.test.db;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class OpalUserNotFoundIT {
	
	private Connection connection;

	/**
	 * Gets a database connection
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Before
	public void setUp() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/opalPasswordManager", "jdbcopal", "Nth@Z8giog5uL3tD");
	}
	
	/**
	 * Destroys the database connection
	 * @throws SQLException
	 */
	@After
	public void tearDown() throws SQLException {
		if (null != connection) {
			connection.close();
			connection = null;
		}
	}
	

	/**
	 * Tests that a opalUsers table was created
	 */
	@Ignore("Not yet implemented")
	@Test
	public void test() {
		
	}

}
