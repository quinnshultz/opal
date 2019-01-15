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

import com.billsbackyardbees.opal.db.DBConnection;
import com.billsbackyardbees.opal.util.Messenger;

public class Opal {
	
	private static DBConnection connection;
	private static ResultSet rs;
	private static Messenger typewriter;
	private static Scanner cmdPrompt;
	private static String userInput;

	public static void main(String[] args) {
		// Initialize variables
		connection = new DBConnection();
		typewriter = new Messenger();
		cmdPrompt = new Scanner(System.in);
		userInput = "";
		
		// Print first user prompt
		typewriter.printUserPrompt();
		
		while(opalLooper()) {
			StringTokenizer stt = new StringTokenizer(userInput);
			
			if (stt.hasMoreTokens()) {
				
				String command = stt.nextToken();
				
				if (command.contentEquals("help")) {
					System.out.println("Help selected");
				} else if (command.contentEquals("account")) {
				
					if (stt.hasMoreTokens()) {
						
						String command_arg0 = stt.nextToken();
						
						if (command_arg0.contentEquals("new")) {
							System.out.println("Adding account: ");
					
						}
					} else {
						System.out.println("Missing argument(s)");
					}
				}
			}
			typewriter.printUserPrompt();
			

		}
	}
	
	/**
	 * Gets users input
	 * @return
	 */
	public static boolean opalLooper() {
		userInput = cmdPrompt.next();
		if (userInput.contentEquals("exit")) {
			return false;
		} else {
			return true;
		}
	}

}
