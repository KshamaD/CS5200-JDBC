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
import edu.neu.CS5200.MovieNetwork.model.User;

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
	
	List<Comment> readAllCommentsForUsername(String username);
	List<Comment> readAllCommentsForMovie(String movieId);
	Comment readCommentForId(String commentId);
	void updateComment(String commentId, String newComment);
	void deleteComment(String commentId);

	public static void main(String[] args) {
		

	}

}
