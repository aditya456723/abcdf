<%@ page import="java.sql.*" %>
<%@ page import="production.untitled.LoginDao.java" %>

<%
String username = request.getParameter("username");
String date = request.getParameter("date");
out.println("Debug: Username = " + username + ", Date = " + date); // Debug output
LoginDao dao = new LoginDao();

if(dao.validate(username, date)) {
    response.sendRedirect("home.html");
} else {
    out.println("Invalid username or date!");
}
%>

