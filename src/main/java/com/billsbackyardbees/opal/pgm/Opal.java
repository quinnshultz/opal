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
package com.billsbackyardbees.opal.pgm;

import java.sql.ResultSet;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.billsbackyardbees.opal.util.DataLoader;
import com.billsbackyardbees.opal.util.PasswordAccount;
import com.billsbackyardbees.opal.util.Screamer;

/**
 * A secure password manager.
 * 
 * @author Quinn Shultz
 */
public class Opal {

	private static ResultSet rs;
	private static Screamer typewriter;
	private static DataLoader dbInteractor;
	private static Scanner cmdPrompt;
	private static String userInput;

	/**
	 * The program begins executing here.
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		// Initialize variables
		typewriter = new Screamer();
		cmdPrompt = new Scanner(System.in);
		userInput = "";
		
		// Print first user prompt
		typewriter.printUserPrompt();
		
		while(opalLooper()) {
			StringTokenizer stt = new StringTokenizer(userInput);
			int numtokens = stt.countTokens();
			String command_arg[] = new String[numtokens];
			
			int i = 0;
			while (stt.hasMoreTokens()) {
				command_arg[i] = stt.nextToken();
				i++;
			}
			
			if (numtokens >= 1) {
				
				// User enters "help" command
				if (command_arg[0].contentEquals("help")) {
					if (numtokens >= 2) {
						
						for (int j = 1; j < numtokens; j++) {
							
							if (command_arg[1].contentEquals("help")) {
								typewriter.printHelpHelp();
							} else if (command_arg[1].contentEquals("account")) {
								typewriter.printAccountHelp();
							} else if (command_arg[1].contentEquals("exit")) {
								typewriter.printExitHelp();
							} else if (command_arg[1].contentEquals("login")) {
								typewriter.printLoginHelp();
							} else if (command_arg[1].contentEquals("logout")) {
								typewriter.printLogoutHelp();
							} else {
								System.out.println("Unrecognized command: " + command_arg[1]);
							} 
						}
						
					} else if (numtokens == 1) {
						typewriter.printHelpScreen();
					}

					// User enters "account" command
				} else if (command_arg[0].contentEquals("account")) {
					if (numtokens == 3) {

						if (command_arg[1].contentEquals("-n")) {
							System.out.println("Adding account: " + command_arg[2]);

							PasswordAccount accountStore = new PasswordAccount();
							accountStore.setName(command_arg[2]);
						}

					} else {
						System.out.println("Incorrect number of arguments for command: account");
					}
					
					// User enters "login" command
				} else if (command_arg[0].contentEquals("login")) {
					if (numtokens == 2) {
						
						opalLogin(command_arg[0]);
					} else {
						System.out.println("Incorrect number of arguments for command: login");
					}
				}
			}
			
			typewriter.printUserPrompt();

		}
	}
	
	public static void opalLogin(String opalUsername) {
		int opalUserId = -1;					// TODO: Use this method to find the id of an user from their username
		dbInteractor = new DataLoader(opalUserId);
	}
	
	/**
	 * Gets users input
	 * @return
	 */
	public static boolean opalLooper() {
		userInput = cmdPrompt.nextLine();
		if (userInput.contentEquals("exit")) {
			return false;
		} else {
			return true;
		}
	}

}
