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

import com.billsbackyardbees.opal.util.Screamer;

/**
 * Tests the Screamer class
 * @author Quinn Shultz
 */
public class TestScreamer extends TestCase {
	
	Screamer printer;

	/**
	 * Constructs a new Screamer Object
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		printer = new Screamer();
	}
	
	/**
	 * Tests that a new Screamer Object is constructed
	 */
	@Test
	public void testConstructor() {
		assertNotNull(printer);
	}
	
	/**
	 * Tests that the printAccountHelp() method does not throw an exception
	 */
	@Test
	public void testPrintAccountHelp() {
		try {
			printer.printAccountHelp();
		} catch (Exception e) {
			fail("Caught exception when executing printAccountHelp()");
		}
	}

	/**
	 * Tests that the printExitHelp() method does not throw an exception
	 */
	@Test
	public void testPrintExitHelp() {
		try {
			printer.printExitHelp();
		} catch (Exception e) {
			fail("Caught exception when executing printExitHelp()");
		}
	}
	
	/**
	 * Tests that the printHelpHelp() method does not throw an exception
	 */
	@Test
	public void testPrintHelpHelp() {
		try {
			printer.printHelpHelp();
		} catch (Exception e) {
			fail("Caught exception when executing printHelpHelp()");
		}
	}
	
	/**
	 * Tests that the printLoginHelp() method does not throw an exception
	 */
	@Test
	public void testPrintLoginHelp() {
		try {
			printer.printLoginHelp();
		} catch (Exception e) {
			fail("Caught exception when executing printLoginHelp()");
		}
	}
	
	/**
	 * Tests that the printLogoutHelp() method does not throw an exception
	 */
	@Test
	public void testPrintLogoutHelp() {
		try {
			printer.printLogoutHelp();
		} catch (Exception e) {
			fail("Caught exception when executing printLogoutHelp()");
		}
	}
	
	/**
	 * Tests that the printHelpScreen() method does not throw an exception
	 */
	@Test
	public void testPrintHelpScreen() {
		try {
			printer.printHelpScreen();
		} catch (Exception e) {
			fail("Caught exception when executing printHelpScreen()");
		}
	}
	
	/**
	 * Tests that the printWelcomeScreen() method does not throw an exception
	 */
	@Test
	public void testPrintWelcomeScreen() {
		try {
			printer.printWelcomeScreen();
		} catch (Exception e) {
			fail("Caught exception when executing printWelcomeScreen()");
		}
	}

	/**
	 * Tests that the printUserPrompt() method does not throw an exception
	 */
	@Test
	public void testPrintUserPrompt() {
		try {
			printer.printAccountHelp();
		} catch (Exception e) {
			fail("Caught exception when executing printUserPrompt()");
		}
	}
}
