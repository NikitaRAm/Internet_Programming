import java.io.IOException;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;       
 
public class Sss extends HttpServlet implements Servlet 
{  
	public Sss() 
	{       
		super();       
		System.out.println("Sss:constructor");  
	}  
	
	public void init(ServletConfig sc) throws ServletException
	{                    
		super.init();       
		System.out.println("Sss:init");  
	}     
	
	public void destroy() 
	{                                                   
		super.destroy();     
		System.out.println("Sss:destroy");		
	}    
	
	/*protected void service(HttpServletRequest rq,  HttpServletResponse rs) throws ServletException,  IOException 
	{   
	
		/*System.out.println("Sss:service:"+rq.getMethod());

		rs.setContentType("text/html");                             
		PrintWriter pw = rs.getWriter();                           
		pw.println("<html><body>"
				+"Sss:constructor<br>"
				+"Sss:init<br>"                                         
				+"Sss:service:"+rq.getMethod()+"<br>"
				+"Type of call: "+rq.getMethod()+"<br>"       
				+"ServerName:      "+rq.getServerName()+"<br>"
				+"IP:      "+rq.getLocalName() +"<br>"
				+"</body></html>");                                        
		pw.close();  
	}*/
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String message = "";
		String parm1 = rq.getParameter("page");
		String parm2 = rq.getParameter("name");
		message += "Sss:doGet";
		System.out.println("Sss:doGet:page=" + parm1);
		System.out.println("Sss:doGet:name=" + parm2);
		rs.setContentType("text/html");
		PrintWriter pw = rs.getWriter();
		pw.println("<html><body>"
			+ "<hr>" + message
		+"<hr><br>Sss:doGet: page=" + parm1
		+"<br>Sss:doGet: name=" + parm2 
		+"<br>Sss:getRemoteHost: "+rq.getRemoteHost()
		+"<br>Sss:getServletPath: "+rq.getServletPath()
		+"<br>Sss:getServerName: "+rq.getServerName()
		+"<br>Sss:rq.getContextPath: " + rq.getContextPath() 
		+ "<br>Sss:rq.getRequestURI: " + rq.getRequestURI()
		+ "<br>Sss:rq.getRequestURL: " + rq.getRequestURL()
		+ "<br>Sss:rq.getRequestURI: " + rq.getRequestURI()
		+ "<br>Sss:rq.getRequestURL: " + rq.getRequestURL()
		+ "</body></html>");
		pw.close();
	}
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String message = "";
		message += "Sss:doPost";
		String firstname = rq.getParameter("firstname");
		String lastname = rq.getParameter("lastname");
		rs.setContentType("text/html");
		PrintWriter pw = rs.getWriter();
		pw.println("<html> " + "<body> "
			 + message
		+ "<br>Sss:doPost:firstname=" + firstname
		+ "<br>Sss:doPost:lastname= " + lastname
		+ "</body>" + "</html>");
		pw.close();
	}    
} 
