import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class zad1_servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
//        try {
//            Thread.currentThread().sleep(10000);  // 10 sec
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        Float x = new Float(request.getHeader("value-x"));
        Float y = new Float(request.getHeader("value-y"));
        Float z = x + y;
        System.out.println(z.toString());
        response.setHeader("value-z", z.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        response.getWriter().print("zad1_servlet: doGet");
    }
}
