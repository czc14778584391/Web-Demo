package com.czc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.czc.Model.type;
import com.czc.Utils.DButils;

public class typeDao {

	public List<type> getTypeList() throws SQLException {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="select * from type";
		 return r.query(sql, new BeanListHandler<type>(type.class));
	}
	
	public type gettypeNmae(int id) throws SQLException {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="select * from type where id=?";
		
	    return	r.query(sql, new BeanHandler<type>(type.class),id);
		
	}

	public void updateType(type type) throws SQLException {
		
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="update type set name=? where id=?";
		r.update(sql,type.getName(),type.getId());
	}

	public void insertType(type type) throws SQLException {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="insert into type(name) values(?)";
		r.update(sql,type.getName());
	}

	public void deleteType(int typeId) throws SQLException {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="delete from type where id=?";
		r.update(sql,typeId);
	}

	public void addRecommendGoods(int goodId,int typeId) throws SQLException {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="insert into recommend(type,goods_id) values(?,?)";
		r.update(sql,typeId,goodId);
	}
	public void removeRecommendGoods(int goodId,int typeId) throws SQLException {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="delete from recommend where type=? and goods_id=?";
		r.update(sql,typeId,goodId);
	}
	
}
