package com.czc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.Order;
import com.czc.Model.User;
import com.czc.service.OrderService;

/**
 * Servlet implementation class MyOrderServlet
 */
@WebServlet("/order_list")
public class MyOrderServlet extends HttpServlet {
	
private 	OrderService os=new OrderService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User u = (User) request.getSession().getAttribute("userSession");
		List<Order> list = os.selectAll(u.getId());
		request.setAttribute("list", list);
		request.getRequestDispatcher("/myorder.jsp").forward(request, response);
	}

	

}
