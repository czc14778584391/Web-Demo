package com.czc.Listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.czc.Model.type;
import com.czc.service.typeService;

/**
 * Application Lifecycle Listener implementation class applicationListener
 *
 */
@WebListener
public class applicationListener implements ServletContextListener {

    typeService tS=new typeService();
    
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

//	argO返回的是监控的页面   获取application 是 getservletContext
    public void contextInitialized(ServletContextEvent arg0)  { 
   
    	List<type>listType=tS.getTypeList();
    	arg0.getServletContext().setAttribute("typeList", listType);
    }
	
}
