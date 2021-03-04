package com.czc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.czc.Model.Order;
import com.czc.Model.OrderItem;
import com.czc.Model.User;
import com.czc.Utils.DButils;

import java.math.BigInteger;
import java.sql.Connection;

public class OrderDao {

	public void insertOrder(Order order,Connection con) throws SQLException {
		
		QueryRunner r=new QueryRunner();
		String sql="insert into `order` (name,address,amount,datetime,paytype,phone,status,total,user_id) values(?,?,?,?,?,?,?,?,?)";
		r.update(con,sql,order.getName(),order.getAddress(),order.getAmount(),
				order.getDatetime(),order.getPaytype(),order.getPhone(),order.getStatus(),
				order.getTotal(),order.getUser().getId());
		
	}
	
	public void insertOrderItem(OrderItem OI,Connection con) throws SQLException {
		QueryRunner r=new QueryRunner();
		String sql="insert into orderitem(amount,price,goods_id,order_id) values(?,?,?,?)";
		r.update(con,sql,OI.getAmount(),OI.getPrice(),OI.getGoods().getId(),OI.getOrder().getId());	
	}
	
	public int getLastInsertId(Connection con) throws SQLException {
		QueryRunner r=new QueryRunner();
		String sql = "select last_insert_id()";
		BigInteger res = r.query(con, sql,new ScalarHandler<BigInteger>());
          return   Integer.parseInt(res.toString());
	}
	
	
	public List<Order> selectAll(int userid) {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="select * from `order` where user_id=? order by datetime desc";
		
		 List<Order> orderList=null;
	 	try {
			orderList=r.query(sql,new BeanListHandler<Order>(Order.class),userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}
	
	public List<OrderItem> selectAllItem(int orderid) throws SQLException{
		QueryRunner r = new QueryRunner(DButils.getDataSoure());
		String sql = "select i.id,i.price,i.amount,g.name from orderitem i,goods g where order_id=? and i.goods_id=g.id";
		return r.query(sql, new BeanListHandler<OrderItem>(OrderItem.class),orderid);
	}

	public List selectOrderList(int status, int pagenum, int pageSize) throws SQLException {
		QueryRunner r = new QueryRunner(DButils.getDataSoure());
		
		if(status==0) {
		String	sql="select o.id,o.total,o.amount,o.status,o.paytype,o.name,o.phone,o.address,o.datetime,u.username from `order` o,user u where o.user_id=u.id order by o.datetime desc limit ?,?";
		return r.query(sql, new BeanListHandler<Order>(Order.class),(pagenum-1)*pageSize,pageSize);
		}else {
		String 	sql="select o.id,o.total,o.amount,o.status,o.paytype,o.name,o.phone,o.address,o.datetime,u.username from `order` o,user u where o.status=? and o.user_id=u.id order by o.datetime desc limit ?,?";
		return r.query(sql, new BeanListHandler<Order>(Order.class),status,(pagenum-1)*pageSize,pageSize);
		}
		
		
	}

	public int getOrderCount(int status) throws SQLException {
		QueryRunner r = new QueryRunner(DButils.getDataSoure());
		if(status==0) {
			String sql="select count(*) from `order`";
			return r.query(sql, new ScalarHandler<Long>()).intValue();
		}else {
			String sql="select count(*) from `order` where status=?";
			return r.query(sql, new ScalarHandler<Long>(),status).intValue();
		}
	}
	
	public void updateOrderStatus(int orderId,int status) throws SQLException {
		QueryRunner r = new QueryRunner(DButils.getDataSoure());
		String sql="update `order` set status=? where id=?";
		r.update(sql,status,orderId);
	}
	
	public void removeOrder(int orderId) throws SQLException {
		QueryRunner r = new QueryRunner(DButils.getDataSoure());
        String sql1="delete from orderitem  where order_id=?";
        r.update(sql1,orderId);
		String sql="delete  from `order` where id=?";
		r.update(sql,orderId);
	}
}
