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

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quinnshultz.opal.bean.OpalUser;
import com.quinnshultz.opal.db.OpalUserDAO;
import com.quinnshultz.opal.util.OpalSerializer;

/**
 * Servlet implementation class HelloServlet
 * @author Gradle.org
 */
public class LoginServlet extends HttpServlet {
	
	static final long serialVersionUID = OpalSerializer.getSerialVersionUID();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			OpalUser user = new OpalUser();
			user.setUsername(request.getParameter("username"));
			user.setPassword(null, request.getParameter("password"));
			
			user = OpalUserDAO.login(user);
			
			if (user.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser",user);
				response.sendRedirect("userLogged.jsp");//logged-in page
			} else {
				response.sendRedirect("invalidLogin.jsp");//error page
			}
		} catch (Throwable theException) {
			
		}
	}
}
