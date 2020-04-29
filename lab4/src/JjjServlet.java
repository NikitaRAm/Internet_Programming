import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JjjServlet extends HttpServlet implements Servlet {
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        final Date date = new Date();
        final int hour = date.getHours();
        RequestDispatcher requestDispatcher = null;

        System.out.println("_GET_");
        if(hour > 0 && hour <= 5)
        {
            requestDispatcher = request.getRequestDispatcher("jsp/night.jsp");
        }
        else if(hour > 5 && hour < 12)
        {
            requestDispatcher = request.getRequestDispatcher("jsp/morning.jsp");
        }
        else if (hour >= 12 && hour <= 17)
        {
            requestDispatcher = request.getRequestDispatcher("jsp/afternoon.jsp");
        }
        else
        {
            requestDispatcher = request.getRequestDispatcher("jsp/evening.jsp");
        }
        requestDispatcher.forward(request, response);
    }
}
