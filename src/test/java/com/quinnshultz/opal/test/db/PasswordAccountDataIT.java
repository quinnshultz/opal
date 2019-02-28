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
import com.quinnshultz.opal.bean.PasswordAccount;
import com.quinnshultz.opal.db.PasswordAccountDAO;
import com.quinnshultz.opal.util.ConfigFile;

/**
 * Tests the PasswordAccountDAO class
 * 
 * @author Quinn Shultz
 */
public class PasswordAccountDataIT {
	
	private final String PERSISTENT_USERNAME = "johndoe";
	private final String PERSISTENT_FULL_NAME = "John Doe";
	private final String PERSISTENT_PASSWORD = "47OLdsMd5%!ELIwr";
	
	private final String PERSISTENT_ACCOUNT_NAME = "Spotify";
	
	private Connection connection;

	/**
	 * Gets a database connection
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	@Before
	public void setUp() throws IOException, ClassNotFoundException, SQLException {
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
	 * Tries to find a PasswordAccount for a non-existent user, this Object was slightly damaged and the isValid()
	 * method mistakenly returns true
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	@Test
	public void testBrokenOpalUserDoesNotExist() throws NoSuchAlgorithmException, IOException {
		// Generate unique values to ensure an user that does not already exist
		String username = UUID.randomUUID().toString();
		String password = UUID.randomUUID().toString();
		String fullname = UUID.randomUUID().toString();
		
		String accountName = UUID.randomUUID().toString();
		
		// Create PasswordAccount and accompanying OpalUser that is not in the database, 
		// but isValid() returns true
		OpalUser opalUser = new OpalUser(username, password, fullname);
		opalUser.setValid(true);
		PasswordAccount passwordAccount = new PasswordAccount();
		passwordAccount.setName(accountName);
		
		// Create PasswordAccount Data Access Object
		PasswordAccountDAO paDAO = new PasswordAccountDAO();
		
		try {
			paDAO.connect();
			paDAO.findAccount(opalUser, passwordAccount);
			paDAO.disconnect();
		} catch (SQLException e) {
			// PASS: For now, throws SQLException when invalid OpalUser is passed to findAccount()
		}
	}
	
	/**
	 * Tries to find a PasswordAccount for a non-existent user
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	@Test
	public void testOpalUserDoesNotExist() throws NoSuchAlgorithmException, IOException {
		// Generate unique values to ensure an user that does not already exist
		String username = UUID.randomUUID().toString();
		String password = UUID.randomUUID().toString();
		String fullname = UUID.randomUUID().toString();
		
		String accountName = UUID.randomUUID().toString();
		
		// Create PasswordAccount and accompanying OpalUser that is not in the database and isValid() returns false
		OpalUser opalUser = new OpalUser(username, password, fullname);
		PasswordAccount passwordAccount = new PasswordAccount();
		passwordAccount.setName(accountName);
		
		// Create PasswordAccount Data Access Object
		PasswordAccountDAO paDAO = new PasswordAccountDAO();
		
		try {
			paDAO.connect();
			paDAO.findAccount(opalUser, passwordAccount);
			paDAO.disconnect();
		} catch (SQLException e) {
			// PASS: For now, throws SQLException when invalid OpalUser is passed to findAccount()
		}
	}
	
	/**
	 * Tries to find a non-existent PasswordAccount for a valid OpalUser in the database
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException 
	 */
	@Test
	public void testPasswordAccountDoesNotExist() throws NoSuchAlgorithmException, IOException {
		String accountName = UUID.randomUUID().toString();
		
		// Create non-existent PasswordAccount and accompanying OpalUser previously loaded into the database by Jenkins
		OpalUser opalUser = new OpalUser(PERSISTENT_USERNAME, PERSISTENT_PASSWORD, PERSISTENT_FULL_NAME);
		PasswordAccount passwordAccount = new PasswordAccount();
		passwordAccount.setName(accountName);
		
		PasswordAccountDAO paDAO = new PasswordAccountDAO();
		
		try {
			paDAO.connect();
			passwordAccount = paDAO.findAccount(opalUser, passwordAccount);
			paDAO.disconnect();
		} catch (SQLException e) {
			// PASS: For now, throws SQLException when invalid PasswordAccount is passed to findAccount()
		}
	}
	
	/**
	 * Tests that a PasswordAccount expected to exist in the database, really does exist
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	@Ignore
	@Test
	public void testFindValidAccount() throws NoSuchAlgorithmException, IOException {
		OpalUser opalUser = new OpalUser(PERSISTENT_USERNAME, PERSISTENT_PASSWORD, PERSISTENT_FULL_NAME);
		PasswordAccount passwordAccount = new PasswordAccount();
		passwordAccount.setName(PERSISTENT_ACCOUNT_NAME);
		
		PasswordAccountDAO paDAO = new PasswordAccountDAO();
		
		try {
			paDAO.connect();
			passwordAccount = paDAO.findAccount(opalUser, passwordAccount);
			paDAO.disconnect();
		} catch (SQLException e){
			fail("Caught SQLException when attempting to find valid PasswordAccount for valid OpalUser");
		}
		// TODO: Check that returned PasswordAccount matches expected result from database
	}

}
