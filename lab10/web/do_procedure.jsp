<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Connection connection= null;	
    String snameCommand = request.getParameter("param");
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    try {
        Class.forName(driverName);
        connection = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:8080;" +
                        "databaseName=BD;" +
                        "user=user;" +
                        "password=12345678"
        );
        int count;

        CallableStatement callableStatement =
                connection.prepareCall("{ ? = CALL getId(?) }");

        callableStatement.registerOutParameter(1, Types.INTEGER); 
		callableStatement.setString(2,snameCommand);
        callableStatement.execute();
        count = callableStatement.getInt(1);
        session.setAttribute("procedure", count);
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<jsp:forward page="index.jsp"/>
