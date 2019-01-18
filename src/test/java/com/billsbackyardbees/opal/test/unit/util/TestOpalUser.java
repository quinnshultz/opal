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

import com.billsbackyardbees.opal.util.OpalUser;

public class TestOpalUser extends TestCase {
	
	private final String EXAMPLE_USERNAME = "johndoe";
	private final String EXAMPLE_FULL_NAME = "John Doe";
	private final String EXAMPLE_PUBLIC_KEY = "mayneedtobechanged";
	
	private OpalUser opalUser;

	/**
	 * Constructs a new OpalUser Object
	 */
	protected void setUp() throws Exception {
		super.setUp();
		opalUser = new OpalUser();
	}
	
	/**
	 * Tests that a new OpalUser was constructed without error
	 */
	@Test
	public void testConstructor() {
		assertNotNull(opalUser);
	}
	
	/**
	 * Tests the getId() method
	 */
	@Test
	public void testGetId() {
		try {
			assertEquals(opalUser.getId(), -1);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getId()");
		}
	}
	
	/**
	 * Tests the setUsername() method
	 */
	@Test
	public void testSetUsername() {
		try {
			opalUser.setUsername(EXAMPLE_USERNAME);
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
			assertEquals(opalUser.getUsername(), null);
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
		opalUser.setUsername(EXAMPLE_USERNAME);
		assertEquals(opalUser.getUsername(), EXAMPLE_USERNAME);
	}
	
	/**
	 * Tests the setFullName() method
	 */
	@Test
	public void testSetFullName() {
		try {
			opalUser.setFullName(EXAMPLE_FULL_NAME);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setFullName()");
		}
	}
	
	/**
	 * Tests the getFullName() method
	 */
	@Test
	public void testGetFullName() {
		try {
			assertEquals(opalUser.getFullName(), null);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getFullName()");
		}
	}
	
	/**
	 * Tests that the full name can be retrieved after it is set
	 */
	@Test
	public void testGetFullNameAfterSetFullName() {
		opalUser.setFullName(EXAMPLE_FULL_NAME);
		assertEquals(opalUser.getFullName(), EXAMPLE_FULL_NAME);
	}
	
	/**
	 * Tests the setPublicKey() method
	 */
	@Test
	public void testSetPublicKey() {
		try {
			opalUser.setPublicKey(EXAMPLE_PUBLIC_KEY);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setPublicKey()");
		}
	}
	
	/**
	 * Tests the getPublicKey() method
	 */
	@Test
	public void testGetPublicKey() {
		try {
			assertEquals(opalUser.getPublicKey(), null);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getPublicKey()");
		}
	}
	
	/**
	 * Tests that the public key can be retrieved after it is set
	 */
	@Test
	public void testGetPublicKeyAfterSetPublicKey() {
		opalUser.setFullName(EXAMPLE_PUBLIC_KEY);
		assertEquals(opalUser.getFullName(), EXAMPLE_PUBLIC_KEY);
	}

}
