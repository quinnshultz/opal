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
package com.quinnshultz.opal.test.unit.bean;

import junit.framework.TestCase;

import org.junit.*;

import com.quinnshultz.opal.bean.OpalUser;
import com.quinnshultz.opal.bean.PasswordAccount;

/**
 * Tests class PasswordAccount
 * @author Quinn Shultz
 */
public class TestPAParamConstructor extends TestCase {
	
	private final String CONSTRUCTOR_URL = "https://accounts.spotify.com/en/login";
	private final String CONSTRUCTOR_ACCOUNT_NAME = "Spotify";
	private final String CONSTRUCTOR_OWNER = "johndoe";
	private final String CONSTRUCTOR_USERNAME = "johndoe";
	private final String CONSTRUCTOR_FULL_NAME = "John Doe";
	private final String CONSTRUCTOR_PASSWORD = "Uu%W@7Z2iaWa5@q7";
	private final String CONSTRUCTOR_NOTES = "My favorite streaming service!";
	
	private final int METHOD_ID = 22;
	private final String METHOD_URL = "https://www.deezer.com/us/login";
	private final String METHOD_ACCOUNT_NAME = "Deezer";
	private final String METHOD_OWNER = "jdoe323";
	private final String METHOD_USERNAME = "janedoe";
	private final String METHOD_PASSWORD = "6A6l$!nEe4ifD0@E";
	private final String METHOD_NOTES = "A music streaming service.";
	
	private PasswordAccount encrypter;
	private OpalUser account;

	/**
	 * Constructs a new PasswordAccount Object
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		account = new OpalUser(CONSTRUCTOR_USERNAME, CONSTRUCTOR_PASSWORD, CONSTRUCTOR_FULL_NAME);
		byte[] key = account.getSerializedKey();
		encrypter = new PasswordAccount(CONSTRUCTOR_ACCOUNT_NAME, CONSTRUCTOR_URL, CONSTRUCTOR_OWNER, CONSTRUCTOR_USERNAME, CONSTRUCTOR_PASSWORD, key, CONSTRUCTOR_NOTES);
	}

	/**
	 * Tests that a new PasswordAccount Object is constructed without error
	 */
	@Test
	public void testConstructor() {
		assertNotNull(encrypter);
	}
	
	/**
	 * Tests that the getId() method returns expected results and throws no Exception
	 */
	@Test
	public void testGetId() {
		try {
			assertEquals(encrypter.getId(), 0);
		} catch (Exception e) {
			fail("Caught an Exception when executing getId()");
		}
	}
	
	/**
	 * Tests that the setId() method does not throw an Exception
	 */
	@Test
	public void testSetId() {
		try {
			encrypter.setId(METHOD_ID);
		} catch (Exception e) {
			fail("Caught an Exception when executing setId()");
		}
	}
	
	/**
	 * Tests that expected results are returned by getId() after the setId() method is called
	 */
	@Test
	public void testGetIdAfterSetId() {
		encrypter.setId(METHOD_ID);
		assertEquals(encrypter.getId(), METHOD_ID);
	}
	
	/**
	 * Tests that the getUrl() method returns expected results and throws no Exception
	 */
	@Test
	public void testGetUrl() {
		try {
			assertEquals(encrypter.getUrl(), CONSTRUCTOR_URL);
		} catch (Exception e) {
			fail("Caught an Exception when executing getUrl()");
		}
	}
	
	/**
	 * Tests that the setUrl() method does not throw an Exception
	 */
	@Test
	public void testSetUrl() {
		try {
			encrypter.setUrl(METHOD_URL);
		} catch (Exception e) {
			fail("Caught an Exception when executing setUrl()");
		}
	}
	
	/**
	 * Tests that expected results are returned by getUrl() after the setUrl() method is called
	 */
	@Test
	public void testGetUrlAfterSetUrl() {
		encrypter.setUrl(METHOD_URL);
		assertEquals(encrypter.getUrl(), METHOD_URL);
	}
	
	/**
	 * Tests that the getEncryptedData() method returns expected results and throws no Exception
	 */
	@Test
	public void testGetEncryptedData() {
		try {
			// TODO: Check that expected results are returned, not just that no Exception is thrown
			encrypter.getEncryptedData();
		} catch (Exception e) {
			fail("Caught an Exception when executing getEncryptedData()");
		}
	}
	
	// TODO: Test setEncryptedData()
	// TODO: Test getEncryptedData() after setEncryptedData()
	// TODO: Test getData()
	// TODO: Test setData()
	// TODO: Test getData() after setData()
	
