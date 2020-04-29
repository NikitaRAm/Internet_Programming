<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%! String nameCommand;
    String idCommand;
%>
<%
    Connection con= null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    String sql = "select Id, Name from noTable where Name=?";

    String snameCommand = request.getParameter("command");

    if(!(snameCommand.equals(null) || snameCommand.equals("")))
    {
        try{
            Class.forName(driverName);
            con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:8080;" +
                            "databaseName=BD;" +
                            "user=user;" +
                            "password=12345678"
            );
            ps = con.prepareStatement(sql);
            ps.setString(1, snameCommand);
            rs = ps.executeQuery();
            if(rs.next())
            {
%>
                <%=rs.getString("Id") %>
                <%=rs.getString("Name") %>
<%
            }
            rs.close();
            ps.close();
        }
        catch(SQLException sqe)
        {
            out.println(sqe);
        }
    }

%>
</body>
</html>