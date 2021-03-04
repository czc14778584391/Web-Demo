package com.czc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.service.OrderService;

/**
 * Servlet implementation class orderDisposeSelvlet
 */
@WebServlet("/admin/order_status")
public class orderStatusSelvlet extends HttpServlet {
	
	OrderService os=new OrderService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   int orderId=Integer.parseInt(request.getParameter("id"));
	   int status=Integer.parseInt(request.getParameter("status"));
	   os.updateOrderStatus(orderId, status);
	   response.sendRedirect(request.getContextPath()+"/admin/order_List?status="+status);
	}
	
}
