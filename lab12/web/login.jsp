
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>FORM login</title>
</head>
<body>
<form method="post" action="j_security_check">
    username <input type="text" name="j_username" />
    password <input type="password" name="j_password" />
    <input type="submit" />
</form>
</body>
</html>
