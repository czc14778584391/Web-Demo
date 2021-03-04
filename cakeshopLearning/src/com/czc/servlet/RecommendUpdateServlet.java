package com.czc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.service.typeService;

/**
 * Servlet implementation class RecommendUpdateServlet
 */
@WebServlet("/admin/recommend_update")
public class RecommendUpdateServlet extends HttpServlet {
	typeService ts=new typeService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id")); 
	
		int pagenum=Integer.parseInt(request.getParameter("pagenum")); 
		
		int typeTarget=Integer.parseInt(request.getParameter("typeTarget")); 
		int typeid=Integer.parseInt(request.getParameter("type")); 
		String method=request.getParameter("method");
		
		if(method.equals("add")) {
			ts.addRecommendGoods(id, typeTarget);
			
		}
		if(method.equals("remove")) {
			ts.removeRecommendGoods(id, typeTarget);
		}
		
		request.getRequestDispatcher("/admin/goods_list?id="+typeid+"&pagenum="+pagenum).forward(request, response);
		
		
	}

	

}
