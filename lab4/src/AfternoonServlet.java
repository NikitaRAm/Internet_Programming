import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AfternoonServlet extends HttpServlet implements Servlet {
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        final PrintWriter writer = response.getWriter();
        writer.println("Servlet: Good afternoon");
        writer.flush();
    }
}
