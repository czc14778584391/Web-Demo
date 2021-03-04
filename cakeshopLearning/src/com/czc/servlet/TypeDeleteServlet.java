package com.czc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.service.typeService;

/**
 * Servlet implementation class TypeDeleteServlet
 */
@WebServlet("/admin/type_Delete")
public class TypeDeleteServlet extends HttpServlet {
	typeService ts=new typeService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int typeId=Integer.parseInt(request.getParameter("id"));
		
		ts.deleteType(typeId);
		response.sendRedirect(request.getContextPath()+"/admin/goodstype_list");
	}

}
