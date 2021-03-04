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
 * Servlet implementation class updatePasswordServlet
 */
@WebServlet("/user_updatePassword")
public class updatePasswordServlet extends HttpServlet {

	UserService us=new UserService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String password=request.getParameter("password");
		String newPassword=request.getParameter("newPassword");
		
		User user=(User) request.getSession().getAttribute("userSession");
		
		if(password.equals(user.getPassword())) {
			user.setPassword(newPassword);
			us.updatePassword(user);
			request.setAttribute("successMsg", "�޸ĳɹ���");
			
		}else {
			request.setAttribute("failMsg", "����ԭ���벻��ȷ������������");
			
		}
		request.getRequestDispatcher("/mycenter.jsp").forward(request, response);
	}

}
