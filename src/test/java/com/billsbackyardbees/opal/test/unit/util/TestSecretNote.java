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
package com.billsbackyardbees.opal.test.unit.util;

import junit.framework.TestCase;

import org.junit.Test;

import com.billsbackyardbees.opal.util.SecretNote;

public class TestSecretNote extends TestCase {
	
	private final String EXAMPLE_NOTE_NAME = "Shopping List";
	private final String EXAMPLE_NOTES = "Eggs\nFlour\nSugar\nMilk";
	private final String EXAMPLE_CHARACTER_ENCODING = "UTF-8";
	private final String EXAMPLE_CIPHER_TRANSFORMATION = "AES/CBC/PKCS5PADDING";
	private final String EXAMPLE_AES_ENCRYPTION_ALGORITHM = "AES";
	
	private SecretNote codedMessage;

	/**
	 * Constructs a new SecretNote Object
	 */
	protected void setUp() throws Exception {
		super.setUp();
		codedMessage = new SecretNote();
	}
	
	/**
	 * Tests that a new SecretNote was constructed without error
	 */
	@Test
	public void testConstructor() {
		assertNotNull(codedMessage);
	}

	/**
	 * Tests the getId() method
	 */
	@Test
	public void testGetId() {
		try {
			assertEquals(codedMessage.getId(), -1);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getId()");
		}
	}
	
	/**
	 * Tests the setName() method
	 */
	@Test
	public void testSetName() {
		try {
			codedMessage.setName(EXAMPLE_NOTE_NAME);
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
			assertEquals(codedMessage.getName(), null);
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
		codedMessage.setName(EXAMPLE_NOTE_NAME);
		assertEquals(codedMessage.getName(), EXAMPLE_NOTE_NAME);
	}
	
	/**
	 * Tests the setEncryptedData() method
	 */
	@Test
	public void testSetEncryptedData() {
		try {
			codedMessage.setEncryptedData(EXAMPLE_NOTES);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setEncryptedData()");
		}
	}
	
	/**
	 * Tests the getEncrytedData() method
	 */
	@Test
	public void testGetEncryptedData() {
		try {
			assertEquals(codedMessage.getEncryptedData(), null);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getUsername()");
		}
	}
	
	/**
	 * Tests that password may be retrieved after it is set,
	 * and that it isn't the same as the original
	 */
	@Test
	public void testGetPasswordAfterSetPassword() {
		codedMessage.setEncryptedData(EXAMPLE_NOTES);
		if(codedMessage.getEncryptedData() == EXAMPLE_NOTES) {
			fail("Password was stored as plain-text.");
		}
	}
	
	/**
	 * Tests the setCharacterEncoding method
	 */
	@Test
	public void testSetCharacterEncoding() {
		try {
			codedMessage.setCharacterEncoding(EXAMPLE_CHARACTER_ENCODING);
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
			assertEquals(codedMessage.getCharacterEncoding(), "UTF-8");
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
			codedMessage.setCipherTransformation(EXAMPLE_CIPHER_TRANSFORMATION);
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
			assertEquals(codedMessage.getCipherTransformation(), "AES/CBC/PKCS5PADDING");
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
			codedMessage.setAesEncryptionAlgorithm(EXAMPLE_AES_ENCRYPTION_ALGORITHM);
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
			assertEquals(codedMessage.getAesEncryptionAlgorithm(), "AES");
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getAesEncryptionAlgorithm()");
		}
	}

}
