package edu.neu.CS5200.MovieNetwork.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.neu.CS5200.MovieNetwork.model.Movie;

public class MovieManager {

	DataSource ds;
	public MovieManager()
	{
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MovieNetworkDB");
			System.out.println(ds);
		  } catch (NamingException e) {
			e.printStackTrace();
		  }
	}


	
	// Create movie
	public void createMovie(Movie newMovie)
	{
		String sql = "insert into movie values (null,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newMovie.getTitle());
			statement.setString(2, newMovie.getPosterImage());
			statement.setDate(3, (Date) newMovie.getReleaseDate());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Read All movies
	public List<Movie> readAllMovies()
	{
		List<Movie> movies = new ArrayList<Movie>();
		String sql = "select * from Movie";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Movie movie = new Movie();
				movie.setId(results.getInt("Id"));
				movie.setTitle(results.getString("Title"));
				movie.setPosterImage(results.getString("PosterImage"));
			
				movies.add(movie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}
	
	// read movie by given Id
	public Movie readMovie(int movieId)
	// in database i have taken movieId as integer, so here i am changing the datatype in argument
	{
        Movie movie = new Movie();
		
		String sql = "select * from Movie where Id = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, movieId);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				movie.setId(result.getInt("Id"));
				movie.setTitle(result.getString("Title"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return movie;
		
	}

	// update a movie by id
		public void updateMovie(int id, Movie movie)
		// In Assignment movieID is given as String, but i have taken it as int 
		{
			String sql = "update Movie set Title=?, PosterImage=?, ReleaseDate=? where Id=?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, movie.getTitle());
				statement.setString(2, movie.getPosterImage());
				statement.setDate(3,(Date) movie.getReleaseDate());
				statement.setInt(4, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
		
	//delete Movie by ID
		public void deleteMovie(int ID)
		// In Assignment movieID is given as String, but i have taken it as int
		{
			String sql = "delete from Movie where ID=?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, ID);
				statement.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

	public static void main(String[] args) {
	
	}

}
