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
public class Screamer {

	public Screamer() {
		
	}
	
	/**
	 * Messages output when command: "help account" is run
	 */
	public void printAccountHelp() {
		System.out.println("account: account [-n] [pattern ...]");
		System.out.println();
		System.out.println("\tOptions:");
		System.out.println("\t -n\tcreate a new account");
		System.out.println();
		System.out.println("\tArguments:");
		System.out.println("\t PATTERN\tPattern specifying an account name");
	}
	
	/**
	 * Messages output when command: "help help" is run
	 */
	public void printHelpHelp() {
		System.out.println("help: help [pattern ...]");
		System.out.println("\tDisplay information about builtin commands.\n");
		System.out.println("\tDisplays brief summaries of builtin commands. If PATTERN is");
		System.out.println("\tspecified, gives detailed help on all commands matching PATTERN,");
		System.out.println("\totherwise the list of help topics is printed.\n");
		System.out.println("\tArguments:");
		System.out.println("\t PATTERN\tPattern specifying a help topic");
	}
	
	/**
	 * Messages output when command: "help" is run
	 */
	public void printHelpScreen() {
		System.out.println("Opal, version 0");
		System.out.println("Type 'help' to see this list.");
		System.out.println("Type 'help name' to find out more about the function 'name'.\n");
		System.out.println("A star (*) next to a name means that the command is disabled.\n");
		System.out.println(" account [-n] [pattern ...]");
		System.out.println(" exit");
		System.out.println(" help [pattern ...]");
		System.out.println("*login");
		System.out.println("*logout");
	}
	
	public void printWelcomeScreen() {
		System.out.println("Opal");
		System.out.println("A secure password manager.\n\n");
	}
	
	public void printUserPrompt() {
		System.out.print("opal> ");
	}
}
