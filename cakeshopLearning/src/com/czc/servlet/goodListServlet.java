package com.czc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.Goods;
import com.czc.Model.page;
import com.czc.Model.type;
import com.czc.service.GoodsService;
import com.czc.service.typeService;

/**
 * Servlet implementation class goodListServlet
 */
@WebServlet("/goods_List")
public class goodListServlet extends HttpServlet {
	    GoodsService gs=new GoodsService();
		typeService ts=new typeService();
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
			 p= gs.getPage(id, pagenum, 8);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("p", p);
		request.setAttribute("id", id);
		
		if(id!=0) {
			type t=ts.gettypeNmae(id);
			request.setAttribute("getTypeName", t);
		}
		
		request.getRequestDispatcher("/goodslist.jsp").forward(request, response);
		
	}
  
}
