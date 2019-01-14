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
package test;

import junit.framework.TestCase;
import database.DBConnection;

import org.junit.Test;

public class DBConnectionTest extends TestCase {
	
	private DBConnection connection;

	/**
	 * Constructs a new DBConnection Object
	 */
	protected void setUp() throws Exception {
		super.setUp();
		connection = new DBConnection();
	}
	
	/**
	 * Tests that a new DBConnection Object is constructed
	 */
	@Test
	public void testDBCConstructor() {
		assertNotNull(connection);
	}
}
