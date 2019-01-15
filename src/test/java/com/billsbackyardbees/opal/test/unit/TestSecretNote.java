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

import com.billsbackyardbees.opal.pgm.SecretNote;

public class TestSecretNote extends TestCase {
	
	private final String EXAMPLE_NOTE_NAME = "Shopping List";
	private final String EXAMPLE_NOTES = "Eggs\nFlour\nSugar\nMilk";
	private final String EXAMPLE_CHARACTER_ENCODING = "UTF-8";
	private final String EXAMPLE_CIPHER_TRANSFORMATION = "AES/CBC/PKCS5PADDING";
	private final String EXAMPLE_AES_ENCRYPTION_ALGORITHM = "AES";
	
	public SecretNote codedMessage;

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
			assertEquals(codedMessage.getId(), null);
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

}
