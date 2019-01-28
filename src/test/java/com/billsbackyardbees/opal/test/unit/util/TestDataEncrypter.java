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

import com.billsbackyardbees.opal.util.DataEncrypter;

/**
 * Tests the DataEncrypter class
 * @author Quinn Shultz
 */
public class TestDataEncrypter extends TestCase {

	private DataEncrypter secretDecoderRing;
	
	private final String EXAMPLE_PLAIN_TEXT_PASSWORD = "vW@&Q9PL$njvu69*";
	private final String EXAMPLE_PUBLIC_KEY = "ABCDEFGHIJKLMNOP";
	
	private final String EXAMPLE_CHARACTER_ENCODING = "UTF-8";
	private final String EXAMPLE_CIPHER_TRANSFORMATION = "AES/CBC/PKCS5PADDING";
	private final String EXAMPLE_AES_ENCRYPTION_ALGORITHM = "AES";
	
	/**
	 * Constructs a new DataEncrypter Object
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		secretDecoderRing = new DataEncrypter();
	}
	
	/**
	 * Tests that a new DataEncrypter Object is constructed
	 */
	@Test
	public void testConstructor() {
		assertNotNull(secretDecoderRing);
	}
	
	/**
	 * Tests that text can be deciphered after it is encrypted
	 */
	@Test
	public void testDecryptStringAfterEncryptString() {
		String encryptedString = secretDecoderRing.encryptString(EXAMPLE_PLAIN_TEXT_PASSWORD, EXAMPLE_PUBLIC_KEY, EXAMPLE_CIPHER_TRANSFORMATION, EXAMPLE_CHARACTER_ENCODING, EXAMPLE_AES_ENCRYPTION_ALGORITHM);
		assertEquals(secretDecoderRing.decryptString(encryptedString, EXAMPLE_PUBLIC_KEY, EXAMPLE_CIPHER_TRANSFORMATION, EXAMPLE_CHARACTER_ENCODING, EXAMPLE_AES_ENCRYPTION_ALGORITHM), EXAMPLE_PLAIN_TEXT_PASSWORD);
	}

}
