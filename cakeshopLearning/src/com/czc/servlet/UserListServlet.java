package com.czc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.page;
import com.czc.service.OrderService;
import com.czc.service.UserService;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/admin/user_List")
public class UserListServlet extends HttpServlet {
	UserService us=new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pagenum=1;
		if( request.getParameter("pagenum")!=null) {
			pagenum=  Integer.parseInt(request.getParameter("pagenum"));
		}
		page p=null;
		try {
			p=us.getUserPage(pagenum,7);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("p", p);
		request.getRequestDispatcher("/admin/user_list.jsp").forward(request, response);
		
		
	}
}
