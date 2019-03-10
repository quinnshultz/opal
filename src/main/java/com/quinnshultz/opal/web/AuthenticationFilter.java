package com.quinnshultz.opal.web;

import java.io.IOException;
import java.security.Principal;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

/**
 * Authenticates an OpalUser for use with the API.
 * @author Quinn Shultz, cassiomolin (StackOverflow)
 *
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
	
	private static final String REALM = "example";
	private static final String AUTHENTICATION_SCHEME = "SecretKey";

	/**
	 * Attempts to authenticate an user from their API token provided in the authorization header.
	 * 
	 * @param requestContext
	 * @throws IOException
	 */
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		// Get the Authorization header from the request
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		
		// Validate the Authorization header
		if (!isTokenBasedAuthentication(authorizationHeader)) {
			abortWithUnauthorized(requestContext);
			return;
		}
		
		// Extract the token from the Authorization header
		String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();
		
		// Validate the token
		try {
			validateToken(token);
			
			final SecurityContext currentSecurityContext = requestContext.getSecurityContext();
			requestContext.setSecurityContext(new SecurityContext() {
				
				@Override
				public Principal getUserPrincipal() {
					// TODO Return the OpalUser's name by searching for the provided token
					return null;
				}
				
				@Override
				public boolean isUserInRole(String role) {
					return true;
				}
				
				@Override
				public boolean isSecure() {
					return currentSecurityContext.isSecure();
				}

				@Override
				public String getAuthenticationScheme() {
					return AUTHENTICATION_SCHEME;
				}
			});
			
		} catch (Exception e) {
			abortWithUnauthorized(requestContext);
		}
	}
	
	/* (non-Javadoc)
	 * 
	 * Checks that a token is provided in the standard HTTP Authorization header of the request.
	 * 
	 * @param authorizationHeader Standard HTTP Authorization header provided by client
	 * @returns true if authorizationHeader is not null and begins with the AUTHENTICATION_SCHEME, false otherwise
	 */
	private boolean isTokenBasedAuthentication(String authorizationHeader) {
		return authorizationHeader != null && authorizationHeader.toLowerCase()
				.startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
	}
	
	/* (non-Javadoc)
	 * 
	 * Abort the filter chain with a 401 status code response.
	 * 
	 * @param requestContext HTTP request headers containing invalid authorization header
	 */
	private void abortWithUnauthorized(ContainerRequestContext requestContext) {
		requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
				.header(HttpHeaders.WWW_AUTHENTICATE, 
						AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"")
				.build());
	}
	
	private void validateToken(String token) throws Exception {
		// Check if the token was issued by the server and if it's not expired
		// Throw an Exception if the token is invalid
	}

}
