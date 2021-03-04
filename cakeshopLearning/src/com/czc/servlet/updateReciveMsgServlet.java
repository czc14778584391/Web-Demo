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
import com.czc.service.GoodsService;
import com.czc.service.UserService;

/**
 * Servlet implementation class updateReciveMsg
 */
@WebServlet("/user_updateReceive")
public class updateReciveMsgServlet extends HttpServlet {
	
	UserService us=new UserService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");	
	User user=(User)request.getSession().getAttribute("userSession");
		
	try {
		BeanUtils.copyProperties(user, request.getParameterMap());
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	        us.updateReceiveMsg(user);
		   request.setAttribute("UpMsg", "修改收货信息成功！");
	       request.getRequestDispatcher("/mycenter.jsp").forward(request, response);
	  
	}

}
