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

/**
 * 
 * @author Quinn Shultz
 */
public class OpalUserAuthenticator {
	
	private String opalUser;
	// TODO: Switch to asymmetric key cryptography
	private String privateKey;
	
	/**
	 * Creates a new OpalUserAuthenticator
	 * 
	 * @param opalUser Opal username
	 * @param privateKey Master password entered by user
	 */
	public OpalUserAuthenticator(String opalUser, String privateKey) {
		this.opalUser = opalUser;
		this.privateKey = privateKey;
	}
	
	/**
	 * Get the username of the owner
	 * @return
	 */
	public String getOpalUser() {
		return opalUser;
	}
	
	/**
	 * May be insecure, returns user's passwod
	 * @return
	 */
	public String getPrivateKey() {
		return privateKey;
	}

}
