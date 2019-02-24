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
package com.billsbackyardbees.opal.test.unit.bean;

import junit.framework.TestCase;

import org.junit.Test;

import com.billsbackyardbees.opal.bean.PasswordAccount;

/**
 * Tests class PasswordAccount
 * @author Quinn Shultz
 */
public class TestPADefaultConstructor extends TestCase {
	
	private final String EXAMPLE_ACCOUNT_URL = "https://accounts.spotify.com/en/login";
	private final String EXAMPLE_ACCOUNT_NAME = "Spotify";
	private final String EXAMPLE_USERNAME = "johndoe";
//	private final String EXAMPLE_PASSWORD = "Uu%W@7Z2iaWa5@q7";
	private final String EXAMPLE_NOTES = "My favorite streaming service!";
	
	private PasswordAccount encrypter;

	/**
	 * Constructs a new AccountDBLoader Object
	 */
	protected void setUp() throws Exception {
		super.setUp();
		encrypter = new PasswordAccount();
	}
	
	/**
	 * Tests that a new AccountDBLoader Object may be constructed without error
	 */
	@Test
	public void testConstructor() {
		assertNotNull(encrypter);
	}
	
	/**
	 * Tests the getId() method
	 */
	@Test
	public void testGetId() {
		try {
			assertEquals(encrypter.getId(), 0);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getId()");
		}
	}
	
	/**
	 * Tests the setUrl() method
	 */
	@Test
	public void testSetUrl() {
		try {
			encrypter.setUrl(EXAMPLE_ACCOUNT_URL);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setUrl()");
		}
	}
	
	/**
	 * Tests the getUrl() method
	 */
	@Test
	public void testGetUrl() {
		try {
			assertEquals(encrypter.getUrl(), null);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getUrl()");
		}
	}
	
	/**
	 * Tests that the URL can be retrieved after it is set
	 */
	@Test
	public void testGetUrlAfterSetUrl() {
		encrypter.setUrl(EXAMPLE_ACCOUNT_URL);
		assertEquals(encrypter.getUrl(), EXAMPLE_ACCOUNT_URL);
	}
	
	/**
	 * Tests the setName() method
	 */
	@Test
	public void testSetName() {
		try {
			encrypter.setName(EXAMPLE_ACCOUNT_NAME);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setName()");
		}
	}
	
	/**
	 * Tests the getName() method
	 */
	@Test
	public void testGetName() {
		try {
			assertEquals(encrypter.getName(), null);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getName()");
		}
	}
	
	/**
	 * Tests that the account name can be retrieved after it is set
	 */
	@Test
	public void testGetNameAfterSetName() {
		encrypter.setName(EXAMPLE_ACCOUNT_NAME);
		assertEquals(encrypter.getName(), EXAMPLE_ACCOUNT_NAME);
	}
	
	/**
	 * Tests the setUsername() method
	 */
	@Test
	public void testSetUsername() {
		try {
			encrypter.setUsername(EXAMPLE_USERNAME);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setUsername()");
		}
	}
	
	/**
	 * Tests the getUsername() method
	 */
	@Test
	public void testGetUsername() {
		try {
			assertEquals(encrypter.getUsername(), null);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getUsername()");
		}
	}
	
	/**
	 * Tests that the username can be retrieved after it is set
	 */
	@Test
	public void testGetUsernameAfterSetUsername() {
		encrypter.setUsername(EXAMPLE_USERNAME);
		assertEquals(encrypter.getUsername(), EXAMPLE_USERNAME);
	}
	
//	/**
//	 * Tests the setEncryptedData() method
//	 */
//	@Test
//	public void testSetEncryptedData() {
//		try {
//			encrypter.setEncryptedData(EXAMPLE_PASSWORD, EXAMPLE_);
//		} catch (Exception e) {
//			// Test fails, caught an exception
//			fail("Caught exception when executing setEncryptedData()");
//		}
//	}
//	
//	/**
//	 * Tests the getEncrytedData() method
//	 */
//	@Test
//	public void testGetEncryptedData() {
//		try {
//			assertEquals(encrypter.getEncryptedData(), null);
//		} catch (Exception e) {
//			// Test fails, caught an exception
//			fail("Caught exception when executing getEncryptedData()");
//		}
//	}
//	
//	/**
//	 * Tests that password may be retrieved after it is set,
//	 * and that it isn't the same as the original
//	 */
//	@Test
//	public void testGetEncryptedDataAfterSetEncryptedData() {
//		encrypter.setEncryptedData(EXAMPLE_PASSWORD);
//		if(encrypter.getEncryptedData() == EXAMPLE_PASSWORD) {
//			fail("Password was stored as plain-text.");
//		}
//	}
	
	/**
	 * Tests the setNotes() method
	 */
	@Test
	public void testSetNotes() {
		try {
			encrypter.setNotes(EXAMPLE_NOTES);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setNotes()");
		}
	}
	
	/**
	 * Tests the getNotes() method
	 */
	@Test
	public void testGetNotes() {
		try {
			assertEquals(encrypter.getNotes(), null);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getUsername()");
		}
	}
	
	/**
	 * Tests that notes may be retrieved after they are set
	 */
	@Test
	public void testGetNotesAfterSetNotes() {
		encrypter.setNotes(EXAMPLE_NOTES);
		assertEquals(encrypter.getNotes(), EXAMPLE_NOTES);
	}
	
}
