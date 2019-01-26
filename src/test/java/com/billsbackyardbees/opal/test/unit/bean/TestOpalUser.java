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

import java.util.List;

import org.junit.Test;

import com.backyardbees.opal.bean.OpalUser;

public class TestOpalUser extends TestCase {
	
	private final String EXAMPLE_EMAIL = "johndoe@example.com";
	private final String EXAMPLE_NEW_EMAIL = "johndoe@gmail.com";
	private final String EXAMPLE_FULL_NAME = "John Doe";
	private final String EXAMPLE_NEW_NAME = "Jane Doe";
	private final String EXAMPLE_PASSWORD = "47OLdsMd5%!ELIwr";
	private final String EXAMPLE_NEW_PASSWORD = "h0d2IYa4K8h^&giP";
	
	private OpalUser opalUser;

	/**
	 * Constructs a new OpalUser Object
	 */
	protected void setUp() throws Exception {
		super.setUp();
		opalUser = new OpalUser(EXAMPLE_EMAIL, EXAMPLE_PASSWORD, EXAMPLE_FULL_NAME, "{USER}");
	}
	
	/**
	 * Tests that a new OpalUser was constructed without error
	 */
	@Test
	public void testConstructor() {
		assertNotNull(opalUser);
	}
	
	/**
	 * Tests the getEmail() method
	 */
	@Test
	public void testGetEmail() {
		try {
			assertEquals(opalUser.getEmail(), EXAMPLE_EMAIL);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getEmail()");
		}
	}
	
	/**
	 * Tests the setEmail() method
	 */
	@Test
	public void testSetEmail() {
		try {
			opalUser.setEmail(EXAMPLE_NEW_EMAIL);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setUsername()");
		}
	}
	
	/**
	 * Tests that the Email Address can be retrieved after it is set
	 */
	@Test
	public void testGetUsernameAfterSetUsername() {
		opalUser.setEmail(EXAMPLE_NEW_EMAIL);
		assertEquals(opalUser.getEmail(), EXAMPLE_NEW_EMAIL);
	}
	
	/**
	 * Tests the getFullName() method
	 */
	@Test
	public void testGetFullName() {
		try {
			assertEquals(opalUser.getFullName(), EXAMPLE_FULL_NAME);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getFullName()");
		}
	}
	
	/**
	 * Tests the setFullName() method
	 */
	@Test
	public void testSetFullName() {
		try {
			opalUser.setFullName(EXAMPLE_NEW_NAME);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setFullName()");
		}
	}
	
	/**
	 * Tests that the full name can be retrieved after it is set
	 */
	@Test
	public void testGetFullNameAfterSetFullName() {
		opalUser.setFullName(EXAMPLE_NEW_NAME);
		assertEquals(opalUser.getFullName(), EXAMPLE_NEW_NAME);
	}
	
	/**
	 * Tests the getPassword() method
	 */
	@Test
	public void testGetPassword() {
		try {
			assertEquals(opalUser.getPassword(), EXAMPLE_PASSWORD);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getPassword()");
		}
	}
	
	/**
	 * Tests the setPassword() method
	 */
	@Test
	public void testSetPassword() {
		try {
			opalUser.setPublicKey(EXAMPLE_NEW_PASSWORD);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setPassword()");
		}
	}
	
	/**
	 * Tests that the public key can be retrieved after it is set
	 */
	@Test
	public void testGetPasswordAfterSetPassword() {
		opalUser.setFullName(EXAMPLE_NEW_PASSWORD);
		assertEquals(opalUser.getFullName(), EXAMPLE_NEW_PASSWORD);
	}

}
