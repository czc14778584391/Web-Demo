package com.czc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.type;
import com.czc.service.typeService;

/**
 * Servlet implementation class goodsTypeListServlet
 */
@WebServlet("/admin/goodstype_list")
public class goodsTypeListServlet extends HttpServlet {

	typeService ts=new typeService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<type>typeList=ts.getTypeList();
		request.setAttribute("TList", typeList);
		request.getRequestDispatcher("/admin/goodstype_list.jsp").forward(request, response);
	}


}
