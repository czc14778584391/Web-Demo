package com.czc.Model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class type {

	private int id;
	private String name;
	private String enCodeName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public String getEnCodeName() {
		return enCodeName;
	}
	public void setName(String name) {
		this.name = name;
		try {
			this.enCodeName=URLEncoder.encode(name,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public type(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public type() {
		super();
	}

	
}
