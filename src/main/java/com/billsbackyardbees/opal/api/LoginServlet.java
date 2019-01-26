package com.billsbackyardbees.opal.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.billsbackyardbees.opal.bean.OpalUser;
import com.billsbackyardbees.opal.util.OpalUserDAO;

/**
 * Servlet implementation class HelloServlet
 * @author Gradle.org
 */
public class LoginServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			OpalUser user = new OpalUser();
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			
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
