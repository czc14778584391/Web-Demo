package com.czc.service;

import java.sql.SQLException;
import java.util.List;

import com.czc.Model.Order;
import com.czc.Model.User;
import com.czc.Model.page;
import com.czc.dao.userdao;

public class UserService {
     
	userdao ud=new userdao();
	
    public boolean registerUser(User user) {
    	
    	if(ud.isExitsUserName(user.getUsername())) return false;
    	if(ud.isExitsUserEmail(user.getEmail())) return false;
    	 	
        if(ud.setUser(user)) {
        	
        	return true;	
        }else return false;
  
    }
    
    public User userLogin(String un,String password) {
    	
        User user=null;
        
        user=ud.loginByEmail(un, password);
        if(user!=null) {
        	return user;
        }else {
        user=ud.loginByUserName(un, password);
        if(user!=null)return user;
        }
        return null;
    }
 
    public void updateReceiveMsg(User user) {
    	 ud.updateReceiveMsg(user);
    }
    
    public void updatePassword(User user) {
    	ud.updatePassword(user);
    }

	public page getUserPage(int pagenum, int pageSize) throws SQLException {
		
		  page p=new page();
		  p.setPagenum(pagenum);
		  p.setPageSize(pageSize);
		  int totalCount=userdao.getUserCount(pagenum,pageSize);
	      p.setTotalCount(totalCount);
	      p.setPageSizeAndTotalCount(pageSize, totalCount);
	      List orderList=userdao.selectUserList(pagenum, pageSize);
	      p.setList(orderList);
	      return p;
	}

	public void resetpassword(int userId, String password) {
	   ud.resetpassword(userId, password);
	}

	public void updateReceive(User user,int userId) {
		 ud.updateReceive(user,userId);
		
	}

	public void deleteUser(int userId) {
		try {
			ud.deleteUser(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public User adminLogin(String un, String password) {
		    User user=null;
	        
	        user=ud.loginByEmail(un, password);
	        if(user!=null&&user.isIsadmin()) {
	        	return user;
	        }else {
	        user=ud.loginByUserName(un, password);
	        if(user!=null&&user.isIsadmin())return user;
	        }
	        return null;
	}
    
}
