package com.czc.Utils;

import java.math.BigDecimal;

public class PriceUtils {

	public static float add(float a,float b) {
		BigDecimal bigA=new BigDecimal(Float.toString(a));
		BigDecimal bigB=new BigDecimal(Float.toString(b));
		 float res=bigA.add(bigB).floatValue();
		  return  res;
	}
	
	public static double add(double a,double b) {
		BigDecimal bigA=new BigDecimal(Double.toString(a));
		BigDecimal bigB=new BigDecimal(Double.toString(b));
		Double res=bigA.add(bigB).doubleValue();
		  return  res;
	}
	
	public static  float subtract(float a,float b) {
		BigDecimal bigA=new BigDecimal(Float.toString(a));
		BigDecimal bigB=new BigDecimal(Float.toString(b));
		float res=bigA.subtract(bigB).floatValue();
		return res;
	}
	
	public  static double subtract(double a,double b) {
		BigDecimal bigA=new BigDecimal(Double.toString(a));
		BigDecimal bigB=new BigDecimal(Double.toString(b));
		Double res=bigA.subtract(bigB).doubleValue();
		  return  res;
	}
	
	public static  float multiply(float a,float b) {
		BigDecimal bigA=new BigDecimal(Float.toString(a));
		BigDecimal bigB=new BigDecimal(Float.toString(b));
		float res=bigA.multiply(bigB).floatValue();
		return res;
	}
	
	public  static double multiply(double a,double b) {
		BigDecimal bigA=new BigDecimal(Double.toString(a));
		BigDecimal bigB=new BigDecimal(Double.toString(b));
		Double res=bigA.multiply(bigB).doubleValue();
		  return  res;
	}
	
}
