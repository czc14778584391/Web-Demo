package com.czc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.Goods;
import com.czc.Model.Order;
import com.czc.service.GoodsService;

/**
 * Servlet implementation class userAddGoodsServlet
 */
@WebServlet("/user_addGoods")
public class userAddGoodsServlet extends HttpServlet {
     GoodsService gs=new GoodsService();
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		  int goodsId= Integer.parseInt(request.getParameter("goodsid")) ; 
		
		  Order o= null;
				  
		  if(request.getSession().getAttribute("order")!=null) {
			  o=(Order)request.getSession().getAttribute("order"); 
		  }else {
			 o=new Order();
			 request.getSession().setAttribute("order", o);
		  } 
		  
	Goods g=gs.getGooddetail(goodsId);	 
	
	if(g.getStock()>0) {
		
		o.addGoods(g);
		response.getWriter().print("ok");
	}else {
		response.getWriter().print("fail");
	}
	
	
	}

}
