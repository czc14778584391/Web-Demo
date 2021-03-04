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
        	request.setAttribute("msg", "��ӳɹ���");
        	request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else {
        	request.setAttribute("msg", "�û������������Ѿ���ʹ�ã����������");
        	request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
	}

}
