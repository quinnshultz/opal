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
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import org.junit.Test;
import com.billsbackyardbees.opal.bean.OpalUser;

public class TestOpalUser extends TestCase {
	
	private final String EXAMPLE_USERNAME = "jdoe323";
	private final String EXAMPLE_NEW_USERNAME = "johndoe";
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
		opalUser = new OpalUser(EXAMPLE_USERNAME, EXAMPLE_PASSWORD, EXAMPLE_FULL_NAME);
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
			// TODO: Test additional cases this method may experience
			opalUser.getId();
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getId()");
		}
	}
	
	/**
	 * Tests the getUsername() method
	 */
	@Test
	public void testGetUsername() {
		try {
			assertEquals(opalUser.getUsername(), EXAMPLE_USERNAME);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing getUsername()");
		}
	}
	
	/**
	 * Tests the setUsername() method
	 */
	@Test
	public void testSetUsername() {
		try {
			opalUser.setUsername(EXAMPLE_NEW_USERNAME);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setUsername()");
		}
	}
	
	/**
	 * Tests that the Username can be retrieved after it is set
	 */
	@Test
	public void testGetUsernameAfterSetUsername() {
		opalUser.setUsername(EXAMPLE_NEW_USERNAME);
		assertEquals(opalUser.getUsername(), EXAMPLE_NEW_USERNAME);
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
	 * Tests that the isLoginTrue() method returns a password matching initialization
	 */
	@Test
	public void testPasswordMatchesInitialization() {
		try {
			assertEquals(opalUser.isLoginTrue(EXAMPLE_PASSWORD), true);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing isLoginTrue()");
		}
	}
	
	/**
	 * Tests the setPassword() method
	 */
	@Test
	public void testSetPassword() {
		try {
			opalUser.setPassword(EXAMPLE_PASSWORD, EXAMPLE_NEW_PASSWORD);
		} catch (Exception e) {
			// Test fails, caught an exception
			fail("Caught exception when executing setPassword()");
		}
	}
	
	/**
	 * Tests that the password can be retrieved after it is set
	 */
	@Test
	public void testIsLoginTrueAfterSetPassword() {
		try {
			opalUser.setPassword(EXAMPLE_PASSWORD, EXAMPLE_NEW_PASSWORD);
			
			// Test fails if we catch any of these exceptions
		} catch (KeyStoreException e) {
			fail("Caught KeyStoreException when executing setPassword()");
		} catch (NoSuchAlgorithmException e) {
			fail("Caught NoSuchAlgorithmException when executing setPassword()");
		} catch (CertificateException e) {
			fail("Caught CertificateException when executing setPassword()");
		} catch (IOException e) {
			fail("Caught IOException when execution setPassword()");
		}
		assertEquals(opalUser.isLoginTrue(EXAMPLE_NEW_PASSWORD), true);
	}
	
	/**
	 * Tests the isValid() method
	 */
	@Test
	public void isValid() {
		try {
			assertEquals(opalUser.isValid(), null);
		} catch (Exception e) {
			fail("Caught an exception when execution isValid()");
		}
	}
	
	/**
	 * Tests the setValid() method
	 */

}
