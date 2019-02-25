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

import java.security.NoSuchAlgorithmException;

import org.junit.*;

import com.quinnshultz.opal.bean.OpalUser;

/**
 * Tests the OpalUser class
 * @author Quinn Shultz
 */
public class OUParamConstructorTest extends TestCase {
	
	private final String CONSTRUCTOR_USERNAME = "jdoe323";
	private final String CONSTRUCTOR_FULL_NAME = "John Doe";
	private final String CONSTRUCTOR_PASSWORD = "47OLdsMd5%!ELIwr";
	
	private final int METHOD_ID = 101;
	private final String METHOD_USERNAME = "jane.doe";
	private final String METHOD_FULL_NAME = "Jane Doe";
	private final String METHOD_PASSWORD = "@792A5qF#dDSkN!3";
	
	private OpalUser opalUser;

	/**
	 * Constructs a new OpalUser Object
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		opalUser = new OpalUser(CONSTRUCTOR_USERNAME, CONSTRUCTOR_PASSWORD, CONSTRUCTOR_FULL_NAME);
	}

	/**
	 * Tests that a new OpalUser Object is constructed without error
	 */
	@Test
	public void testConstructor() {
		assertNotNull(opalUser);
	}
	
	/**
	 * Tests that the getId() method returns expected results and throws no Exception
	 */
	@Test
	public void testGetId() {
		try {
			assertEquals(opalUser.getId(), 0);
		} catch (Exception e) {
			fail("Caught Exception when executing getId()");
		}
	}
	
	/**
	 * Tests that the setId() method does not throw an Exception
	 */
	@Test
	public void testSetId() {
		try {
			opalUser.setId(METHOD_ID);
		} catch (Exception e) {
			fail("Caught Exception when executing setId()");
		}
	}
	
	/**
	 * Tests that expected results are returned by getId() after the setId() method is called
	 */
	@Test
	public void testGetIdAfterSetId() {
		opalUser.setId(METHOD_ID);
		assertEquals(opalUser.getId(), METHOD_ID);
	}
	
	/**
	 * Tests that the getUsername() method returns expected results and throws no Exception
	 */
	@Test
	public void testGetUsername() {
		try {
			assertEquals(opalUser.getUsername(), CONSTRUCTOR_USERNAME);
		} catch (Exception e) {
			fail("Caught Exception when executing getUsername()");
		}
	}
	
	/**
	 * Tests that the setUsername() method does not throw an Exception
	 */
	@Test
	public void testSetUsername() {
		try {
			opalUser.setUsername(METHOD_USERNAME);
		} catch (Exception e) {
			fail("Caught Exception when executing setUsername()");
		}
	}
	
	/**
	 * Tests that expected results are returned by getUsername() after the setUsername() method is called
	 */
	@Test
	public void testGetUsernameAfterSetUsername() {
		opalUser.setUsername(METHOD_USERNAME);
		assertEquals(opalUser.getUsername(), METHOD_USERNAME);
	}
	
	/**
	 * Tests that the getFullName() method returns expected results and throws no Exception
	 */
	@Test
	public void testGetFullName() {
		try {
			assertEquals(opalUser.getFullName(), CONSTRUCTOR_FULL_NAME);
		} catch (Exception e) {
			fail("Caught Exception when executing getFullName()");
		}
	}
	
	/**
	 * Tests that the setFullName() method does not throw an Exception
	 */
	@Test
	public void testSetFullName() {
		try {
			opalUser.setFullName(METHOD_FULL_NAME);
		} catch (Exception e) {
			fail("Caught Exception when executing setFullName()");
		}
	}
	
	/**
	 * Tests that expected results are returned by getFullName() after the setFullName() method is called
	 */
	@Test
	public void testGetFullNameAfterSetFullName() {
		opalUser.setFullName(METHOD_FULL_NAME);
		assertEquals(opalUser.getFullName(), METHOD_FULL_NAME);
	}
	
	/**
	 * Tests that the isLoginTrue() method returns true when correct password is passed to it
	 */
	@Test
	public void testIsLoginTrue() {
		assertTrue(opalUser.isLoginTrue(CONSTRUCTOR_PASSWORD));
	}
	
	/**
	 * Tests that the isLoginTrue() method returns false when incorrect password is passed to it
	 */
	@Test
	public void testIsLoginFalse() {
		assertFalse(opalUser.isLoginTrue(METHOD_PASSWORD));
	}
	
	/**
	 * Tests that the isLoginTrue() method returns true after the OpalUser password is updated with the setPassword() method
	 */
	@Test
	public void testIsLoginTrueAfterSetPassword() {
		try {
			opalUser.setPassword(CONSTRUCTOR_PASSWORD, METHOD_PASSWORD);
			assertTrue(opalUser.isLoginTrue(METHOD_PASSWORD));
		} catch (NoSuchAlgorithmException e) {
		} catch (Exception e) {
		}
	}
	
	/**
	 * Tests that the isLoginTrue() method does not throw an Exception
	 */
	@Test
	public void testIsLoginTrueThrowsNoException() {
		try {
			opalUser.isLoginTrue(CONSTRUCTOR_PASSWORD);
		} catch (Exception e) {
			fail("Caught Exception when executing isLoginTrue()");
		}
	}
	
	/**
	 * Tests that the getPassword() method returns expected results and throws no Exception
	 */
	@Test
	public void testGetPassword() {
		try {
			assertEquals(opalUser.getPassword(), CONSTRUCTOR_PASSWORD);
		} catch (Exception e) {
			fail("Caught Exception when executing getPassword()");
		}
	}
	
	/**
	 * Tests that the setPassword() method does not throw an Exception when a valid existing password is provided
	 */
	@Test
	public void testSetPasswordValid() {
		try {
			opalUser.setPassword(CONSTRUCTOR_PASSWORD, METHOD_PASSWORD);
		} catch (NoSuchAlgorithmException e) {
			fail("Caught NoSuchAlgorithmException when executing setPassword()");
		} catch (Exception e) {
			fail("Caught Exception when executing setPassword()");
		}
	}
	
	/**
	 * Tests that the setPassword() method throws an Exception when an invalid existing password is provided
	 */
	@Test
	public void testSetPasswordInvalid() {
		try {
			opalUser.setPassword(METHOD_PASSWORD, METHOD_PASSWORD);
			fail("Ideally an InvalidPasswordException will be thrown or maybe it returns.");
		} catch (Exception e) {
			// TODO: Catch more specific Exception
		}
	}
	
	/**
	 * Tests that the getSerializedKey() method does not throw an Exception
	 */
	@Test
	public void testGetSerializedKeyThrowsNoException() {
		try {
			opalUser.getSerializedKey();
		} catch (Exception e) {
			fail("Caught Exception when executing getSerializedKey()");
		}
	}
	
	// TODO: Test getSerializedKey() in more ways
	
	/**
	 * Tests that the isValid() method returns expected results and throws no Exception
	 */
	@Test
	public void testIsValid() {
		try {
			assertFalse(opalUser.isValid());
		} catch (Exception e) {
			fail("Caught Exception when executing isValid()");
		}
	}
	
	/**
	 * Tests that the setValid() method does not throw an Exception
	 */
	@Test
	public void testSetValid() {
		try {
			opalUser.setValid(true);
		} catch (Exception e) {
			fail("Caught Exception when executing setValid()");
		}
	}
	
	/**
	 * Tests that expected results are returned from isValid() after setValid() is called
	 */
	@Test
	public void testIsValidAfterSetValid() {
		opalUser.setValid(true);
		assertTrue(opalUser.isValid());
	}

}
