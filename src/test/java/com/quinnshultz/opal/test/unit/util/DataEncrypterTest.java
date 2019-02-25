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
package com.quinnshultz.opal.test.unit.util;

import junit.framework.TestCase;

import org.junit.*;

import com.quinnshultz.opal.util.DataEncrypter;

/**
 * Tests the DataEncrypter class
 * @author Quinn Shultz
 */
public class DataEncrypterTest extends TestCase {
	
	private final String EXAMPLE_PLAIN_TEXT_PASSWORD = "vW@&Q9PL$njvu69*";
	private final byte[] EXAMPLE_PRIVATE_KEY = EXAMPLE_PLAIN_TEXT_PASSWORD.getBytes();
	
	/**
	 * Constructs a new DataEncrypter Object
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	/**
	 * Tests that text can be deciphered after it is encrypted
	 */
	@Test
	public void testDecryptStringAfterEncryptString() {
		String encryptedString = DataEncrypter.encryptString(EXAMPLE_PLAIN_TEXT_PASSWORD, EXAMPLE_PRIVATE_KEY);
		assertEquals(DataEncrypter.decryptString(encryptedString, EXAMPLE_PRIVATE_KEY), EXAMPLE_PLAIN_TEXT_PASSWORD);
	}

}
