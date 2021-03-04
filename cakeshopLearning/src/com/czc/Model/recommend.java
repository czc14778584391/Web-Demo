package com.czc.Model;

public class recommend {

	private int id;
	private String type;
	private int goods_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public recommend(int id, String type, int goods_id) {
		super();
		this.id = id;
		this.type = type;
		this.goods_id = goods_id;
	}
	public recommend() {
		super();
	}
	
	
}
