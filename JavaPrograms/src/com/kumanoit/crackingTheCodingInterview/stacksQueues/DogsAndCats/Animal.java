package com.kumanoit.crackingTheCodingInterview.stacksQueues.DogsAndCats;

public abstract class Animal {

	protected String name;
	private Long admitTime;

	public void setName(String name) {
		this.name = name;
	}

	public void setAdmitTime(Long admitTime) {
		this.admitTime = admitTime;
	}

	Animal(String name) {
		this.name = name;
	}

	public Long getAdmitTime() {
		return admitTime;
	}

	public String getName() {
		return name;
	}

	public void print() {
		System.out.print("(" + this.getName() + "," + this.getAdmitTime() + ")" + "\t");
	}
}
