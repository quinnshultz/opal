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

import java.security.NoSuchAlgorithmException;

import org.junit.Test;
import com.billsbackyardbees.opal.util.KeyGen;

/**
 * Tests the KeyGen class
 * @author Quinn Shultz
 */
public class TestKeyGen extends TestCase {

	/**
	 * Tests that the generateKey() method does not throw an exception
	 */
	@Test
	public void testGenerateKey() {
		try {
			KeyGen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			fail("Caught NoSuchAlgorithmException when executing generateKey()");
		}
	}
	
	/**
	 * Tests that the generateKey(encryptionAlgorithm, keyLength) method does not throw an exception
	 */
	@Test
	public void testGenerateKeyWithParam() {
		try {
			// TODO: Test for something other than AES
			KeyGen.generateKey("AES", 256);
		} catch (NoSuchAlgorithmException e) {
			fail("Caught NoSuchAlgorithmException when executing generateKey() with parameters");
		}
	}

}
