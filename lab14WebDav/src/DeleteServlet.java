import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static jspClasses.Constants.COPY_PATH;
import static jspClasses.Constants.DIR_NAME;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasicDropBoxImpl.delete(DIR_NAME);

        BasicDropBoxImpl.delete(COPY_PATH);
    }
}
