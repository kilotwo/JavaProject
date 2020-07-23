package com.atguigu.team.service;
/**
 * 
 * @author Z.ero
 *表示员工状态
 */
public class Status {
	private final String NAME;
	private Status(String name) {
		this.NAME =name;
		
	}
	public static final Status Free = new Status("FREE");
	public static final Status Busy = new Status("BUSY");
	public static final Status Vocation  = new Status("VOCATION");
	public String getNAME() {
		return NAME;
	}
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return NAME;
		}
}
