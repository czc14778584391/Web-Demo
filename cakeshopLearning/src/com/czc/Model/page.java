package com.czc.Model;

import java.util.List;

public class page {
   private int pagenum;
   private int pageSize;
   private int totalCount;
   private int totalpage;
   
   private List<Object>list;
   
   public void setPageSizeAndTotalCount(int pageSize,int totalCount) {
	   this.pageSize=pageSize;
	   this.totalCount=totalCount;
	   
	   totalpage=(int)Math.ceil((double)totalCount/pageSize);
   }
   

public int getPagenum() {
	return pagenum;
}


public void setPagenum(int pagenum) {
	this.pagenum = pagenum;
}


public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getTotalCount() {
	return totalCount;
}
public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
}
public int getTotalpage() {
	return totalpage;
}
public void setTotalpage(int totalpage) {
	this.totalpage = totalpage;
}

public List<Object> getList() {
	return list;
}

public void setList(List<Object> list) {
	this.list = list;
}
   
   
   
	
}
