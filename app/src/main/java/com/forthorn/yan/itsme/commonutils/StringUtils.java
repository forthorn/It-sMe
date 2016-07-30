package com.forthorn.yan.itsme.commonutils;
/**
 * 
 * 数据输入操作类
 * 字符串操作
 * 
 * 
 * 
 * */
import java.util.Scanner;

public class StringUtils {

	static Scanner input = new Scanner(System.in);
	
	// 判断输入的用户名是否合法
	public static boolean isLegalName(String string) {
		if(string==null || "".equals(string)){
			System.out.println("输入内容不能为空");
			return false;
		}else if (string.matches("^[a-zA-Z][a-zA-Z0-9_]{4,15}$")) {
			return true;
		}else {
			System.out.println("输入的内容有误");
		}
		return false;
	}
	
	
	// 判断输入的密码是否合法
		public static boolean isLegalPassword(String string) {
			if(string==null || "".equals(string)){
				System.out.println("输入内容不能为空");
				return false;
			}else if (string.matches("^[a-zA-Z0-9_]{4,15}$")) {
				return true;
			}else {
				System.out.println("输入的密码不符合要求");
			}
			return false;
		}
	
	
	//判断字符串对象是否为Null或者空
	public static boolean isNull(String s){
		if(s==null || "".equals(s.trim())){
			return true;
		}
		return false;
	}
	
	
	//获取输入的字符串
	public static String getString(){
		String s = input.next();
		return s;
	}
	//获取不含收尾空格的String
	public static String getsStringTrim(){
		String s = input.next();
		if(s!=null){
			return s.trim();
		}else
		return null;
	}
	
	
	
}
