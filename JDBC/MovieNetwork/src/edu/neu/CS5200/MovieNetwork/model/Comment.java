package edu.neu.CS5200.MovieNetwork.model;

import java.util.Date;

public class Comment {

	int id ;
	String comment ;
	Date date;
	int userID;
	int movieID;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	
	public Comment(int id, String comment, Date date, int userID, int movieID) {
		super();
		this.id = id;
		this.comment = comment;
		this.date = date;
		this.userID = userID;
		this.movieID = movieID;
	}
	

	public Comment() {
		super();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
