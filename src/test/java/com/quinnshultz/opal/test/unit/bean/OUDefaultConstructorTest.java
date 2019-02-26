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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;

import com.quinnshultz.opal.bean.OpalUser;

/**
 * Tests the OpalUser class
 * @author Quinn Shultz
 */
public class OUDefaultConstructorTest {
	
	private final int EXAMPLE_ID = 101;
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
	@Before
	public void setUp() {
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
			opalUser.setId(EXAMPLE_ID);
		} catch (Exception e) {
			fail("Caught Exception when executing setId()");
		}
	}
	
	/**
	 * Tests that expected results are returned by getId() after the setId() method is called
	 */
	@Test
	public void testGetIdAfterSetId() {
		opalUser.setId(EXAMPLE_ID);
		assertEquals(opalUser.getId(), EXAMPLE_ID);
	}
	
	/**
	 * Tests that the getUsername() method returns expected results and throws no Exception
	 */
	@Test
	public void testGetUsername() {
		try {
			assertEquals(opalUser.getUsername(), null);
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
			opalUser.setUsername(EXAMPLE_NEW_USERNAME);
		} catch (Exception e) {
			fail("Caught Exception when executing setUsername()");
		}
	}
	
	/**
	 * Tests that expected results are returned by getUsername() after the setUsername() method is called
	 */
	@Test
	public void testGetUsernameAfterSetUsername() {
		opalUser.setUsername(EXAMPLE_NEW_USERNAME);
		assertEquals(opalUser.getUsername(), EXAMPLE_NEW_USERNAME);
	}
	
	/**
	 * Tests that the getFullName() method returns expected results and throws no Exception
	 */
	@Test
	public void testGetFullName() {
		try {
			assertEquals(opalUser.getFullName(), null);
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
			opalUser.setFullName(EXAMPLE_NEW_NAME);
		} catch (Exception e) {
			fail("Caught Exception when executing setFullName()");
		}
	}
	
	/**
	 * Tests that expected results are returned by getFullName() after the setFullName() method is called
	 */
	@Test
	public void testGetFullNameAfterSetFullName() {
		opalUser.setFullName(EXAMPLE_NEW_NAME);
		assertEquals(opalUser.getFullName(), EXAMPLE_NEW_NAME);
	}
	
	/**
	 * Tests that the isLoginTrue() method returns false because it hasn't been initialized with one yet
	 */
	@Test
	public void testIsLoginTrue() {
		assertFalse(opalUser.isLoginTrue(EXAMPLE_PASSWORD));
	}
	
	/**
	 * Tests that the isLoginTrue() method returns true after the OpalUser password is updated with the setPassword() method
	 */
	@Test
	public void testIsLoginTrueAfterSetPassword() {
		try {
			opalUser.setPassword(EXAMPLE_PASSWORD, EXAMPLE_NEW_PASSWORD);
			assertTrue(opalUser.isLoginTrue(EXAMPLE_NEW_PASSWORD));
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
			opalUser.isLoginTrue(EXAMPLE_PASSWORD);
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
			assertEquals(opalUser.getPassword(), null);
		} catch (Exception e) {
			fail("Caught Exception when executing getPassword()");
		}
	}
	
	/**
	 * Tests that the setPassword() method does not throw an Exception when a valid old password is provided
	 */
	@Test
	public void testSetPasswordValid() {
		try {
			opalUser.setPassword(EXAMPLE_PASSWORD, EXAMPLE_NEW_PASSWORD);
		} catch (NoSuchAlgorithmException e) {
			fail("Caught NoSuchAlgorithmException when executing setPassword()");
		} catch (Exception e) {
			fail("Caught Exception when executing setPassword()");
		}
	}
	
	/**
	 * Tests that the setPassword() method throws an Exception when the setPassword() method is called twice,
	 * the second time with an invalid password
	 */
	@Test
	public void testSetPasswordDuplicateInvalid() {
		try {
			opalUser.setPassword(EXAMPLE_NEW_PASSWORD, EXAMPLE_NEW_PASSWORD);
			opalUser.setPassword(EXAMPLE_PASSWORD, EXAMPLE_NEW_PASSWORD);
			fail("Ideally an InvalidPasswordException will be thrown or maybe it returns.");
		} catch (Exception e) {
			// TODO: Catch a more specific Exception
		}
	}
	
	/**
	 * Tests that the setPassword() method does not throw an Exception when the setPassword() method is called twice,
	 * the first time with any password, the second execution must match the first 
	 */
	@Test
	public void testSetPasswordDuplicateValid() {
		try {
			opalUser.setPassword(EXAMPLE_PASSWORD, EXAMPLE_PASSWORD);
			opalUser.setPassword(EXAMPLE_PASSWORD, EXAMPLE_NEW_PASSWORD);
		} catch (Exception e) {
			// TODO: Catch a more specific Exception
			fail("Caught Exception when executing setPassword()");
		}
	}
	
	/**
	 * Tests that the getSerializedKey() method does not throw an Exception after a password is set
	 */
	@Test
	public void testGetSerializedKey() {
		try {
			opalUser.setPassword(EXAMPLE_PASSWORD, EXAMPLE_PASSWORD);
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
