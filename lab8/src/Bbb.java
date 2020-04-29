import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Bbb extends HttpServlet {
	
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        response.addHeader("ResponseHeader1", "response1");
        response.addHeader("ResponseHeader2", "response2");
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        printWriter.println("<html><body>" +
                "Header1 = " + request.getHeader("P1") + "<br>" +
                "Header2 = " + request.getHeader("P2") + "<br>" +
                "Header3 = " + request.getHeader("P3") + "<br>" +
                "Param1 = " + request.getParameter("P1") + "<br>" +
                "Param2 = " + request.getParameter("P2") + "<br>" +
                "Param3 = " + request.getParameter("P3") + "<br>");
    }
}
