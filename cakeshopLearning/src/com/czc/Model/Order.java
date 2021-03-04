package com.czc.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.czc.Utils.PriceUtils;

public class Order {

	private int id;
    private float total;
    private  int  amount;
    private int status ;//1未付款/2已付款/3已发货/4已完成
    private int paytype;//1微信/2支付宝/3货到付款
	private String name;
	private String phone;
	private String address;
	private Date datetime;
	private User user;
	private List<OrderItem> orderList=new ArrayList<OrderItem>();
	
	public List<OrderItem> getOrderList() {
		return orderList;
	}
     
	public void setUsername(String username) {
	    user=new User();
		user.setUsername(username);
	}
	 
	public void setOrderList(List<OrderItem> orderList) {
		this.orderList = orderList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	private Map<Integer,OrderItem>map=new HashMap<Integer, OrderItem>();
	
	public void addGoods(Goods g) {
		
		if(map.containsKey(g.getId())) {
		OrderItem OItem=map.get(g.getId());
		OItem.setAmount(OItem.getAmount()+1);
		}else {
	    OrderItem OI=new OrderItem(g.getPrice(), 1, g, this);		
	    map.put(g.getId(), OI);		
		}
		amount++;
	   total=	PriceUtils.add(total, g.getPrice()); 
	}
	
	public void lessen(int goodsId) {
		OrderItem OI=map.get(goodsId);
		OI.setAmount(OI.getAmount()-1);
		if(OI.getAmount()<=0) {
			map.remove(goodsId);
		}
		amount--;
		total= PriceUtils.subtract(total,OI.getPrice());
		
	}
	
	public void delete(int goodsid) { 
		OrderItem OI=map.get(goodsid);
		amount-=OI.getAmount();
		total= PriceUtils.subtract(total, PriceUtils.multiply(OI.getAmount(), OI.getPrice()));
	    map.remove(goodsid);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}


	public int getPaytype() {
		return paytype;
	}


	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}


	public Map<Integer, OrderItem> getMap() {
		return map;
	}


	public void setMap(Map<Integer, OrderItem> map) {
		this.map = map;
	}
	
	
	
}
