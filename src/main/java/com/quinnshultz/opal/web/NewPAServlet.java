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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quinnshultz.opal.bean.OpalUser;
import com.quinnshultz.opal.bean.PasswordAccount;
import com.quinnshultz.opal.util.OpalSerializer;
import com.quinnshultz.opal.util.PasswordAccountDAO;

/**
 * Creates a new PasswordAccount when form is submitted
 */
@WebServlet("/NewPAServlet")
public class NewPAServlet extends HttpServlet {
	private static final long serialVersionUID = OpalSerializer.getSerialVersionUID();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		OpalUser currentUser = (OpalUser) (session.getAttribute("currentSessionUser"));
		PasswordAccount site = new PasswordAccount();
		// TODO: Might want to pass a OpalUser to PasswordAccount.setOpalUser() rather than a string
		site.setOpalUser(currentUser.getUsername());
		site.setUrl(request.getParameter("url"));
		site.setName(request.getParameter("name"));
		site.setUsername(request.getParameter("username"));
		site.setData(request.getParameter("password"), currentUser.getSerializedKey());
		response.sendRedirect("userLogged.jsp");
		site = PasswordAccountDAO.createAccount(currentUser, site);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
