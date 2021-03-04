package com.czc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.User;
import com.czc.service.UserService;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/login_action")
public class AdminLoginServlet extends HttpServlet {
	
	UserService us=new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String un=request.getParameter("username");
		String password =request.getParameter("password");
		
		User user=us.adminLogin(un, password);
		if(user==null) {
			request.setAttribute("loginMsg", "登录信息不正确，或用户满意管理员权限，请重新登录！");
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("userSession", user);
			request.getRequestDispatcher("/admin/admin_index.jsp").forward(request, response);
		}
		
	}

}
