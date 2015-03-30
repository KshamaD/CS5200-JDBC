package edu.neu.CS5200.MovieNetwork.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.neu.CS5200.MovieNetwork.model.Actor;

public class ActorManager {

	DataSource ds;
	public ActorManager()
	{
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MovieNetworkDB");
			System.out.println(ds);
		  } catch (NamingException e) {
			e.printStackTrace();
		  }
	}
	//void createActor(Actor newActor);
	public void createActor(Actor newActor){
		String sql = "insert into Actor values (null,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newActor.getFirstName());
			statement.setString(2, newActor.getLastName());
			statement.setDate(3, (Date) newActor.getDOB());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//List<Actor> readAllActors();
	public List<Actor> readAllActors()
	{
		List<Actor> actors = new ArrayList<Actor>();
		String sql = "select * from Actor";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Actor actor = new Actor();
				actor.setId(results.getInt("Id"));
				actor.setFirstName(results.getString("FirstName"));
				actor.setLastName(results.getString("LastName"));
				actor.setDOB(results.getDate("DateOfBirth"));
				actors.add(actor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actors;
	}
	
	
	//Actor readActor(String actorId);
	public Actor readActor (int actorId)
	// I have taken actorId as integer datatype in Database so changing the input of this function
	
	{
		Actor actor= new Actor();
		
		
		String sql = "select * from Actor where Id = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, actorId);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				actor.setLastName(result.getString("LastName"));
				actor.setFirstName(result.getString("FirstName"));
				actor.setDOB(result.getDate("DateOfBirth"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return actor;
		
	}
	
	
	//void updateActor(String actorId, Actor actor);
	public void updateActor(int actorId, Actor actor)
	// I have taken actorId as integer datatype in Database so changing the input of this function

	{
		String sql = "update Actor set  FirstName=? ,LastName=? where Id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, actor.getFirstName());
			statement.setString(2, actor.getLastName());
			statement.setInt(3, actorId);
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	
	//void deleteActor(String actorId);
	public void deleteActor(int actorId)
	// I have taken actorId as integer datatype in Database so changing the input of this function
	{
		String sql = "delete from Actor where Id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, actorId);
			 statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
