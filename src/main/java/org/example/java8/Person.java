package org.example.java8;

public class Person {

	private String name;
	private JobPosition currentJobPosition;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JobPosition getCurrentJobPosition() {
		return currentJobPosition;
	}

	public void setCurrentJobPosition(JobPosition jobPosition) {
	}
}
