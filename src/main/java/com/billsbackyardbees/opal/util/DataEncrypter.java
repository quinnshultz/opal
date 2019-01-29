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

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Encrypts data
 * @author Quinn Shultz
 *
 */
public class DataEncrypter {

	/**
	 * Encrypt a String.
	 * 
	 * @param data String desired to be encrypted
	 * @param publicKey Encryption key
	 * @param cipherTransformation
	 * @param characterEncoding
	 * @param aesEncryptionAlgorithm
	 * @return Encrypted data
	 */
	public static String encryptString(String data, String publicKey, String cipherTransformation, String characterEncoding, String aesEncryptionAlgorithm) {
		String encryptedString = "";
		try {
			Cipher cipher = Cipher.getInstance(cipherTransformation);
			byte[] key = publicKey.getBytes(characterEncoding);
			SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithm);
			IvParameterSpec ivparameterspec = new IvParameterSpec(key);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivparameterspec);
			byte[] cipherText = cipher.doFinal(data.getBytes("UTF8"));
			Base64.Encoder encoder = Base64.getEncoder();
			encryptedString = encoder.encodeToString(cipherText);
			
		} catch (Exception e) {
			System.err.println("Encrypt Exception : " + e.getMessage());
		}
		return encryptedString;
	}
	
	/**
	 * Encrypt a String that was encoded with UTF-8 and encrypted with AES.
	 * 
	 * @param data String desired to be encrypted
	 * @param publicKey Encryption key
	 * @param cipherTransformation
	 * @param characterEncoding
	 * @param aesEncryptionAlgorithm
	 * @return Encrypted data
	 */
	public static String encryptString(String data, byte[] privateKey) {
		String encryptedString = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecretKeySpec secretKey = new SecretKeySpec(privateKey, "AES");
			IvParameterSpec ivparameterspec = new IvParameterSpec(privateKey);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivparameterspec);
			byte[] cipherText = cipher.doFinal(data.getBytes("UTF8"));
			Base64.Encoder encoder = Base64.getEncoder();
			encryptedString = encoder.encodeToString(cipherText);
			
		} catch (Exception e) {
			System.err.println("Encrypt Exception : " + e.getMessage());
		}
		return encryptedString;
	}
	
	/**
	 * Decipher a String that was encoded with UTF-8 and encrypted with AES.
	 * 
	 * @param data String desired to be decrypted
	 * @param privateKey Encryption key
	 * @param cipherTransformation
	 * @param characterEncoding
	 * @param aesEncryptionAlgorithm
	 * @return Deciphered data
	 */
	public static String decryptString(String data, byte[] privateKey) {
		String decryptedString = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecretKeySpec secretKey = new SecretKeySpec(privateKey, "AES");
			IvParameterSpec ivparameterspec = new IvParameterSpec(privateKey);
			cipher.init(Cipher.DECRYPT_MODE, secretKey, ivparameterspec);
			Base64.Decoder decoder = Base64.getDecoder();
			byte[] cipherText = decoder.decode(data.getBytes("UTF8"));
			decryptedString = new String(cipher.doFinal(cipherText), "UTF-8");
			
		} catch (Exception e) {
			System.err.println("decrypt Exception : " + e.getMessage());
		}
		return decryptedString;
	}
	
}
