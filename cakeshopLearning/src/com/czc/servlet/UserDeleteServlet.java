package com.czc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/admin/user_Delete")
public class UserDeleteServlet extends HttpServlet {
	UserService us=new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId= Integer.parseInt(request.getParameter("id"));
		us.deleteUser(userId);
		response.sendRedirect(request.getContextPath()+"/admin/user_List");
	}

	
}
