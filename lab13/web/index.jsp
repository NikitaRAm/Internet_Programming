<%@ page import="classes.ChoiseXXX" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%
    String d = (String) config.getServletContext().getInitParameter("doc-dir");
    ChoiseXXX ch = new ChoiseXXX(d, "docx");
    String ll = null;
    for (int i = 0; i < ch.listxxx.length; i++) {
      ll = ch.listxxx[i];
  %>
  <br />
  <a href="Sss?file=<%=ll%>"> <%=ll%> </a>
  <%}%>
  <h1>File Upload</h1>
  <form method="post" action="Sss"
        enctype="multipart/form-data">
    Select file to upload: <input type="file" name="file" size="60" /><br />
    <br /> <input type="submit" value="Upload" />
  </form>
  </body>
</html>
