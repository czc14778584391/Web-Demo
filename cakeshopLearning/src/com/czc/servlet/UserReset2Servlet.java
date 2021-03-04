package com.czc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.service.UserService;

/**
 * Servlet implementation class UserResetServlet
 */
@WebServlet("/admin/user_Re")
public class UserReset2Servlet extends HttpServlet {
    
	UserService us=new UserService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId= Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
        us.resetpassword(userId,password);		
        
 		response.sendRedirect(request.getContextPath()+"/admin/user_reset?issuccess=true&id="+userId);
	}

}
