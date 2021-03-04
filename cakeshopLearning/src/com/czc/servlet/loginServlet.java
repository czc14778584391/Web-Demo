package com.czc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.User;
import com.czc.service.UserService;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	UserService us=new UserService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String un=request.getParameter("un");
		String password =request.getParameter("password");
		
		User user=us.userLogin(un, password);
		if(user==null) {
			request.setAttribute("loginMsg", "登录信息不正确，请重新登录！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("userSession", user);
		
			request.getRequestDispatcher("/mycenter.jsp").forward(request, response);
		}
		
	
	}

}
