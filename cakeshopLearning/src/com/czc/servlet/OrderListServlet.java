package com.czc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.page;
import com.czc.service.OrderService;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/admin/order_List")
public class OrderListServlet extends HttpServlet {
	OrderService os=new OrderService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int status= 0;
		if(request.getParameter("status")!=null) {
			status= Integer.parseInt(request.getParameter("status"));
		}
		
		int pagenum=1;
		if( request.getParameter("pagenum")!=null) {
			pagenum=  Integer.parseInt(request.getParameter("pagenum"));
		}
		page p=null;
		try {
			p=os.getOrderPage( status,pagenum,10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("status", status);
		request.setAttribute("p", p);
		request.getRequestDispatcher("/admin/order_list.jsp").forward(request, response);
	}
}
