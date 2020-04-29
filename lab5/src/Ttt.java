import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.String.format;

public class Ttt extends HttpServlet {

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        writer.write(format("First name: %s \nLastName: %s \nSex: %s", req.getParameter(Constants.FIRST_NAME),
                req.getParameter(Constants.LAST_NAME), req.getParameter(Constants.SEX)));
        writer.close();
    }
}
