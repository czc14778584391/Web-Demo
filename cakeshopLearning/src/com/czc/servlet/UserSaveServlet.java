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
 * Servlet implementation class UserSaveServlet
 */
@WebServlet("/admin/user_Save")
public class UserSaveServlet extends HttpServlet {
	UserService US=new UserService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 User user=new User();
	     UserService US=new UserService();
			try {
				BeanUtils.copyProperties(user, request.getParameterMap());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        if(US.registerUser(user)) {
	        	request.setAttribute("msg", "注册成功！");
	        }else {
	        	request.setAttribute("msg", "用户名或者邮箱已经被使用，请重新添加");
	        }
	        request.getRequestDispatcher("/admin/user_add.jsp").forward(request, response);
	}

}
