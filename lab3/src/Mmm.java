import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Mmm extends HttpServlet implements Servlet {
public void doGet(HttpServletRequest rq, HttpServletResponse rs)
throws ServletException, IOException {
String firstname = rq.getParameter("firstname");
String lastname = rq.getParameter("lastname");
rs.setContentType("text/html");
PrintWriter pw = rs.getWriter();
pw.println("<html> <body> <br>Mmm:doGet:firstname=" +
firstname
+ "<br>Mmm:doGet:lastname=" + lastname + "<body><html>");
pw.flush();
}
}