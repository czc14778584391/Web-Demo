package com.czc.service;

import java.sql.SQLException;
import java.util.List;

import com.czc.Model.type;
import com.czc.dao.typeDao;

public class typeService {

	typeDao td=new typeDao();
	
	public List<type> getTypeList() {
		
		List<type>typeList=null;
		
		try {
			typeList=td.getTypeList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return typeList;
	}
	
	
	public type gettypeNmae(int id) {
		
		type t=null;
		try {
			t= td.gettypeNmae(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}


	public void updateType(type type) {
		try {
			td.updateType(type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void insertType(type type) {
		try {
			td.insertType(type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void deleteType(int typeId) {
		try {
			td.deleteType(typeId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addRecommendGoods(int goodId,int typeId) {
		try {
			td.addRecommendGoods(goodId, typeId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void removeRecommendGoods(int goodId,int typeId) {
		try {
			td.removeRecommendGoods(goodId, typeId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
