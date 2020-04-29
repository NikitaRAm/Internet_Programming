import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class PppD extends HttpServlet implements Servlet {
protected void doPost(HttpServletRequest rq, HttpServletResponse
rs) throws ServletException, IOException {
String firstname = rq.getParameter("firstname");
String lastname = rq.getParameter("lastname");
String password = rq.getParameter("password");
String sex = rq.getParameter("sex");
String press = rq.getParameter("press");
rs.setContentType("text/html");

RequestDispatcher rd = null;

if (press.equalsIgnoreCase("OK")) {
if (sex.equalsIgnoreCase("male"))
rd = rq.getRequestDispatcher("/index.html");
else if (sex.equalsIgnoreCase("female"))
rd = rq.getRequestDispatcher("/index.html");
} else
rd = rq.getRequestDispatcher("/index.html");
rd.forward(rq, rs);
}
}