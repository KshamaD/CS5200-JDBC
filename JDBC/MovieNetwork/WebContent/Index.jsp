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
//MovieManager dao= new MovieManager();
//Movie movie = new Movie();
//movie.setTitle("Shamitabh");
//movie.setPosterImage("Poster2");
//movie.setReleaseDate(null);
//dao.createMovie(movie);
 //Movie findMovie = dao.readMovie(2);
// out.println(findMovie.getTitle());
 
 //Movie m2 = new Movie();
 //m2.setTitle("Titanic");
 //dao.updateMovie(2, m2);
 //dao.deleteMovie(10);

//List<Movie> movieList = dao.readAllMovies();

//for (Movie m : movieList)
//{
//	out.println("<li>" +m.getTitle()+"<li>");
	
//}
//----------------
//UserManager userDAO= new UserManager();
//User user = new User();
//user.setUserName("Jose");
//user.setPassword("Jose");
//user.setFirstName("Jose");
//user.setLastName("Annunziato");
//user.setEmailID("jose@gmail.com");
//user.setDOB(null);
//userDAO.createUser(user);
 
//List<User> userList = userDAO.readAllUsers();

//for (User u : userList)
//{
	//out.println("<li>" +u.getUserName()+"<li>");
	
//}
//User findUser = userDAO.readUser("Jose");
//out.println(findUser.getFirstName());
//out.println(findUser.getEmailID());

//user.setEmailID("kshama123@gmail.com");
//user.setPassword("kd123");
 //userDAO.updateUser("Kshama", user);


  //userDAO.deleteUser("Jose");
  
  ///--------------------------------------------------Actor----------------------------
  
 ActorManager actorDAO= new ActorManager();
Actor actor = new Actor();

actor.setFirstName("Anushka");
actor.setLastName("Sharma");
actor.setDOB(null);
//actorDAO.createActor(actor);
 
 //actorDAO.updateActor(2, actor);
actorDAO.deleteActor(6);
List<Actor> actorList = actorDAO.readAllActors();

for (Actor a : actorList)
{
	out.println("<li>" +a.getFirstName()+"<li>");
	
}
//Actor findactor = actorDAO.readActor(1);
//out.println(findactor.getFirstName());
//out.println(findactor.getLastName());




  
%>



</body>
</html>