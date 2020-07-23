package com.atguigu.team.service;

import com.atguigu.team.domain.Equipment;

public class Architect extends Designer{
	private int stock;

	public Architect() {
		super();
	}

	public Architect(int id, int age, String name, double salary, Equipment equipment, double bonus, int stock) {
		super(id, age, name, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	//TODO 自动保存
	@Override
	public String toString() {
		// TODO 调用父类的父类构造
		return getDetails()+"\t架构师\t"+getStatus()+"\t"+getBonus()+"\t"+stock+"\t"+getEquipment().getDescription();
	}
	public String getDetailForTeam() {
		return getMemberId() + "/" +getId() +"\t" + getName() +"\t" +getAge() +"\t" + getSalary()+"\t" +"架构师" +"\t" +getBonus()+"\t"+getStock();
	}
}
