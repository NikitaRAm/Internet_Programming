import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
public class Ppp extends HttpServlet implements Servlet {
protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
throws ServletException, IOException {
String firstname = rq.getParameter("firstname");
String lastname = rq.getParameter("lastname");
String password = rq.getParameter("password");
String sex = rq.getParameter("sex");
String press = rq.getParameter("press");
HttpClient hc = new HttpClient();
GetMethod gm;
String uri = "https://b320e94c.ngrok.io" + rq.getContextPath();

if (press.equalsIgnoreCase("OK")) {
String parmstr = "firstname=" + firstname + "&"
+ "lastname=" + lastname;

if (sex.equalsIgnoreCase("male"))
uri += "/Mmm?" + parmstr;

else
 if (sex.equalsIgnoreCase("female"))
uri += "/Ggg?" + parmstr;

} else
uri += "/index.html";
hc.executeMethod(gm = new GetMethod(uri));
rs.setContentType("text/html");
PrintWriter pw = rs.getWriter();
pw.println(gm.getResponseBodyAsString());
pw.flush();
}
}