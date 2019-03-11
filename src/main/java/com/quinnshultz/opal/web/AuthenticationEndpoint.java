package com.quinnshultz.opal.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.quinnshultz.opal.bean.OpalUser;
import com.quinnshultz.opal.db.OpalUserDAO;;

/**
 * @author Quinn Shultz, cassiomolin (StackOverflow)
 */
@Path("/gettoken")
public class AuthenticationEndpoint {

	/**
	 * 
	 * @param opalUser OpalUser Object containing credentials
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@FormParam("username") String username, @FormParam("password") String password) {
		try {
			OpalUser opalUser = new OpalUser();
			opalUser.setUsername(username);
			opalUser.setPassword(password, password);
			// Authenticate the user using the OpalUser credentials
			authenticate(opalUser);
			
			// Issue a token for the user
			String token = issueToken(opalUser);
			
			// Return the token on the response
			String response = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + 
							"<authentication>" +
								"<username>" + opalUser.getUsername() + "</username>" +
								"<token>" + token + "</token>" +
							"</authentication>";
			
			return Response.ok(response).build();
			
		} catch (Exception e) {
			return Response.status(Response.Status.FORBIDDEN).build();
		}
	}
	
	/* (non-Javadoc)
	 * 
	 * Checks that the credentials provided exists in the database
	 * 
	 * @param opalUser OpalUser Object containing credentials
	 * @throws Exception if an error occurs or if the OpalUser is invalid
	 */
	private void authenticate(OpalUser opalUser) throws Exception {
		OpalUserDAO userDAO = new OpalUserDAO();
		userDAO.connect();
		opalUser = userDAO.login(opalUser);
		userDAO.disconnect();
		
		if (!opalUser.isValid()) {
			throw new Exception();
		}
	}
	
	/* (non-Javadoc)
	 * 
	 * Issue a api session token for the user so credentials do not need to be passed back and forth
	 * 
	 * @param opalUser OpalUser Object containing credentials
	 * @return API session token for user or empty string if token could not be stored to the database
	 */
	private String issueToken(OpalUser opalUser) {
		// Generate token
		UUID uid = UUID.randomUUID();
		String token = uid.toString();
		
		// Store to database
		OpalUserDAO userDAO = new OpalUserDAO();
		
		try {
			userDAO.connect();
			userDAO.storeAPIToken(opalUser, token, "3000-01-01");
			userDAO.disconnect();
			return token;
		} catch (SQLException e) {
			return "";
		} catch (ClassNotFoundException e) {
			return "";
		} catch (IOException e) {
			return "";
		}
	}
}
