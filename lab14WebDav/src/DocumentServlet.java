import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static jspClasses.Constants.*;

@WebServlet("/DocumentServlet")
public class DocumentServlet extends HttpServlet {

    @Override
    public void init() {
        BasicDropBoxImpl.init();
    }

    @Override
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) {
        BasicDropBoxImpl.createDirectory(DIR_NAME);

        BasicDropBoxImpl.upload(LOCAL_FILE_PATH, FILE_PATH);

        BasicDropBoxImpl.download(FILE_PATH);

        BasicDropBoxImpl.copyFile(FILE_PATH, COPY_PATH);
    }
}
