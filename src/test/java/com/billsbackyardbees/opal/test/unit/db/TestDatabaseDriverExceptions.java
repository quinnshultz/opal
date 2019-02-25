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

import java.sql.SQLException;

import org.junit.*;

import com.billsbackyardbees.opal.db.DatabaseDriver;

/**
 * Tests class DatabaseDriver
 * @author Quinn Shultz
 */
public class TestDatabaseDriverExceptions extends TestCase {

	/**
	 * Tests that the getConnection() method does not throw a SQLException
	 */
//	@Test
//	public void testGetConnectionSQLException() {
//		try {
//			DatabaseDriver.getConnection();
//		} catch (ClassNotFoundException e) {
//		} catch (SQLException e) {
//			fail("Caught SQLException when executing getConnection()");
//		} 
//	}
	
	/**
	 * Tests that the getConnection() method does not throw a ClassNotFoundException
	 */
	@Test
	public void testGetConnectionClassException() {
		try {
			DatabaseDriver.getConnection();
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
			fail("Caught ClassNotFoundException when executing getConnection()");
		}
	}

}
