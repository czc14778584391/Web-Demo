package com.czc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.service.GoodsService;

/**
 * Servlet implementation class AdminDeleteGoodsServlet
 */
@WebServlet("/admin/delete_goods")
public class AdminDeleteGoodsServlet extends HttpServlet {
	GoodsService gService=new GoodsService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int typeid=Integer.parseInt(request.getParameter("type")); 
		 int pagenum=Integer.parseInt(request.getParameter("pagenum")); 
		 int goodsId=Integer.parseInt(request.getParameter("goodsId"));	
		 gService.deleteGoods(goodsId);
		 
		 request.getRequestDispatcher("/admin/goods_list?id="+typeid+"&pagenum="+pagenum).forward(request, response);
		 
	}

	

}
