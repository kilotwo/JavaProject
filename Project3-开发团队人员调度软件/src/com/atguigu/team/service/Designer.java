package com.atguigu.team.service;

import com.atguigu.team.domain.Equipment;
import com.atguigu.team.domain.Programmer;

public class Designer extends Programmer{
	private double bonus;


	public Designer() {
		super();
	}

	public Designer(int id, int age, String name, double salary, Equipment equipment, double bonus) {
		super(id, age, name, salary, equipment);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		// TODO 调用父类的父类构造
		return getDetails()+"\t设计师\t"+getStatus()+"\t"+bonus+"\t\t"+getEquipment().getDescription();
	
	}
	public String getDetailForTeam() {
		return getMemberId() + "/" +getId() +"\t" + getName() +"\t" +getAge() +"\t" + getSalary()+"\t" +"设计师" +"\t" +getBonus();
	}
}
