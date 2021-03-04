package com.czc.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czc.Model.page;
import com.czc.service.GoodsService;

/**
 * Servlet implementation class searchGoodsServlet
 */
@WebServlet("/search_goods")
public class searchGoodsServlet extends HttpServlet {
	
	    GoodsService GS=new GoodsService();
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String keywold=request.getParameter("Keywold");
        page p=null;
		try {
			p = GS.getSearchPage(keywold);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("p", p);
		request.setAttribute("keywold",keywold);
		request.getRequestDispatcher("/searchGoods.jsp").forward(request, response);
	}

}
