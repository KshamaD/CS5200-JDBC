package edu.neu.CS5200.MovieNetwork.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.neu.CS5200.MovieNetwork.model.Cast;


public class CastManager {
	DataSource ds;
	public CastManager()
	{
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MovieNetworkDB");
			System.out.println(ds);
		  } catch (NamingException e) {
			e.printStackTrace();
		  }
	}

	public void createCast(Cast newCast)
	{
		String sql = "insert into Cast values (null,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, newCast.getCastName());
			statement.setInt(2,newCast.getActorID());
			statement.setInt(3, newCast.getMovieID());
			
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Cast> readAllCast(){
		List<Cast> casts = new ArrayList<Cast>();
		String sql = "select * from Cast";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Cast cast = new Cast();
				cast.setId(results.getInt("ID"));
				cast.setCastName(results.getString("CastName"));
				
				cast.setActorID(results.getInt("ActorID"));
				cast.setMovieID(results.getInt("MovieID"));
			    casts.add(cast);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return casts;
	}

	public List<Cast> readAllCastForActor(int actorId)
	//i have taken actorId as int type in DB
	{
		List<Cast> casts = new ArrayList<Cast>();
		String sql = "select * from Cast where ActorID=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, actorId);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Cast cast = new Cast();
				cast.setId(results.getInt("ID"));
				cast.setCastName(results.getString("CastName"));
				
				cast.setActorID(results.getInt("ActorID"));
				cast.setMovieID(results.getInt("MovieID"));
				casts.add(cast);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return casts;
	}
	
	
	public List<Cast> readAllCastForMovie(int movieId)
	// i have taken movieID as int type in db
	{
		List<Cast> casts = new ArrayList<Cast>();
		String sql = "select * from Cast where MovieID=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, movieId);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Cast cast = new Cast();
				cast.setId(results.getInt("ID"));
				cast.setCastName(results.getString("CastName"));
				
				cast.setActorID(results.getInt("ActorID"));
				cast.setMovieID(results.getInt("MovieID"));
				casts.add(cast);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return casts;
	}
	
	
	public Cast readCastForId(int castId)
	//I have changed the datatype of castId to int for my convenience
	{
		Cast cast = new Cast();
		String sql = "select * from Cast where ID = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, castId);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				cast.setCastName(result.getString("CastName"));
				cast.setActorID(result.getInt("ActorID"));
				cast.setMovieID(result.getInt("MovieID"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return cast;
	}
	
	
	public void updateCast(int castId, Cast newCast)
	//I have changed the datatype of castId to int for my convenience
	{
		String sql = "update Cast set  CastName=? ,ActorID=?,MovieID=? where ID=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, newCast.getCastName());
			statement.setInt(2, newCast.getActorID());
			statement.setInt(3, newCast.getMovieID());
			statement.setInt(4, castId);
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	public void deleteCast(int castId)
	//I have changed the datatype of castId to int for my convenience
	{
		
		String sql = "delete from Cast where ID=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, castId);
			 statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		

	}

}
