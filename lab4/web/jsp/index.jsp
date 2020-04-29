<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jspClasses.Regimex" %>
<%@ page import="static java.lang.String.format" %>

<html>
  <head>
    <%!
        final Regimex regimex = new Regimex();

        int curDay = regimex.getDay();
        int curMonth = regimex.getMonth() + 1;
        int curYear = regimex.getYear();

        int curHours = regimex.getHours();
        int curMinutes = regimex.getMinutes();
        int curSeconds = regimex.getSeconds();

        protected String hi(final int hours) {
            return format("Good %s", hours < 12
                    ? (hours > 0 && hours <= 5) ? "night" : "morning"
                    : hours <= 17 ? "afternoon" : "evening");
        }

      protected int getPageByHour(final int hours) {
        return hours < 12
                ? (hours > 0 && hours <= 5) ? 0 : 1
                : hours <= 17 ? 2 : 3;
      }

      protected String getTime() {
        return format("%d:%d:%d", curHours, curMinutes, curSeconds);
      }

      protected String getDate() {
        return format("%d:%d:%d", curDay, curMonth, curYear);
      }

      protected String getDate(int raw) {
        return format("%d:%d:%d", curDay + raw, curMonth, curYear);
      }
    %>
  </head>
  <body>
  <p>
    <%= hi(curHours) %>
    <br>
    Now: <%= getTime() %>
  </p>
  <hr>
  <p>
  <table border="1">
    <tr>
      <td width="100px"><b>xx.dd.yyyy</b></td>
      <td width="100px"><b>Day of Week</b></td>
    </tr>
    <tr>
      <td width="100px"><%= getDate(0) %></td>
      <td width="100px"><%= regimex.getDayByDate(curDay, curMonth, curYear) %></td>
    </tr>
    <tr>
      <td width="100px"><%= getDate(1) %></td>
      <td width="100px"><%= regimex.getDayByDate(curDay + 1, curMonth, curYear) %></td>
    </tr>
    <tr>
      <td width="100px"><%= getDate(2) %></td>
      <td width="100px"><%= regimex.getDayByDate(curDay + 2, curMonth, curYear) %></td>
    </tr>
    <tr>
      <td width="100px"><%= getDate(3) %></td>
      <td width="100px"><%= regimex.getDayByDate(curDay + 3, curMonth, curYear) %></td>
    </tr>
    <tr>
      <td width="100px"><%= getDate(4) %></td>
      <td width="100px"><%= regimex.getDayByDate(curDay + 4, curMonth, curYear) %></td>
    </tr>
    <tr>
      <td width="100px"><%= getDate(5) %></td>
      <td width="100px"><%= regimex.getDayByDate(curDay + 5, curMonth, curYear) %></td>
    </tr>
    <tr>
      <td width="100px"><%= getDate(6) %></td>
      <td width="100px"><%= regimex.getDayByDate(curDay + 6, curMonth, curYear) %></td>
    </tr>
  </table>
  <hr>
  <p>
    <b>Use %Include%</b>
    <br>
    <%
      switch(getPageByHour(curHours)) {
        case 0:
    %>
    <%@include file="night.jsp"%>
<%--    <jsp:include page="night.jsp"/>--%>
<%--    <jsp:forward page="night.jsp"/>--%>
    <%
        break;
      case 1:
    %>
    <%@include file="morning.jsp"%>
<%--    <jsp:include page="morning.jsp"/>--%>
<%--    <jsp:forward page="morning.jsp"/>--%>
    <%
        break;
      case 2:
    %>
    <%@include file="afternoon.jsp"%>
<%--    <jsp:include page="afternoon.jsp"/>--%>
<%--    <jsp:forward page="afternoon.jsp"/>--%>
    <jsp:include page="/AfternoonServlet"/>
    <%
        break;
      case 3:
    %>
    <%@include file="evening.jsp"%>
<%--    <jsp:include page="evening.jsp"/>--%>
<%--    <jsp:forward page="evening.jsp"/>--%>
    <%
          break;
      }
    %>
  </p>
  <hr>
  <form action="JjjServlet">
    <a href="JjjServlet">Go to JjjServlet</a>
  </form>
  <form action="JjjServlet" method="get">
    <input type="submit" name="press" value="Request to servlet" size="20"/>
  </form>
  </body>
</html>
