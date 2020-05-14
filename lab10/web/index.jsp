<%@ page import="com.microsoft.sqlserver.jdbc.SQLServerDriver" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.*" %>

<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <title>Lab 10</title>
</head>
<br>
<body>
<h3>SELECT</h3>
    <%try {
        Connection connection;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:61653;" +
                        "databaseName=java;" +
                        "user=nikita;" +
                        "password=12345678"
        );
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT Id, Name FROM Users");


        while(resultSet.next())
        {
    %>
    <%=resultSet.getString(1)%> &nbsp;&nbsp;
    <%=resultSet.getString(2)%><br/>
    <%  }

        resultSet.close();
        connection.close();
        statement.close();
    }
    catch(Exception e)
    {
        e.getMessage();
    }
    %>
<br>
<br>
<form method="post" action="select_query.jsp">
<h3>Marker</h3>
    Name
    <br>
    <input type="text" name="command"/>
    <br>
    <input type="submit" value="Find"/>
    <br>
</form>
<br>
<br>
<form method="post" action="do_procedure.jsp">
    <h3>Procedure</h3>
    Id: <%= session.getAttribute("procedure") != null ? session.getAttribute("procedure") : "Don't executed"%>
    <br>
	<input type="text" name="param" value="Name1"/>
    <input type="submit" value="Run"/>
</form>
</body>
</html>

