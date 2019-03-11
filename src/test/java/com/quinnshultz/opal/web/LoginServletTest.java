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

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.quinnshultz.opal.bean.OpalUser;

/**
 * Tests LoginServlet with mock Objects
 * @author Quinn Shultz
 *
 */
public class LoginServletTest {
	
	private final String EXAMPLE_USERNAME = "johndoe";
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
    @Ignore("Not yet implemented")
	@Test
	public void testDoGet() throws Exception {
    	// Fill Servlet params
    	when(request.getParameter("username")).thenReturn(EXAMPLE_USERNAME);
   	 	when(request.getParameter("password")).thenReturn(EXAMPLE_PASSWORD);
    	
   	 	// Forward mock request to doGet() and receive mock response
        new LoginServlet().doGet(request, response);
	}
    

}
