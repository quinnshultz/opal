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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.quinnshultz.opal.bean.OpalUser;
import com.quinnshultz.opal.db.OpalUserDAO;
import com.quinnshultz.opal.util.ConfigFile;

/**
 * Tests the OpalUserDAO class
 * @author Quinn Shultz
 */
public class OpalUserDataIT {
	
	private final String PERSISTENT_USERNAME = "johndoe";
	private final String PERSISTENT_FULL_NAME = "John Doe";
	private final String PERSISTENT_PASSWORD = "47OLdsMd5%!ELIwr";
	
	private final String EXAMPLE_USERNAME = "jdoe323";
	private final String EXAMPLE_FULL_NAME = "John Doe";
	private final String EXAMPLE_PASSWORD = "XGtzNr$oCxs&6$H1";
	
	private Connection connection;

	/**
	 * Gets a database connection
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	@Before
	public void setUp() throws SQLException, ClassNotFoundException, IOException {
		ConfigFile paramfetcher = new ConfigFile();
		String[] dbparams = paramfetcher.getDBProperties();
		Class.forName(dbparams[0]);
		connection = DriverManager.getConnection(dbparams[1], dbparams[2], dbparams[3]);
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
	 * Tries to find an OpalUser that doesn't exist in the table
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testLoginUserDoesNotExist() throws NoSuchAlgorithmException, IOException {
		String username = UUID.randomUUID().toString();
		String password = UUID.randomUUID().toString();
		String fullname = UUID.randomUUID().toString();
		OpalUser opalUser = new OpalUser(username, password, fullname);
		OpalUserDAO userDAO = new OpalUserDAO();
		try {
			userDAO.connect();
			opalUser = userDAO.login(opalUser);
			userDAO.disconnect();
		} catch (SQLException e) {
			fail("Caught SQLException when attempting to connect to the database, is it properly configured?");
		} catch (ClassNotFoundException e) {
			fail("Caught ClassNotFoundException when attempting to connect to the database, is MySQL Connector J properly installed?");
		}
		assertFalse(opalUser.isValid());
	}
	
	/**
	 * Tests that the register() method does not throw a message given a valid new OpalUser
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException
	 */
	@Test
	public void testRegisterExpectedResults() throws NoSuchAlgorithmException, IOException {
		OpalUser opalUser = new OpalUser(EXAMPLE_USERNAME, EXAMPLE_PASSWORD, EXAMPLE_FULL_NAME);
		OpalUserDAO userDAO = new OpalUserDAO();
		try {
			userDAO.connect();
			opalUser = userDAO.register(opalUser);
			userDAO.disconnect();
		} catch (SQLException e) {
			fail("Caught SQLException when attempting to connect to the database, is it properly configured?");
		} catch (ClassNotFoundException e) {
			fail("Caught ClassNotFoundException when attempting to connect to the database, is MySQL Connector J properly installed?");
		}
	}
	
	/**
	 * Tests that the login() method returns expected results after the method register() is executed
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException
	 */
	@Test
	public void testLoginAfterRegister() throws NoSuchAlgorithmException, IOException {
		OpalUser opalUser = new OpalUser(PERSISTENT_USERNAME, PERSISTENT_PASSWORD, PERSISTENT_FULL_NAME);
		OpalUserDAO userDAO = new OpalUserDAO();
		try {
			userDAO.connect();
			opalUser = userDAO.register(opalUser);
			opalUser = userDAO.login(opalUser);
			userDAO.disconnect();
		} catch (SQLException e) {
			fail("Caught SQLException when attempting to connect to the database, is it properly configured?");
		} catch (ClassNotFoundException e) {
			fail("Caught ClassNotFoundException when attempting to connect to the database, is MySQL Connector J properly installed?");
		}
		assertTrue(opalUser.isValid());
	}

}
