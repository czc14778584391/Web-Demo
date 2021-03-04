package com.czc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.czc.Model.Goods;
import com.czc.Model.page;
import com.czc.Model.type;
import com.czc.dao.Goodsdao;
import com.czc.dao.typeDao;

public class GoodsService {
    
	typeDao td=new typeDao();
	Goodsdao gd=new Goodsdao();
	public List<Map<String, Object>> getGoodsList(int recommendType) {
		
	List<Map<String, Object>> list=null;
	
	   try {  
			list=gd.getGoodsList(recommendType);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;	
	}
	
	
	
   public Map<String, Object> getScorllGood() {
	   
	  Map<String, Object> map=null;
	  try {
		map=gd.getScrollGood();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return map;
  }
   
   
  public page getPage(int typeId,int pagenum,int pageSize) throws SQLException {
	
	  page p=new page();
	  p.setPagenum(pagenum);
	  p.setPageSize(pageSize);
	  int totalCount=gd.getRecommendTypeCount(typeId);
      p.setTotalCount(totalCount);
      p.setPageSizeAndTotalCount(pageSize, totalCount);
      List list=gd.selectRecommendGoods(typeId, pagenum, pageSize);
      for(Goods g : (List<Goods>)list) {
    	  g.setHot(gd.isHot(g));
    	  g.setScroll(gd.isScroll(g));
    	  g.setNew(gd.isNew(g));
      }
      p.setList(list);
      return p;
  }
  
  
  public page getRecommendPage(int typeId,int pagenum,int pageSize) throws SQLException {
	
	  page p=new page();
	  p.setPagenum(pagenum);
	  p.setPageSize(pageSize);
	  int totalCount=gd.getRecommendTypeCount(typeId);
      p.setTotalCount(totalCount);
      p.setPageSizeAndTotalCount(pageSize, totalCount);
      List list=gd.selectRecommendGoods(typeId, pagenum, pageSize);
      p.setList(list);
      return p;
      
  }
  
  
  public  List<Goods> selectRecommendGoods(int type,int pagenu,int pagesize) throws SQLException{
	  
	  return gd.selectRecommendGoods(type, pagenu, pagesize);
  } 
  
  public Goods  getGooddetail(int goodId) {
	 Goods good=null;
	try {
	good=  gd.getGooddetail(goodId);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return good;
  }


 public page getSearchPage(String keywold) throws SQLException {
	
	page p=new page();
	List list=gd.selectRecommendGoods(keywold);
	p.setPagenum(0);
	p.setList(list);
	p.setPageSize(0);
	int totalCount=gd.getSearchCount(keywold);
	p.setPageSizeAndTotalCount(0, totalCount);
	return p;
	
}
 
 public void deleteGoods(int goodsId) {
	 try {
		gd.deleteGoods(goodsId);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }



public void insertGoods(Goods g) throws SQLException {
	
	gd.insertGoods(g);
}



public void updateGoods(Goods g) {
	try {
		gd.updateGoods( g);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
