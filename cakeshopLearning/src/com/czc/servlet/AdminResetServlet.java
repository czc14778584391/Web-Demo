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
 * Servlet implementation class AdminResetServlet
 */
@WebServlet("/admin/admin_Reset")
public class AdminResetServlet extends HttpServlet {
	UserService us=new UserService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("password");
		String newPassword=request.getParameter("passwordNew");
		
		User user=(User) request.getSession().getAttribute("userSession");
		
		if(password.equals(user.getPassword())) {
			user.setPassword(newPassword);
			us.updatePassword(user);
			request.setAttribute("msg", "修改成功！");
		}else {
			request.setAttribute("msg", "输入原密码不正确！请重新输入");
			
		}
		request.getRequestDispatcher("/admin/admin_reset.jsp").forward(request, response);
	}
	

}
