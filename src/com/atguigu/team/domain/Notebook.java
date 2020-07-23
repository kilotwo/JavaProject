package com.atguigu.team.domain;

public class Notebook implements Equipment {
	private String model;//型号
	private double price;//
	
	public Notebook() {
		super();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
//构造器 先提供空参的 再提供带参的
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return model + "("+ price + ")";
	}

	public Notebook(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}

}
