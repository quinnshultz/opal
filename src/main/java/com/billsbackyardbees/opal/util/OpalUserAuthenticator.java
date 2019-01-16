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
	
	private int opalUser;
	private boolean isLocked;
	
	/**
	 * Creates a new locked OpalUserAuthenticator
	 * 
	 * @param opalUser Integer id and primary key of user in opalUsers table
	 * @param privateKey Master password entered by user
	 */
	public OpalUserAuthenticator(int opalUser) {
		this.opalUser = opalUser;
		isLocked = true;
	}
	
	/**
	 * Unlock account if it is locked
	 * @param privateKey Master password for Opal user
	 */
	public void unlockAccount(String privateKey) {
		// TODO: Make sure user entered their real private key
		isLocked = false;
	}
	
	/**
	 * @return true if account is locked, false otherwise
	 */
	public boolean isAccountLocked() {
		return isLocked;
	}

}
