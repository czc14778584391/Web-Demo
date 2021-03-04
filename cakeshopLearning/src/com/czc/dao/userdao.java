package com.czc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.czc.Model.User;
import com.czc.Utils.DButils;

public class userdao {

	public boolean setUser(User user) {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		
	    String sql="insert into user(username,email,password,name,phone,address,isadmin,isvalidate) values(?,?,?,?,?,?,?,?)";
		try {
			r.update(sql,user.getUsername(),user.getEmail(),user.getPassword(),user.getName(),user.getPhone(),user.getAddress(),user.isIsadmin(),user.isIsvalidate());
		    return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}
	
	public boolean isExitsUserName(String username) {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="select * from user where username=?";
		User user=null;
		try {
			 user=r.query(sql, new BeanHandler<User>(User.class),username);
			 if(user!=null) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isExitsUserEmail(String Email) {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="select * from user where email=?";
		User user=null;
		try {
			 user=r.query(sql, new BeanHandler<User>(User.class),Email);
			 if(user!=null) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public User loginByUserName(String username,String password) {
		
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="select * from user where username=? and password=?";
		User user=null;
		try {
		user=r.query(sql, new BeanHandler<User>(User.class),username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
     public User loginByEmail(String email,String password) {
		
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="select * from user where email=? and password=?";
		User user=null;
		try {
		user=r.query(sql, new BeanHandler<User>(User.class),email,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public void updateReceiveMsg(User user) {
		
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="update user set name=?,phone=?,address=? where id=?";
		
		  try {
		r.update(sql,user.getName(),user.getPhone(),user.getAddress(),user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updatePassword(User user) {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="update user set password=? where id=?";
		try {
			r.update(sql,user.getPassword(),user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static  int getUserCount(int pagenum,int pageSize) throws SQLException {
	QueryRunner r=new QueryRunner(DButils.getDataSoure());
	String sql="select count(*) from user";
	return r.query(sql, new ScalarHandler<Long>()).intValue();
	}

	public static List<User> selectUserList(int pagenum, int pageSize) throws SQLException {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="select * from user where isadmin=? limit ?,?";
		return r.query(sql, new BeanListHandler<User>(User.class),0,(pagenum-1)*pageSize,pageSize);
	}

	public void resetpassword(int userId, String password) {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="update user set password=? where id=?";
		try {
			r.update(sql,password,userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateReceive(User user,int userId) {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="update user set name=?,phone=?,address=? where id=?";
		  try {
		r.update(sql,user.getName(),user.getPhone(),user.getAddress(),userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deleteUser(int userId) throws SQLException {
		QueryRunner r = new QueryRunner(DButils.getDataSoure());
        String sql1="delete from `order` where user_id=?";
        r.update(sql1,userId);
		String sql="delete  from user where id=?";
		r.update(sql,userId);
	}


}
