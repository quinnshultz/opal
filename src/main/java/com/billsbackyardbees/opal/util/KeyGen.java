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
package com.billsbackyardbees.opal.util;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class KeyGen {
	
	private static final int DEFAULT_KEY_LENGTH = 2048;
	
	/**
	 * Create a SecretKey for an OpalUser with AES Encryption,
	 * 2048 bytes in length.
	 * 
	 * @return A new secret key
	 * @throws NoSuchAlgorithmException 
	 */
	public static SecretKey generateKey() throws NoSuchAlgorithmException {
		SecretKey generatedSecretKey;
		
		KeyGenerator secretKeyGen = KeyGenerator.getInstance("AES");
		secretKeyGen.init(DEFAULT_KEY_LENGTH);
		generatedSecretKey = secretKeyGen.generateKey();
		
		return generatedSecretKey;
	}
	
	/**
	 * Create a SecretKey for an OpalUser with user specified
	 * encryption algorithm and length.
	 * 
	 * @param encryptionAlgorithm The encryption algorithm
	 * @param keyLength Length in bytes of the new key
	 * @return A new secret key
	 * @throws NoSuchAlgorithmException If the provided encryption algorithm is invalid.
	 */
	public static SecretKey generateKey(String encryptionAlgorithm, int keyLength) throws NoSuchAlgorithmException {
		SecretKey generatedSecretKey;
		
		KeyGenerator secretKeyGen = KeyGenerator.getInstance(encryptionAlgorithm);
		secretKeyGen.init(keyLength);
		generatedSecretKey = secretKeyGen.generateKey();
		
		return generatedSecretKey;
	}

}
