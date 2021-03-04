package com.czc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.czc.Model.Goods;
import com.czc.Model.recommend;
import com.czc.Model.type;
import com.czc.Utils.DButils;

public class Goodsdao {

	public static List<Map<String, Object>> getGoodsList(int recommendType) throws SQLException {
		
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="select g.id,g.name,g.cover,g.price,t.name typename from recommend r,goods g,type t where type=? and r.goods_id=g.id and g.type_id=t.id";
	    return r.query(sql, new MapListHandler(),recommendType);
	}
	
    public static Map<String, Object> getScrollGood() throws SQLException {
		
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="select g.id,g.name,g.cover,g.price from recommend r,goods g where type=1 and r.goods_id=g.id";
	    return r.query(sql, new MapHandler());
	}
//      ªÒ»°
    public  List<Goods> selectGoods(int type,int pagenu,int pagesize) throws SQLException {
    	
    	QueryRunner r=new QueryRunner(DButils.getDataSoure());
    	if(type==0) {
    		String sql="select * from goods limit ?,?";
    			return	r.query(sql,new BeanListHandler<Goods>(Goods.class),(pagenu-1)*pagesize,pagesize);	
    	}else {
    		String sql="select * from goods where type_id=? limit ?,?";		
			return r.query(sql, new BeanListHandler<Goods>(Goods.class),type,(pagenu-1)*pagesize,pagesize);				
    	}
    }    
    
    
    public int getTypeCount(int typeId) throws SQLException {
    	
    	QueryRunner r=new QueryRunner(DButils.getDataSoure());
    	String sql="";
    	if(typeId==0) {    
    		 sql="select count(*) from goods";
    		 return	r.query(sql,new ScalarHandler<Long>()).intValue();	
    	}else {
    		sql="select count(*) from goods where type_id=? ";	
    		return	r.query(sql,new ScalarHandler<Long>(),typeId).intValue();	
    	}   
    }  
       
      public  List<Goods> selectRecommendGoods(int type,int pagenu,int pagesize) throws SQLException {
    	
    	    QueryRunner r=new QueryRunner(DButils.getDataSoure());
    	    if(type==0) {
    	    	String sql = " select g.id,g.name,g.cover,g.image1,g.image2,g.intro,g.price,g.stock,t.name typename from goods g,type t where g.type_id=t.id limit ?,?";
    			return r.query(sql, new BeanListHandler<Goods>(Goods.class),(pagenu-1)*pagesize,pagesize);
    	    }else {
    		    String sql="select g.id,g.name,g.cover,g.image1,g.image2,g.intro,g.price,g.stock,t.name typename from goods g,recommend r,type t where g.id=r.goods_id and r.type=? limit ?,?";		
			return r.query(sql, new BeanListHandler<Goods>(Goods.class),type,(pagenu-1)*pagesize,pagesize);		
    	    }	
    }    
         
    
      public int getRecommendTypeCount(int type) throws SQLException {
    	
        	QueryRunner r=new QueryRunner(DButils.getDataSoure());
        	if(type==0) {    
       		return  getTypeCount(0);
        	}else {
    		String  sql="select count(*) from recommend where type=? ";	
    		return	r.query(sql,new ScalarHandler<Long>(),type).intValue();	
        	}
    	}   
      
      
      public  Goods  getGooddetail(int goodId) throws SQLException {
    	  
    	   QueryRunner r=new QueryRunner(DButils.getDataSoure());
    	   
    	   String sql="select g.id,g.name,g.cover,g.image1,g.image2,g.price,g.intro,g.stock,t.id typeid,t.name typename from goods g,type t where g.id=? and g.type_id=t.id";
    	   
    	  return  r.query(sql, new BeanHandler<Goods>(Goods.class),goodId);
      }

	public List<Goods> selectRecommendGoods(String keywold) throws SQLException {
	   QueryRunner r=new QueryRunner(DButils.getDataSoure());
	  String sql="select * from goods where name like ? ";
	  return  r.query(sql, new BeanListHandler<Goods>(Goods.class),"%"+keywold+"%");
	}
	
	
	public int getSearchCount(String keywold) throws SQLException {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="select count(*) from goods where name like ?";
		return	r.query(sql,new ScalarHandler<Long>(),"%"+keywold+"%").intValue();	
		
	}
	
	public void deleteGoods(int goodsId) throws SQLException {
		QueryRunner r1=new QueryRunner(DButils.getDataSoure());
		String sql1="delete from recommend where goods_id=?";
		r1.update(sql1,goodsId);
		QueryRunner r2=new QueryRunner(DButils.getDataSoure());
		String sql2="delete from orderitem where goods_id=?";
		r2.update(sql2,goodsId);
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="delete from goods where id=?";
		r.update(sql,goodsId);	
	}
	
	private boolean isRecommend(Goods g,int typeId) throws SQLException {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="select * from recommend where type=? and goods_id=?";
	 recommend re=r.query(sql, new BeanHandler<recommend>(recommend.class),typeId,g.getId());
	 if(re==null) {
		 return false;
	 }else {
		 return true;
	 }
	}
	
	public boolean isHot(Goods g) throws SQLException {
		 return isRecommend(g, 2);
	}
	public boolean isScroll(Goods g) throws SQLException {
		 return isRecommend(g, 1);
	}
	public boolean isNew(Goods g) throws SQLException {
		 return isRecommend(g, 3);
	}

	public void insertGoods(Goods g) throws SQLException {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="insert into goods(cover,image1,image2,intro,name,price,stock,type_id) values(?,?,?,?,?,?,?,?)";
		r.update(sql,g.getCover(),g.getImage1(),g.getImage2(),g.getIntro(),g.getName(),g.getPrice(),g.getStock(),g.getType().getId());
	}

	public void updateGoods(Goods g) throws SQLException {
		QueryRunner r=new QueryRunner(DButils.getDataSoure());
		String sql="update goods set cover=?,image1=?,image2=?,intro=?,name=?,price=?,stock=?,type_id=? where id=?";
		r.update(sql,g.getCover(),g.getImage1(),g.getImage2(),g.getIntro(),g.getName(),g.getPrice(),g.getStock(),g.getType().getId(),g.getId());
	}
	
}
