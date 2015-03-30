package edu.neu.CS5200.MovieNetwork.model;

public class Cast {
	int id ;
	String castName ;
	int ActorID;
	int movieID ;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCastName() {
		return castName;
	}


	public void setCastName(String castName) {
		this.castName = castName;
	}


	public int getActorID() {
		return ActorID;
	}


	public void setActorID(int actorID) {
		ActorID = actorID;
	}


	public int getMovieID() {
		return movieID;
	}


	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	

	public Cast(int id, String castName, int actorID, int movieID) {
		super();
		this.id = id;
		this.castName = castName;
		ActorID = actorID;
		this.movieID = movieID;
	}


	
	public Cast() {
		super();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
