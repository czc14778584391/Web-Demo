package com.czc.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import com.czc.Model.User;
import com.czc.service.UserService;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/user_register")
public class registerServlet extends HttpServlet {
	
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
        	request.setAttribute("msg", "添加成功！");
        	request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else {
        	request.setAttribute("msg", "用户名或者邮箱已经被使用，请重新添加");
        	request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
	}

}
