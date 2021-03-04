package com.czc.Utils;



import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DButils {
	
	 private static DataSource ds=new ComboPooledDataSource(); 
	
     public static DataSource getDataSoure() {
    	 
    	 return   ds;
    	 
     }
	
     public static Connection getConnection() throws SQLException {
    	 
    	 return ds.getConnection();
     }
     
}
