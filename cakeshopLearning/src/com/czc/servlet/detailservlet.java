package com.czc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.Goods;
import com.czc.service.GoodsService;



@WebServlet("/detail_servlet")
public class detailservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GoodsService gs=new GoodsService();
		
		int id= Integer.parseInt(request.getParameter("goodid"));
		
		Goods good=gs.getGooddetail(id);
		
		
		request.setAttribute("detail", good);
		
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
	}


}
