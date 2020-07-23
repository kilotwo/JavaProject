package com.atguigu.team.service;
/**
 * 自定义异常类
 * @author Z.ero
 *
 */
public class TeamException extends Exception{
	 static final long serialVersionUID = -3387516993124229948L;
	 public TeamException() {
		 super();
	 }
	 public TeamException(String msg) {
		 super(msg);
	 }
	 
}
