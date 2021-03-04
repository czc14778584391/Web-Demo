package com.czc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.page;
import com.czc.service.GoodsService;

/**
 * Servlet implementation class goodsList_Recommendservlet
 */
@WebServlet("/goodsList_Recommend")
public class goodsList_Recommendservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsService gs=new GoodsService();
		
		int type= Integer.parseInt(request.getParameter("typeid"));
		
		int pagenum=1;	
		if(request.getParameter("pagenum")!=null) {
			pagenum=Integer.parseInt(request.getParameter("pagenum"));
		}
		
		page p=null;
		try {
		 p=	gs.getRecommendPage(type, pagenum, 8);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("type", type);
		request.setAttribute("p", p);
		request.getRequestDispatcher("/goodsRecommendlist.jsp").forward(request, response);
		
	}

}
