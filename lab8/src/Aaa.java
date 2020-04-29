import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Aaa extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpClient client = new HttpClient();

        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PostMethod postMethod = new PostMethod( "http://localhost:8080/lab8/" + "Bbb");
        postMethod.addParameter("P1", request.getParameter("P1"));
        postMethod.addParameter("P2", request.getParameter("P2"));
        postMethod.addParameter("P3", request.getParameter("P3"));
        postMethod.addRequestHeader("P1", request.getParameter("P1"));
        postMethod.addRequestHeader("P2", request.getParameter("P2"));
        postMethod.addRequestHeader("P3", request.getParameter("P3"));
        client.executeMethod(postMethod);

        if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream()));
            PrintWriter pw = response.getWriter();
            String part;
            StringBuffer res = new StringBuffer();

            while ((part = reader.readLine()) != null)
            {
                res.append(part);
            }
            reader.close();

            pw.println("<html><body>" +  res.toString() + "<br>" +
                    postMethod.getResponseHeader("ResponseHeader1") + "<br>" +
                    postMethod.getResponseHeader("ResponseHeader2") +
                    "</body></html>");
            pw.close();
        }
    }
}
