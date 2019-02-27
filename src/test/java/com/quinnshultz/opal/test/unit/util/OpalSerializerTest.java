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

import static org.junit.Assert.fail;

import org.junit.Test;

import com.quinnshultz.opal.util.OpalSerializer;

/**
 * Tests the OpalSerializer class
 * @author Quinn Shultz
 */
public class OpalSerializerTest {

	/**
	 * Tests that the getSerialVersionUID does not throw an Exception
	 */
	@Test
	public void testSerialVersionUID() {
		try {
			OpalSerializer.getSerialVersionUID();
		} catch (Exception e) {
			fail("Caught Exception when executing getSerialVersionUID()");
		}
	}

}
