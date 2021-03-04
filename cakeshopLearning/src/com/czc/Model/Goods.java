package com.czc.Model;

public class Goods {

	private int id;
	private String name;
	private String cover;
	private String image1;
	private String image2;
	private float price;
	private String intro;
	private int stock;
	private int type_id;
	private type type;
	
	private boolean isScroll;
	private boolean isHot;
	private boolean isNew;
	
	
	
	public boolean getIsScroll() {
		return isScroll;
	}

	public void setScroll(boolean isScroll) {
		this.isScroll = isScroll;
	}

	public boolean getIsHot() {
		return isHot;
	}

	public void setHot(boolean isHot) {
		this.isHot = isHot;
	}

	public boolean getIsNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public void setTypeid(int id) {
		if(type==null) {
			type=new type();
		}
		type.setId(id);
	}
	
	public void setTypename(String name) {
		if(type==null) {
			type=new type();
		}
		type.setName(name);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public Goods(int id, String name, String cover, String image1, String image2, float price, String intro, int stock,
			int type_id) {
		super();
		this.id = id;
		this.name = name;
		this.cover = cover;
		this.image1 = image1;
		this.image2 = image2;
		this.price = price;
		this.intro = intro;
		this.stock = stock;
		this.type_id = type_id;
	}
	public Goods() {
		super();
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", cover=" + cover + ", image1=" + image1 + ", image2=" + image2
				+ ", price=" + price + ", intro=" + intro + ", stock=" + stock + ", type_id=" + type_id + ", type="
				+ type + "]";
	}

	public type getType() {
		return type;
	}

	public void setType(type type) {
		this.type = type;
	}
	
	
	
	 
}
