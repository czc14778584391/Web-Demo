package com.czc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.User;

/**
 * Servlet implementation class orderSubmitServlet
 */
@WebServlet("/order_submit")
public class orderSubmitServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	   User user= (User) request.getSession().getAttribute("userSession");
	   if(request.getSession().getAttribute("order")==null) {
			 request.setAttribute("failMsg", "���Ĺ��ﳵ��û����Ʒ���������Ʒ���ύ��");
			 request.getRequestDispatcher("/cart.jsp").forward(request, response);
		 }
	  if(user!=null) {
		
		  request.getRequestDispatcher("/pay.jsp").forward(request, response);
		 
	  }else {
		  request.setAttribute("loginMsg", "���¼���ύ������");
		  request.getRequestDispatcher("/login.jsp").forward(request, response);
	  }
	
		
	}

}