	/**
	 * Tests that the getName() method returns expected results and throws no Exception
	 */
	@Test
	public void testGetName() {
		try {
			assertEquals(encrypter.getName(), CONSTRUCTOR_ACCOUNT_NAME);
		} catch (Exception e) {
			fail("Caught an Exception when executing getName()");
		}
	}
	
	/**
	 * Tests that the setName() method does not throw an exception
	 */
	@Test
	public void testSetName() {
		try {
			encrypter.setName(METHOD_ACCOUNT_NAME);
		} catch (Exception e) {
			fail("Caught an Exception when executing setName()");
		}
	}
	
	/**
	 * Tests that the getName() method returns expected results after calling setName()
	 */
	@Test
	public void testGetNameAfterSetName() {
		encrypter.setName(METHOD_ACCOUNT_NAME);
		assertEquals(encrypter.getName(), METHOD_ACCOUNT_NAME);
	}
	
	/**
	 * Tests that the getUsername() method returns expected results and throws no Exception
	 */
	@Test
	public void testGetUsername() {
		try {
			assertEquals(encrypter.getUsername(), CONSTRUCTOR_USERNAME);
		} catch (Exception e) {
			fail("Caught an Exception when executing getUsername()");
		}
	}
	
	/**
	 * Tests that the setUsername() method does not throw an exception
	 */
	@Test
	public void testSetUsername() {
		try {
			encrypter.setUsername(METHOD_USERNAME);
		} catch (Exception e) {
			fail("Caught an Exception when executing setUsername()");
		}
	}
	
	/**
	 * Tests that the getUsername() method returns expected results after calling setUsername()
	 */
	@Test
	public void testGetUsernameAfterSetUsername() {
		encrypter.setUsername(METHOD_USERNAME);
		assertEquals(encrypter.getUsername(), METHOD_USERNAME);
	}
	
	/**
	 * Tests that the getNotes() method returns expected results and throws no Exception
	 */
	@Test
	public void testGetNotes() {
		try {
			assertEquals(encrypter.getNotes(), CONSTRUCTOR_NOTES);
		} catch (Exception e) {
			fail("Caught an Exception when executing getNotes()");
		}
	}
	
	/**
	 * Tests that the setNotes() method does not throw an Exception
	 */
	@Test
	public void testSetNotes() {
		try {
			encrypter.setNotes(METHOD_NOTES);
		} catch (Exception e) {
			fail("Caught an Exception when executing setNotes()");
		}
	}
	
	/**
	 * Tests that the getNotes() method returns expected results after calling setNotes()
	 */
	@Test
	public void testGetNotesAfterSetNotes() {
		encrypter.setNotes(METHOD_NOTES);
		assertEquals(encrypter.getNotes(), METHOD_NOTES);
	}
	
	/**
	 * Tests that the getOpalUser() method returns expected results and throws no Exception
	 */
	@Test
	public void testGetOpalUser() {
		try {
			assertEquals(encrypter.getOpalUser(), CONSTRUCTOR_OWNER);
		} catch (Exception e) {
			fail("Caught an Exception when executing getOpalUser()");
		}
	}
	
	/**
	 * Tests that the setOpalUser() method does not throw an Exception
	 */
	@Test
	public void testSetOpalUser() {
		try {
			encrypter.setOpalUser(METHOD_OWNER);
		} catch (Exception e) {
			fail("Caught an Exception when executing setOpalUser()");
		}
	}
	
	/**
	 * Tests that the getOpalUser() method returns expected results after calling setOpalUser()
	 */
	@Test
	public void testGetOpalUserAfterSetOpalUser() {
		encrypter.setOpalUser(METHOD_OWNER);
		assertEquals(encrypter.getOpalUser(), METHOD_OWNER);
	}
	
	/**
	 * Tests that the isModifiedFromDB() method returns expected results and throws no Exception
	 */
	@Test
	public void testIsModifiedFromDB() {
		try {
			assertEquals(encrypter.isModifiedFromDB(), true);
		} catch (Exception e) {
			fail("Caught Exception when executing isModifiedFromDB()");
		}
	}
	
	/**
	 * Tests that the setModifiedFromDB() method does not throw an Exception
	 */
	@Test
	public void testSetModifiedFromDB() {
		try {
			encrypter.setModifiedFromDB(false);
		} catch (Exception e) {
			fail("Caught Exception when executing setModifiedFromDB()");
		}
	}
	
	/**
	 * Tests that the isModifiedFromDB() method returns expected results after calling setModifiedFromDB()
	 */
	@Test
	public void testIsModifiedFromDBAfterSetModifiedFromDB() {
		encrypter.setModifiedFromDB(false);
		assertEquals(encrypter.isModifiedFromDB(), false);
	}
}
