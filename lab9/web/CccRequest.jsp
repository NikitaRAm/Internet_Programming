<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import= "CBean.*"%>
<html>
    <head>
        <title>CccRequest.jsp</title>
    </head>
    <body>
        CBean Values
        <%
        CBean cBean = (CBean) request.getAttribute("atrRequest");
        if (cBean != null){
        %>
        <p>
        Value1:
        <%=cBean.GetValue1()%>
        <br /> Value2:
        <%=cBean.GetValue2()%>
        <br /> Value3:
        <%=cBean.GetValue3()%>
        <br />
        </p>
        <%} %>
    </body>
</html>
