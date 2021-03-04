package com.czc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.Goods;
import com.czc.service.GoodsService;

/**
 * Servlet implementation class AdminUpdateGoodsServlet
 */
@WebServlet("/admin/update_goods")
public class AdminUpdateGoodsServlet extends HttpServlet {
	GoodsService gService=new GoodsService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	int goodsId= Integer.parseInt(request.getParameter("goodsId"));
	 
		Goods g= gService.getGooddetail(goodsId);
		request.setAttribute("g", g);
		
		request.getRequestDispatcher("/admin/goods_edit.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
