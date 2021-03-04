package com.czc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.Order;

/**
 * Servlet implementation class userLessenServlet
 */
@WebServlet("/user_lessen")
public class userLessenServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int goodsId= Integer.parseInt( request.getParameter("goodsid"));
	    Order order=  (Order) request.getSession().getAttribute("order");
		order.lessen(goodsId);
		response.getWriter().print("ok");
	}

}
