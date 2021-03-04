package com.czc.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.service.GoodsService;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	 GoodsService gs=new GoodsService();
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		��ȡ������Ʒ 
		List<Map<String, Object>> hotlist=gs.getGoodsList(2);
		request.setAttribute("hotGoods", hotlist);
//		��ȡ��Ʒ		
		List<Map<String, Object>> newList=gs.getGoodsList(3);
		request.setAttribute("newGoods", newList);
//  ��ȡ�����Ʒ
		Map<String, Object>map=gs.getScorllGood();
		request.setAttribute("scorllGood", map);
//��ת����ҳ		
	    request.getRequestDispatcher("/index.jsp").forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
