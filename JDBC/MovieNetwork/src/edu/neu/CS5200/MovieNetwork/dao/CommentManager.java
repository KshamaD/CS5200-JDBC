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

import edu.neu.CS5200.MovieNetwork.model.Comment;


public class CommentManager {

	DataSource ds;
	public CommentManager()
	{
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MovieNetworkDB");
			System.out.println(ds);
		  } catch (NamingException e) {
			e.printStackTrace();
		  }
	}
	
	public void createComment(Comment newComment){
		String sql = "insert into Comment values (null,?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, newComment.getComment());
			statement.setDate(2, (Date) newComment.getDate());
			statement.setInt(3, newComment.getUserID());
			statement.setInt(4, newComment.getMovieID());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//List<Comment> readAllComments();
		public List<Comment> readAllComments()
		{
			List<Comment> comments = new ArrayList<Comment>();
			String sql = "select * from Comment";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while(results.next())
				{
					Comment comment = new Comment();
					comment.setId(results.getInt("Id"));
					comment.setComment(results.getString("Comment"));
					comment.setDate(results.getDate("Date"));
					comment.setUserID(results.getInt("UserID"));
					comment.setMovieID(results.getInt("MovieID"));
					comments.add(comment);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return comments;
		}
	
	
	
				public List<Comment> readAllCommentsForUsername(int userid)
				//I have changed the input parameter as Pk in my user table is userid which is int
				{
					List<Comment> comments = new ArrayList<Comment>();
					String sql = "select * from Comment where UserID=?";
					try {
						Connection connection = ds.getConnection();
						PreparedStatement statement = connection.prepareStatement(sql);
						statement.setInt(1, userid);
						ResultSet results = statement.executeQuery();
						while(results.next())
						{
							Comment comment = new Comment();
							comment.setId(results.getInt("ID"));
							comment.setComment(results.getString("Comment"));
							comment.setDate(results.getDate("Date"));
							comment.setUserID(results.getInt("UserID"));
							comment.setMovieID(results.getInt("MovieID"));
							comments.add(comment);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return comments;
				}
				

				public List<Comment> readAllCommentsForMovie(int movieId)
				//i have taken movieID as integer datatype in DB
				{
					List<Comment> comments = new ArrayList<Comment>();
					String sql = "select * from Comment where MovieID=?";
					try {
						Connection connection = ds.getConnection();
						PreparedStatement statement = connection.prepareStatement(sql);
						statement.setInt(1, movieId);
						ResultSet results = statement.executeQuery();
						
						while(results.next())
						{
							Comment comment = new Comment();
							comment.setComment(results.getString("Comment"));
							comments.add(comment);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return comments;
				}
	
				public Comment readCommentForId(int commentId)
				//i have taken commentId as int in database
				
				{
					Comment comment = new Comment();
					
					String sql = "select * from Comment where ID = ?";
					try {
						Connection connection = ds.getConnection();
						PreparedStatement statement = connection.prepareStatement(sql);
						statement.setInt(1, commentId);
						ResultSet result = statement.executeQuery();
						if(result.next())
						{
							
							comment.setComment(result.getString("Comment"));
							comment.setDate(result.getDate("Date"));
							comment.setUserID(result.getInt("UserID"));
							comment.setMovieID(result.getInt("MovieID"));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					return comment;
					
				}
				
	//void updateComment(Int commentId, String newComment);
				
				public void updateComment(int commentId, String newComment)
				// I have taken commentID as int

				{
					String sql = "update Comment set  Comment=?  where ID=?";
					try {
						Connection connection = ds.getConnection();
						PreparedStatement statement = connection.prepareStatement(sql);
						
						//statement.setString(1,newComment.getComment());
						
						statement.setInt(2, commentId);
						statement.executeUpdate();

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					
				}
	public void deleteComment(int commentId)
	//I have changed the datatype of commentId to int for my convenience
				{
					String sql = "delete from Comment where ID=?";
					try {
						Connection connection = ds.getConnection();
						PreparedStatement statement = connection.prepareStatement(sql);
						statement.setInt(1, commentId);
						 statement.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

	public static void main(String[] args) {
		

	}

}
