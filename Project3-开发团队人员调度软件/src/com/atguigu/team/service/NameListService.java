package com.atguigu.team.service;
/**
 * 
 * @author Z.ero
 *负责将Data数据封装到Employee[]数组中，同时提供相关操作Employee[]方法
 */

import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Equipment;
import com.atguigu.team.domain.Notebook;
import com.atguigu.team.domain.PC;
import com.atguigu.team.domain.Printer;
import com.atguigu.team.domain.Programmer;

public class NameListService {
	private Employee[] employees;
	/**
	 * 给数据及数组元素初始化
	 */
	public NameListService() {
	/**
	 * 根据项目提供的Data类构建相应大小的employee数组
	 * 再根据Data类中数据构建不同的对象，包括Employee,Programmer,Designer和Architece将对象存于数组中
	 */
	employees = new Employee[Data.EMPLOYEES.length];
	for (int i = 0; i < employees.length; i++) {
		int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
		int id   = Integer.parseInt(Data.EMPLOYEES[i][1]);
		String name = Data.EMPLOYEES[i][2];
		int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
		double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
		double bonus;
		int stock;
		Equipment equipment;
		switch (type) {
		case Data.EMPLOYEE:
			employees[i] = new Employee(id, age, name, salary);
			
			break;
		case Data.PROGRAMMER:
			equipment = creatEquiment(i);
			employees[i] = new Programmer(id, age, name, salary, equipment);
			break;
		case Data.DESIGNER:
			equipment = creatEquiment(i);
			bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
			employees[i] = new Designer(id, age, name, salary, equipment, bonus);
			
			break;
		case Data.ARCHITECT:
			equipment = creatEquiment(i);
			bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
			stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
			employees[i]= new Architect(id, age, name, salary, equipment, bonus, stock); 
			break;
		default:
			break;
		}
	}
	}
	/**
	 * 获取指定index上员工设备
	 * @param index
	 * @return
	 */
	private Equipment creatEquiment(int index) {
		int key = Integer.parseInt(Data.EQUIPMENTS[index][0]);
		String model = Data.EQUIPMENTS[index][1];
		switch(key) {
		case Data.PC://21
			
			String display = Data.EQUIPMENTS[index][2];
			return new PC(model,display);
			
		case Data.NOTEBOOK:
			double price = Double.parseDouble(Data.EQUIPMENTS[index][2]);
			return new Notebook(model,price);
		case Data.PRINTER:
			String type = Data.EQUIPMENTS[index][2];
			return new Printer(model,type);
			
		}
		return null;
	}
	public Employee[] getAllEmployees() {
		return employees;
		
	}
	/**
	 * 获取指定ID的员工
	 * @param id
	 * @return
	 * @throws TeamException 
	 */
	public Employee getEmployee(int id ) throws TeamException {
		for (int i = 0; i < employees.length; i++) {
			if(employees[i].getId() == id) {
				return employees[i];
			}
		}
		 throw new TeamException("找不到指定员工");
		
	}
	
}
