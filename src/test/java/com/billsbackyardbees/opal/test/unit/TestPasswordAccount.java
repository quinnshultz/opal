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
package com.billsbackyardbees.opal.test.unit;

import junit.framework.TestCase;

import org.junit.Test;

import com.billsbackyardbees.opal.util.PasswordAccount;

/**
 * Tests class PasswordAccount
 * @author Quinn Shultz
 */
public class TestPasswordAccount extends TestCase {
	
	private final String EXAMPLE_ACCOUNT_URL = "https://accounts.spotify.com/en/login";
	private final String EXAMPLE_ACCOUNT_NAME = "Spotify";
	private final String EXAMPLE_USERNAME = "johndoe";
	private final String EXAMPLE_PASSWORD = "Uu%W@7Z2iaWa5@q7";
	private final String EXAMPLE_NOTES = "My favorite streaming service!";
	private final String EXAMPLE_CHARACTER_ENCODING = "UTF-8";
	private final String EXAMPLE_CIPHER_TRANSFORMATION = "AES/CBC/PKCS5PADDING";
	private final String EXAMPLE_AES_ENCRYPTION_ALGORITHM = "AES";
	
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
			assertEquals(encrypter.getId(), -1);
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
	
	/**
	 * Tests the setPassword() method
	 */
	@Test
	public void testSetPassword() {
		try {
			encrypter.setPassword(EXAMPLE_PASSWORD);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setPassword()");
		}
	}
	
	/**
	 * Tests the getPassword() method
	 */
	@Test
	public void testGetPassword() {
		try {
			assertEquals(encrypter.getPassword(), null);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getUsername()");
		}
	}
	
	/**
	 * Tests that password may be retrieved after it is set
	 */
	@Test
	public void testGetPasswordAfterSetPassword() {
		encrypter.setPassword(EXAMPLE_PASSWORD);
		assertEquals(encrypter.getPassword(), EXAMPLE_PASSWORD);
	}
	
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
	
	/**
	 * Tests the setCharacterEncoding() method
	 */
	@Test
	public void testSetCharacterEncoding() {
		try {
			encrypter.setCharacterEncoding(EXAMPLE_CHARACTER_ENCODING);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setCharacterEncoding()");
		}
	}
	
	/**
	 * Tests the getCharacterEncoding() method
	 */
	@Test
	public void testGetCharacterEncoding() {
		try {
			assertEquals(encrypter.getCharacterEncoding(), "UTF-8");
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getCharacterEncoding()");
		}
	}
	
	/**
	 * Tests the setCipherTransformation() method
	 */
	@Test
	public void testSetCipherTransformation() {
		try {
			encrypter.setCipherTransformation(EXAMPLE_CIPHER_TRANSFORMATION);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setCipherTransformation()");
		}
	}
	
	/**
	 * Tests the getCipherTransformation() method
	 */
	@Test
	public void testGetCipherTransformation() {
		try {
			assertEquals(encrypter.getCipherTransformation(), "AES/CBC/PKCS5PADDING");
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getCipherTransformation()");
		}
	}
	
	/**
	 * Tests the setAesEncryptionAlgorithm() method
	 */
	@Test
	public void testSetAesEncryptionAlgorithm() {
		try {
			encrypter.setAesEncryptionAlgorithm(EXAMPLE_AES_ENCRYPTION_ALGORITHM);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setAesEncryptionAlgorithm()");
		}
	}
	
	/**
	 * Tests the getAesEncryptionAlgorithm() method
	 */
	@Test
	public void testGetAesEncryptionAlgorithm() {
		try {
			assertEquals(encrypter.getAesEncryptionAlgorithm(), "AES");
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getAesEncryptionAlgorithm()");
		}
	}
	
}
