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
package com.billsbackyardbees.opal.test.unit.db;

import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.*;

import com.billsbackyardbees.opal.db.DatabaseDriver;

/**
 * Tests class DatabaseDriver
 * @author Quinn Shultz
 */
public class TestDatabaseDriverReturnsConn extends TestCase {
	
	private Connection connection;

	private final String EXAMPLE_QUERY = "select * from opalUsers limit 1000";
	
	/**
	 * Gets a MySQL database connection for use by test methods
	 */
	@Before
	public void setUp() throws Exception {
		connection = DatabaseDriver.getConnection();
	}

	/**
	 * Tests that an example query is able to be executed and that the
	 * opalUsers table exists in the schema
	 */
	@Test
	public void testExampleQuery() {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeQuery(EXAMPLE_QUERY);
		} catch (SQLException e) {
			fail("Caught SQLConnection when querying database");
		}
	}
	
	// TODO: Add more test cases and ensure that database results are as expected
	
}
