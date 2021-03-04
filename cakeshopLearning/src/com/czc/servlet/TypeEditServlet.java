package com.czc.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.czc.Model.type;
import com.czc.dao.typeDao;
import com.czc.service.typeService;

/**
 * Servlet implementation class TypeListServlet
 */
@WebServlet("/admin/type_edit")
public class TypeEditServlet extends HttpServlet {
	
	typeService ts=new typeService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		type type=new type();
		try {
			BeanUtils.copyProperties(type, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ts.updateType( type);
		response.sendRedirect(request.getContextPath()+"/admin/goodstype_list");
		
	}


}
