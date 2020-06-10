<%@ page import="com.github.sardine.Sardine" %>
<%@ page import="com.github.sardine.SardineFactory" %>
<%@ page import="com.github.sardine.DavResource" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: goldware
  Date: 25.05.2020
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div>
    <h3>Список файлов</h3>
    <%
      Sardine sardine = (Sardine) session.getAttribute("clientWebDav");
      if(sardine == null){
        sardine = SardineFactory.begin(
                application.getInitParameter("login"),
                application.getInitParameter("password")
        );
        session.setAttribute("clientWebDav", sardine);
      }
      List<DavResource> resources = sardine.list("https://webdav.yandex.ru");
      for (DavResource res : resources)
      {
        if(!res.isDirectory()){
    %>
      <a href="./zad1_servlet?action=downloadFile&file=<%=res.toString()%>"> <%=res.toString()%> </a><br/>
    <%}}%>
    <h3>Список папок</h3>
    <%
      for (DavResource res : resources)
      {
        if(res.isDirectory()){
    %>
    <a><%=res.toString()%> </a><br/>
    <%}}%>
  </div>


  <form action="zad1_servlet?action=createDir" method="post">
    <h4>Создать папку</h4>
    <input type="text" name="name">
    <input type="submit">
  </form>

  <form action="zad1_servlet?action=remove" method="post">
    <h4>Удалить</h4>
    <input type="text" name="name">
    <input type="submit">
  </form>

  <form action="zad1_servlet?action=move" method="post">
    <h4>Переместить</h4>
    Из<br/>
    <input type="text" name="from"><br/>
    В<br/>
    <input type="text" name="to"><br/>
    <input type="submit">
  </form>

  <form action="zad1_servlet" method="post"
        enctype="multipart/form-data">
    <h4>Загрузить</h4>
    <input type="file" name="file" size="50"/><br />
    <input type="submit"/>
  </form>
  </body>
</html>
