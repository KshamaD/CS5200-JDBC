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

import edu.neu.CS5200.MovieNetwork.model.User;

public class UserManager {

	DataSource ds;
	public UserManager()
	{
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MovieNetworkDB");
			System.out.println(ds);
		  } catch (NamingException e) {
			e.printStackTrace();
		  }
	}
	
	public void createUser(User newUser){
		String sql = "insert into User values (null,?,?,?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, newUser.getUserName());
			statement.setString(2, newUser.getPassword());
			statement.setString(3, newUser.getFirstName());
			statement.setString(4, newUser.getLastName());
			statement.setString(5, newUser.getEmailID());
			statement.setDate(6, (Date) newUser.getDOB());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//List<User> readAllUsers();
	public List<User> readAllUsers()
	{
		List<User> users = new ArrayList<User>();
		String sql = "select * from User";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				User user = new User();
				user.setId(results.getInt("Id"));
				user.setUserName(results.getString("UserName"));
				user.setPassword(results.getString("Password"));
				user.setFirstName(results.getString("FirstName"));
				user.setLastName(results.getString("LastName"));
				user.setEmailID(results.getString("EmailID"));
				user.setDOB(results.getDate("DateOfBirth"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	//User readUser(String username);
	public User readUser(String username)
	
	{
		User user = new User();
		
		String sql = "select * from User where UserName = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				user.setUserName(result.getString("UserName"));
				user.setFirstName(result.getString("FirstName"));
				user.setEmailID(result.getString("EmailID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return user;
		
	}
	//void updateUser(String username, User user);
	public void updateUser(String username, User user)

	{
		String sql = "update User set  Password=? ,EmailID=? where UserName=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getEmailID());
			statement.setString(3, username);
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	//void deleteUser(String username);
	public void deleteUser(String username)
	{
		String sql = "delete from User where username=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			 statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		

	}

}
