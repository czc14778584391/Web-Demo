package com.czc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.page;
import com.czc.Model.type;
import com.czc.service.GoodsService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/admin/goods_list")
public class GoodsListServlet extends HttpServlet {
	  GoodsService gs=new GoodsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=0;
		if(request.getParameter("id")!=null) {
			id=Integer.parseInt(request.getParameter("id")); 
		}
			
		int pagenum=1;
		if(request.getParameter("pagenum")!=null) {
			pagenum=Integer.parseInt(request.getParameter("pagenum")); 
		}
		page p=null;
		
		try {
			p=gs.getPage(id, pagenum, 10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("p", p);
		request.setAttribute("typeid", id);
		request.getRequestDispatcher("/admin/goods_list.jsp").forward(request, response);
		
	}

	

}
