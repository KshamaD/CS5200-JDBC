<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import ="edu.neu.CS5200.MovieNetwork.dao.*" import ="edu.neu.CS5200.MovieNetwork.model.*" import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Networking</title>
</head>
<body>
<h1> Welcome to Movie Network!</h1>


<%
// --------------------------------NOTE-----------------------------------------------------------

// I have checked all the functions and its reflection in database. All the functions are working fine.
// Also while creating database i have taken all the primary keys as integer datatype.
// SO where ever the input parameter for function is String type for PK i have changed it to int type.
//---------------------------------------------Movie ---------------------------------------
MovieManager dao= new MovieManager();
Movie movie = new Movie();
movie.setTitle("Shamitabh");
movie.setPosterImage("Poster2");
movie.setReleaseDate(null);
dao.createMovie(movie);
Movie findMovie = dao.readMovie(2);
out.println(findMovie.getTitle());
 
 Movie m2 = new Movie();
 m2.setTitle("Titanic");
 dao.updateMovie(2, m2);
 dao.deleteMovie(10);

List<Movie> movieList = dao.readAllMovies();

for (Movie m : movieList)
{
	out.println("<li>" +m.getTitle()+"<li>");
	
}
//-----------------------------------------------USER--------------------------------------


UserManager userDAO= new UserManager();
User user = new User();
user.setUserName("Jose");
user.setPassword("Jose");
user.setFirstName("Jose");
user.setLastName("Annunziato");
user.setEmailID("jose@gmail.com");
user.setDOB(null);
userDAO.createUser(user);
 
List<User> userList = userDAO.readAllUsers();

for (User u : userList)
{
	out.println("<li>" +u.getUserName()+"<li>");
	
}
User findUser = userDAO.readUser("Jose");
out.println(findUser.getFirstName());
out.println(findUser.getEmailID());

user.setEmailID("kshama123@gmail.com");
user.setPassword("kd123");
 userDAO.updateUser("Kshama", user);


 userDAO.deleteUser("Jose");
  
  ///--------------------------------------------------Actor----------------------------
  
 ActorManager actorDAO= new ActorManager();
Actor actor = new Actor();

actor.setFirstName("Anushka");
actor.setLastName("Sharma");
actor.setDOB(null);
actorDAO.createActor(actor);
 
 actorDAO.updateActor(2, actor);
actorDAO.deleteActor(6);
List<Actor> actorList = actorDAO.readAllActors();
for (Actor a : actorList)
{
	out.println("<li>" +a.getFirstName()+"<li>");
	
}
Actor findactor = actorDAO.readActor(1);
out.println(findactor.getFirstName());
out.println(findactor.getLastName());
//------------------------------Comment----------------------

 
 CommentManager commentDAO= new CommentManager();
Comment comment = new Comment();

comment.setComment("Interesting");
comment.setMovieID(2);
comment.setUserID(3);
comment.setDate(null);
commentDAO.createComment(comment);

commentDAO.updateComment(1, "I saw the movie!");
commentDAO.deleteComment(2);

List<Comment> commentList = commentDAO.readAllComments();
for (Comment c : commentList)
{
	out.println("<li>" +c.getComment()+"<li>");
	
}
Comment findComment = commentDAO.readCommentForId(9);
out.println(findComment.getComment());
out.println(findComment.getUserID());
Comment findcomment = commentDAO.readCommentForId(1);
out.println(findcomment.getComment());
	

List<Comment> commentList1 = commentDAO.readAllComments();
for (Comment com : commentList1)
{
	out.println("<li>" +com.getComment()+"<li>");
	
}
List<Comment> commentList2 = commentDAO.readAllCommentsForMovie(2);
for (Comment com : commentList2)
{
	out.println("<li>" +com.getComment()+"<li>");
	
}
  
List<Comment> commentList3 = commentDAO.readAllCommentsForUsername(1);
for (Comment c : commentList3)
{
	out.println("<li>" +c.getComment()+"<li>");
	
}
//------------------------------------------Cast-----------------------------
  

 CastManager castDAO= new CastManager();
Cast cast = new Cast();
cast.setCastName("Aladin");
cast.setActorID(3);
cast.setMovieID(3);
castDAO.updateCast(3, cast);
castDAO.deleteCast(3);
Cast findCast = castDAO.readCastForId(5);
out.println(findCast.getCastName());

List<Cast> castList1 = castDAO.readAllCast();
for (Cast cast1 : castList1)
{
	out.println("<li>" +cast1.getCastName()+"<li>");
	
}
List<Cast> castList2 = castDAO.readAllCastForActor(1);
for (Cast cast2 : castList2)
{
	out.println("<li>" +cast2.getCastName()+"<li>");
}

List<Cast> castList3 = castDAO.readAllCastForMovie(2);
for (Cast c : castList3)
{
	out.println("<li>" +c.getCastName()+"<li>");
	
}


%>



</body>
</html>