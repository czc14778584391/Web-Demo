package com.czc.service;

import java.sql.SQLException;
import java.util.List;

import com.czc.Model.Order;
import com.czc.Model.OrderItem;
import com.czc.Model.page;
import com.czc.Utils.DButils;
import com.czc.dao.OrderDao;
import java.sql.Connection;

public class OrderService {
   
	OrderDao oDao=new OrderDao();
	
	public void addOrder(Order order)  {
		
		Connection con=null;
		try {
			con=DButils.getConnection();
			
			oDao.insertOrder(order, con);
			order.setId(oDao.getLastInsertId(con));
			con.setAutoCommit(false);
			for(OrderItem item:order.getMap().values()) {
				
				oDao.insertOrderItem(item, con);
				}
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	     }
}
	public List<Order> selectAll(int userid){
		List<Order> list=null;
		try {
			list = oDao.selectAll(userid);
			for(Order o :list) {
				List<OrderItem> l = oDao.selectAllItem(o.getId());
				o.setOrderList(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public page getOrderPage(int status, int pagenum,int pageSize) throws SQLException  {
		  page p=new page();
		  p.setPagenum(pagenum);
		  p.setPageSize(pageSize);
		  int totalCount=oDao.getOrderCount(status);
	      p.setTotalCount(totalCount);
	      p.setPageSizeAndTotalCount(pageSize, totalCount);
	      List orderList=oDao.selectOrderList(status, pagenum, pageSize);
	      for(Order order:(List<Order>)orderList) {
	    	  List itemList=oDao.selectAllItem(order.getId());
	    	  order.setOrderList(itemList);
	      }
	      p.setList(orderList);
	      return p;
	}
	
	public void updateOrderStatus(int orderId,int status) {
		if(status==0) {
			try {
				oDao.removeOrder(orderId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			oDao.updateOrderStatus(orderId, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
