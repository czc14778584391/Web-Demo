package com.czc.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.czc.Model.Order;
import com.czc.Model.User;
import com.czc.service.OrderService;

/**
 * Servlet implementation class orderPayServlet
 */
@WebServlet("/order_pay")
public class orderPayServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  OrderService oSrevice=new OrderService();
		Order o=(Order) request.getSession().getAttribute("order");
		try {
			BeanUtils.copyProperties(o, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		o.setDatetime(new Date());
		o.setStatus(2);
		o.setUser((User)(request.getSession().getAttribute("userSession")));
		oSrevice.addOrder(o);
		request.setAttribute("Msg", "订单支付成功");
		request.getSession().removeAttribute("order");
		request.getRequestDispatcher("/paysuccess.jsp").forward(request, response);     
		
	}

}
