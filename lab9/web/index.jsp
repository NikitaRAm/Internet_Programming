<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Lab 9</title>
  </head>
  <body>
  <form method="get" action="CccServletRequest">
    <h3>Chain</h3>
    <label>Old<input type="radio" name="CBean" value="old" checked="checked" /></label>
    <label>New<input type="radio" name="CBean" value="new"/></label>
    <br />
    <label>Value1:</label>
    <input name="Value1" type="text" size="10" />
    <br />
    <label>Value2:</label>
    <input type="text" name="Value2" size="10"/>
    <br />
    <label>Value3:</label>
    <input type="text" name="Value3" size="10"/>
    <br />

    <input type="submit" value="OK" />
  </form>
    <form method="get" action="NotBlocked.jsp">
      <h3>JSP</h3>
      <label>Old<input type="radio" name="CBean" value="old" checked="checked" /></label>
      <label>New<input type="radio" name="CBean" value="new"/></label>
      <br />
      <label>Value1:</label>
      <input name="Value1" type="text" size="10" />
      <br />
      <label>Value2:</label>
      <input type="text" name="Value2" size="10"/>
      <br />
      <label>Value3:</label>
      <input type="text" name="Value3" size="10"/>

      <br />
      <input type="submit" value="OK" />
    </form>
  </body>
</html>
