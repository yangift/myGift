package com.yml.crm.util;

public class UtilTools {
	public static Long StringToLong(String str){
		if(str==null||"".equals(str)){
			str="0";
		}
		return Long.valueOf(str);
	}
	public static Integer StringToInt(String str){
		if(str==null||"".equals(str)){
			str="0";
		}
		return Integer.valueOf(str);
	}

}
