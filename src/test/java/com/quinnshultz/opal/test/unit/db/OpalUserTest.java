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
package com.quinnshultz.opal.test.unit.db;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.mockrunner.jdbc.BasicJDBCTestCaseAdapter;
import com.mockrunner.jdbc.StatementResultSetHandler;
import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockResultSet;
import com.quinnshultz.opal.bean.OpalUser;
import com.quinnshultz.opal.db.OpalUserDAO;


/**
 * Tests the DatabaseDriver class
 * @author Quinn Shultz
 */
public class OpalUserTest extends BasicJDBCTestCaseAdapter {
	
	private final String EXAMPLE_USERNAME = "johndoe";
	private final String EXAMPLE_FULL_NAME = "John Doe";
	private final String EXAMPLE_PASSWORD = "47OLdsMd5%!ELIwr";
	
	private OpalUser opalUser;
	
	/**
	 * Prepares a ResultSet with 10000 rows
	 */
	@Before
	public void setUp() throws Exception {
		MockConnection connection = getJDBCMockObjectFactory().getMockConnection();
	    StatementResultSetHandler statementHandler = connection.getStatementResultSetHandler();
	    MockResultSet result = statementHandler.createResultSet();
	    result.addRow(new Integer[] {new Integer(10000)});
	    statementHandler.prepareGlobalResultSet(result);
	    opalUser = new OpalUser(EXAMPLE_USERNAME, EXAMPLE_PASSWORD, EXAMPLE_FULL_NAME);
	}

	/**
	 * Simulates a scenario in which a new OpalUser is successfully register to the database
	 * @throws IOException 
	 */
	@Test
	public void test() throws IOException {
		OpalUserDAO userDAO = new OpalUserDAO();
		try {
			userDAO.connect();
		} catch (ClassNotFoundException e) {
			fail("Caught ClassNotFoundException when executing connect()");
		} catch (SQLException e) {
			fail("Caught SQLException when executing connect()");
		}
		try {
			userDAO.register(opalUser);
		} catch (SQLException e) {
			fail("Caught SQLException when executing register()");
		}
		try {
			userDAO.disconnect();
		} catch (SQLException e) {
			fail("Caught SQLException when executing disconnect()");
		}
	}
	
	// TODO: Add a test to verify statement runs on Mock

}
