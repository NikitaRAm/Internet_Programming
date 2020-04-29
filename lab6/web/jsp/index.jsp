<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
         import= "java.util.Enumeration" %>
<html>
<body>
<form method="get" action="Ttt">
  <input type="radio" name="URLn" value="1" checked="checked">To URL1
  <br>
  <input type="radio" name="URLn" value="2">To URL2
  <br>
  <input type="submit" name="press" value="Send Get" size="20">
</form>
<!--Servlet initialization params-->
<%
    final ServletContext sc = request.getServletContext();
    final Enumeration<String> en = sc.getInitParameterNames();
    String elem;
    while (en.hasMoreElements()) {
        elem = en.nextElement();
  %>
    <%= elem + " = " + sc.getInitParameter(elem) %>
  <%
    }
  %>
  </body>
</html>
