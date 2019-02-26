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
package com.quinnshultz.opal.test.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKey;

import org.junit.Before;
import org.junit.Test;

import com.quinnshultz.opal.bean.OpalUser;
import com.quinnshultz.opal.bean.PasswordAccount;
import com.quinnshultz.opal.util.DataEncrypter;

/**
 * Tests class PasswordAccount
 * @author Quinn Shultz
 */
public class PasswordAccountEncryptionIT {
	
	private final String CONSTRUCTOR_FULL_NAME = "John Doe";
	
	private final String METHOD_USERNAME = "janedoe";
	private final String METHOD_PASSWORD = "6A6l$!nEe4ifD0@E";
	
	private PasswordAccount encrypter;
	private OpalUser account;
	private byte[] key;

	/**
	 * Constructs a new PasswordAccount Object
	 * @throws NoSuchAlgorithmException 
	 */
	@Before
	public void setUp() throws NoSuchAlgorithmException {
		account = new OpalUser(METHOD_USERNAME, METHOD_PASSWORD, CONSTRUCTOR_FULL_NAME);
		key = account.getSerializedKey();
		encrypter = new PasswordAccount();
	}

	/**
	 * Tests that a new PasswordAccount Object is constructed without error
	 */
	@Test
	public void testConstructor() {
		assertNotNull(encrypter);
		assertNotNull(account);
		assertNotNull(key);
	}
	
	

}
