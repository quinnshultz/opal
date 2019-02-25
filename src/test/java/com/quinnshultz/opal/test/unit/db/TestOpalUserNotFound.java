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

import java.sql.SQLException;

import org.junit.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
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
public class TestOpalUserNotFound extends BasicJDBCTestCaseAdapter {
	
	private String EXAMPLE_USERNAME = "johndoe";
	private String EXAMPLE_FULL_NAME = "John Doe";
	private String EXAMPLE_PASSWORD = "47OLdsMd5%!ELIwr";
	
	private OpalUser opalUser;
	
	/**
	 * Prepares an empty ResultSet
	 */
	@Before
	public void setUp() throws Exception {
		MockConnection connection = getJDBCMockObjectFactory().getMockConnection();
		StatementResultSetHandler statementHandler = connection.getStatementResultSetHandler();
		MockResultSet result = statementHandler.createResultSet();
		statementHandler.prepareGlobalResultSet(result);
		opalUser = new OpalUser(EXAMPLE_USERNAME, EXAMPLE_PASSWORD, EXAMPLE_FULL_NAME);
	}

	/**
	 * Simulates a scenario where an empty ResultSet is returned because the OpalUser does not exist
	 * in the table
	 */
	@Disabled("Cannot verify SQL Statement was executed")
	@Test
	public void testWrongId() throws SQLException {
		OpalUserDAO userDAO = new OpalUserDAO();
		userDAO.connect();
		userDAO.login(opalUser);
		userDAO.disconnect();
		verifySQLStatementExecuted("select *");
		verifyNotCommitted();
        verifyRolledBack();
        verifyAllResultSetsClosed();
        verifyAllStatementsClosed();
        verifyConnectionClosed();
	}

}
