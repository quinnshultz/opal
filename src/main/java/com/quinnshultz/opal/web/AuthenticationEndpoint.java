package com.quinnshultz.opal.web;

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
@Path("/authentication")
public class AuthenticationEndpoint {

	/**
	 * 
	 * @param opalUser OpalUser Object containing credentials
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
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
			return Response.ok(token).build();
			
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
	 * @return API session token for user
	 */
	private String issueToken(OpalUser opalUser) {
		UUID uid = UUID.randomUUID();
		String token = uid.toString();
		
		// TODO Store token
		return token;
	}
}
