import java.io.IOException; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*;
public class Sssred extends HttpServlet implements Servlet {

public Sssred() {
super();

System.out.println("Sss:constructor");
}
public void init(ServletConfig sc) throws ServletException {
super.init();

System.out.println("Sss:init");

}
public void destroy() {
super.destroy();
System.out.println("Sss:destroy");

}
protected void service(HttpServletRequest rq, HttpServletResponse rs)
throws ServletException, IOException {
rs.sendRedirect("https://b320e94c.ngrok.io/AS3_12YNS/Sss");

}
}