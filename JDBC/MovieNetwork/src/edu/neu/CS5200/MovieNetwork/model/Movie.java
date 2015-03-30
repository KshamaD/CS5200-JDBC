package edu.neu.CS5200.MovieNetwork.model;

import java.util.Date;

public class Movie {
	int id ;
	String title ;
	String posterImage;
	Date releaseDate;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPosterImage() {
		return posterImage;
	}


	public void setPosterImage(String posterImage) {
		this.posterImage = posterImage;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	

	public Movie(int id, String title, String posterImage, Date releaseDate) {
		super();
		this.id = id;
		this.title = title;
		this.posterImage = posterImage;
		this.releaseDate = releaseDate;
	}


	public Movie() {
		super();
	}


	public static void main(String[] args) {
		

	}

}
