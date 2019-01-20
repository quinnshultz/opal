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

import java.util.Scanner;
import java.util.StringTokenizer;

import com.billsbackyardbees.opal.util.DataLoader;
import com.billsbackyardbees.opal.util.OpalUserAuthenticator;
import com.billsbackyardbees.opal.util.PasswordAccount;
import com.billsbackyardbees.opal.util.Screamer;

/**
 * A secure password manager.
 * 
 * @author Quinn Shultz
 */
public class Opal {

	private static Screamer typewriter;
	private static DataLoader dbInteractor;
	private static OpalUserAuthenticator currentUser;
	private static Scanner cmdPrompt;
	private static String userInput;

	/**
	 * The program begins executing here.
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		// Initialize variables
		typewriter = new Screamer();
		dbInteractor = new DataLoader();
		currentUser = new OpalUserAuthenticator("");
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
							} else if (command_arg[1].contentEquals("register")) {
								typewriter.printRegisterHelp();
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
						if (currentUser.getOpalUser() != "") {
							if (command_arg[1].contentEquals("-n")) {

								// Construct new PasswordAccount to upload to the database
								PasswordAccount accountStore = new PasswordAccount();
								accountStore.setName(command_arg[2]);
								accountStore.setOpalUser(currentUser.getOpalUser());
								System.out.print("Enter URL for " + command_arg[2] + ":");
								accountStore.setUrl(cmdPrompt.nextLine());
								System.out.print("Enter username for " + command_arg[2] + ":");
								accountStore.setUsername(cmdPrompt.nextLine());
								System.out.print("Enter password for " + command_arg[2] + ":");
								accountStore.setEncryptedData(cmdPrompt.nextLine());
								System.out.print("Enter notes for " + command_arg[2] + ":");
								accountStore.setNotes(cmdPrompt.nextLine());

								dbInteractor.UploadPasswordAccount(accountStore);
								
								System.out.println("Adding account: " + command_arg[2]);
								
							} else if (command_arg[1].contentEquals("-d")) {
							
								// "Build" PasswordAccount to be deleted
								PasswordAccount accountStore = new PasswordAccount();
								accountStore.setName(command_arg[2]);
								accountStore.setOpalUser(currentUser.getOpalUser());
								
								dbInteractor.DeletePasswordAccount(accountStore);
								
								System.out.println("Deleted account: " + command_arg[2] + " from database user: " + currentUser.getOpalUser());
							}
						} else {
							System.out.println("You must first login!");
						}

					} else {
						System.out.println("Incorrect number of arguments for command: account");
					}
					
					// User enters "login" command
				} else if (command_arg[0].contentEquals("login")) {
					if (numtokens == 2) {
						
						System.out.print("Enter password for " + command_arg[1] + ":");
						String masterPassword = cmdPrompt.nextLine();
						opalLogin(command_arg[1], masterPassword);
					} else {
						System.out.println("Incorrect number of arguments for command: login");
					}
					
					// User enters "logout" command
				} else if (command_arg[0].contentEquals("logout")) {
					if (numtokens == 1) {
						opalLogout();
					} else {
						System.out.println("Incorrect number of arguments for command: logout");
					}
					
					// Opal does not recognize the command entered
				} else {
					System.out.println(command_arg[0] + ": command not found");
				}
			}
			
			typewriter.printUserPrompt();

		}
	}
	
	/**
	 * Login to password manager
	 * @param opalUsername
	 * @param privateKey
	 */
	public static void opalLogin(String opalUsername, String privateKey) {
		if (currentUser.getOpalUser() == "") {
			currentUser = new OpalUserAuthenticator(opalUsername);
			currentUser.unlockAccount(privateKey);
		} else {
			System.out.println("User is already logged in.");
		}
	}
	
	/**
	 * Logout of password manager
	 */
	public static void opalLogout() {
		currentUser = new OpalUserAuthenticator("");
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
