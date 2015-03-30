package edu.neu.CS5200.MovieNetwork.model;

import java.util.Date;

public class Actor {

	int id;
	String firstName;
	String lastName;
	Date DOB;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	
	public Actor(int id, String firstName, String lastName, Date dOB) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
	}
	

	public Actor() {
		super();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
