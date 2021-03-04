package com.czc.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.czc.Model.User;
import com.czc.service.UserService;

/**
 * Servlet implementation class userEdit2Servlet
 */
@WebServlet("/admin/user_Update")
public class userEdit2Servlet extends HttpServlet {
	
	UserService us=new UserService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId= Integer.parseInt(request.getParameter("id"));
		User user=new User();
		try {
			BeanUtils.copyProperties(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		us.updateReceive(user,userId);
		request.setAttribute("userid",userId);
	    request.setAttribute("Msg", "修改信息成功!");
		 request.getRequestDispatcher("/admin/user_edit.jsp").forward(request, response);
	   
	}
	

}
