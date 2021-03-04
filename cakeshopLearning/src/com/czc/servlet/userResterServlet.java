package com.czc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userResterServlet
 */
@WebServlet("/admin/user_reset")
public class userResterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId= Integer.parseInt(request.getParameter("id"));
		String issuccess=request.getParameter("issuccess");
		if(issuccess!=null) {
			request.setAttribute("Msg", "ÐÞ¸ÄÃÜÂë³É¹¦!");
		}
		request.setAttribute("userid", userId);
		request.getRequestDispatcher("/admin/user_reset.jsp").forward(request, response);
	}



}
