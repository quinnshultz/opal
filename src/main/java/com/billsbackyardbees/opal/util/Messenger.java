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
 * Prints messages such as the menus and welcome screen.
 * @author Quinn Shultz
 * 
 */
public class Messenger {

	public Messenger() {
		
	}
	
	public void printWelcomeScreen() {
		System.out.println("Opal");
		System.out.println("A secure password manager.\n\n");
	}
	
	public void printUserPrompt() {
		System.out.print("opal> ");
	}
}
