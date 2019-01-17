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
package com.billsbackyardbees.opal.test.unit;

import junit.framework.TestCase;

import org.junit.Test;

import com.billsbackyardbees.opal.util.DataLoader;
import com.billsbackyardbees.opal.util.OpalUserAuthenticator;

/**
 * Tests the DataLoader class
 * @author Quinn Shultz
 */
public class TestDataLoader extends TestCase {
	
	private DataLoader opalDataLoader;

	/**
	 * Constructs a new DataLoader Object
	 */
	protected void setUp() throws Exception {
		super.setUp();
		opalDataLoader = new DataLoader(0);
	}
	
	/**
	 * Tests that a new OpalUserAuthenticator Object is constructed
	 */
	@Test
	public void testConstructor() {
		assertNotNull(opalDataLoader);
	}

}
