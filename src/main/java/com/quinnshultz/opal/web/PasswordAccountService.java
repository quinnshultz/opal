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
package com.quinnshultz.opal.web;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import com.quinnshultz.opal.bean.OpalUser;
import com.quinnshultz.opal.bean.PasswordAccount;
import com.quinnshultz.opal.db.PasswordAccountDAO;

/**
 * @author Quinn Shultz
 */
@Path("/passwordaccount")
public class PasswordAccountService {
	
	/**
	 * Loads the first 100 password accounts from the users view
	 */
	@GET
	@Produces("application/xml")
	public String loadFirstAccounts() {
		
		// Temporary
		String opalUsername = "johndoe";
		int paId = 0;
		String paUrl = "https://accounts.spotify.com/en/login";
		String paName = "Spotify";
		String paUsername = "johndoe";
		String paPassword = "6P%#aHTC9K1YhVl$";
		String paNotes = "A music streaming service.";
		
		return "<opalpa>" +
					"<opalname>" + opalUsername + "</opalname>" +
					"<paparams>" +
						"<id>" + paId + "</id>" +
						"<url>" + paUrl + "</url>" +
						"<name>" + paName + "</name>" +
						"<username>" + paUsername + "</username>" +
						"<password>" + paPassword + "</password>" +
						"<notes>" + paNotes + "</notes>" +
					"</paparams>" +
		"</opalpa>";
	}
	
	/**
	 * Attempts to find the PasswordAccount given its name
	 * @return
	 */
	@Path("/search")
	@GET
	@Produces("application/xml")
	public String findAccount(@QueryParam("name") String name) {
//		// Get OpalUser username and PasswordAccount name
//		Principal principal = securityContext.getUserPrincipal();
//		String opalUsername = principal.getName();
//		
//		// Construct OpalUser and PasswordAccount Objects and set instance variables with above values
//		OpalUser opalUser = new OpalUser();
//		opalUser.setUsername(opalUsername);
		PasswordAccount passwordAccount = new PasswordAccount();
//		passwordAccount.setOpalUser(opalUsername);
		passwordAccount.setName(name);
//		
//		PasswordAccountDAO paDAO = new PasswordAccountDAO();
//		
//		try {
//			paDAO.connect();
//			passwordAccount = paDAO.findAccount(opalUser, passwordAccount);
//			paDAO.disconnect();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		String outputID = "\n\nID: \n\n" + passwordAccount.getId();
//		String outputURL = "\n\nURL: \n\n" + passwordAccount.getUrl();
//		String outputName = "\n\nName: \n\n" + name;
//		String outputUsername = "\n\nUsername: \n\n" + passwordAccount.getUsername();
//		// TODO Pass the appropriate SecretKey to decipher password
//		String outputPassword = "\n\nPassword: \n\n" + passwordAccount.getData(null);
//		String outputNotes = "\n\nUsername: \n\n" + passwordAccount.getUsername();
//		String result = "@Produces(\"application/xml\") Output: " + outputName;

		return "<opalpa>" +
					"<opalname>" + "nullfortesting" + "</opalname>" +
					"<paparams>" +
						"<id>" + "nullfortesting" + "</id>" +
						"<url>" + "nullfortesting" + "</url>" +
						"<name>" + passwordAccount.getName() + "</name>" +
						"<username>" + "nullfortesting" + "</username>" +
						"<password>" + "nullfortesting" + "</password>" +
						"<notes>" + "nullfortesting" + "</notes>" +
					"</paparams>" +
				"</opalpa>";
	}

}
