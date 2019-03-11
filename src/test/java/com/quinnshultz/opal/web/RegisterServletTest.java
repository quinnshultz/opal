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

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Ignore;

/**
 * Tests RegisterServlet with mock Objects
 * @author Quinn Shultz
 *
 */
public class RegisterServletTest {
	
	private final String LOGIN_PAGE_JSP = "LoginPage.jsp";
	private final String REGISTER_PAGE_JSP = "RegisterPage.jsp";
	
	private final String EXAMPLE_USERNAME = "johndoe";
	private final String EXAMPLE_FULL_NAME = "John Doe";
	private final String EXAMPLE_PASSWORD = "47OLdsMd5%!ELIwr";
	
	@Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;

    /**
     * Constructs mock HttpServletRequest, HttpServletResponse, and RequestDispatcher Objects
     * @throws Exception
     */
    @Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

    /**
     * Tests the doGet() method with a valid request and verifies response
     * @throws Exception
     */
    @Test
    public void testDoGet() throws Exception {
        // Fill Servlet params
    	 when(request.getParameter("username")).thenReturn(EXAMPLE_USERNAME);
    	 when(request.getParameter("fullname")).thenReturn(EXAMPLE_FULL_NAME);
    	 when(request.getParameter("password")).thenReturn(EXAMPLE_PASSWORD);

         // Forward mock request to doGet() and receive mock response
         new RegisterServlet().doGet(request, response);

         // Verify request was forwarded and mock request dispatcher redirects us to the LOGIN_PAGE_JSP response page
         verify(response).sendRedirect(LOGIN_PAGE_JSP);
    }
    
    /**
     * Tests the doGet() method with a request missing the fullname parameter and verifies response
     * @throws Exception
     */
    @Test
    public void testDoGetWithoutFullname() throws Exception {
        // Fill Servlet params
    	 when(request.getParameter("username")).thenReturn(EXAMPLE_USERNAME);
    	 when(request.getParameter("password")).thenReturn(EXAMPLE_PASSWORD);

         // Forward mock request to doGet() and receive mock response
         new RegisterServlet().doGet(request, response);

         // Verify request was forwarded and mock request dispatcher redirects us to the LOGIN_PAGE_JSP response page
         verify(response).sendRedirect(LOGIN_PAGE_JSP);
    }
	
    /**
     * Tests the doGet() method with a request missing the username parameter and verifies response shows that this is invalid
     * @throws Exception
     */
    @Ignore("Temporarily disabled while production code catches up")
    @Test
    public void testDoGetWithoutUsername() throws Exception {
        // Fill Servlet params
    	 when(request.getParameter("fullname")).thenReturn(EXAMPLE_FULL_NAME);
    	 when(request.getParameter("password")).thenReturn(EXAMPLE_PASSWORD);

         // Forward mock request to doGet() and receive mock response
         new RegisterServlet().doGet(request, response);

         // Verify request was forwarded and mock request dispatcher leaves us on the REGISTER_PAGE_JSP page
         verify(response).sendRedirect(REGISTER_PAGE_JSP);
    }
    
    /**
     * Tests the doGet() method with a request missing the password parameter and verifies response shows that this is invalid
     * @throws Exception
     */
    @Ignore("Temporarily disabled while production code catches up")
    @Test
    public void testDoGetWithoutPassword() throws Exception {
        // Fill Servlet params
    	 when(request.getParameter("username")).thenReturn(EXAMPLE_USERNAME);
    	 when(request.getParameter("fullname")).thenReturn(EXAMPLE_FULL_NAME);

         // Forward mock request to doGet() and receive mock response
         new RegisterServlet().doGet(request, response);

         // Verify request was forwarded and mock request dispatcher leaves us on the REGISTER_PAGE_JSP page
         verify(response).sendRedirect(REGISTER_PAGE_JSP);
    }
    
    /**
     * Tests the doGet() method with a request missing all parameters and verifies response shows that this is invalid
     * @throws Exception
     */
    @Ignore("Temporarily disabled while production code catches up")
    @Test
    public void testDoGetWithoutAnyParams() throws Exception {

         // Forward mock request to doGet() and receive mock response
         new RegisterServlet().doGet(request, response);

         // Verify request was forwarded and mock request dispatcher leaves us on the REGISTER_PAGE_JSP page
         verify(response).sendRedirect(REGISTER_PAGE_JSP);
    }

}
