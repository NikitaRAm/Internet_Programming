import CBean.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CccServletSession")
public class CccServletSession extends HttpServlet {

    CBean cBean;

    @Override
    public void init() throws ServletException {
        super.init();
        this.cBean = new CBean(null, null, null);
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("atrCBean", cBean);
        System.out.println("CccServletSession: init");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CccServletSession: service");

        String CBean = request.getParameter("CBean");
        String Value1 = request.getParameter("Value1");
        String Value2 = request.getParameter("Value2");
        String Value3 = request.getParameter("Value3");
        String queryStr = request.getQueryString();

        HttpSession session = request.getSession();
        String idSession = session.getId();

        if (session.getAttribute(idSession) == null) {
            this.cBean = new CBean(null, null, null);
            session.setAttribute(idSession, this.cBean);
        }

        if (CBean.equalsIgnoreCase("new")) {
            this.cBean = new CBean(null, null, null);
            session.setAttribute(idSession, this.cBean);
        }

        if (!Value1.equalsIgnoreCase(""))
            this.cBean.SetValue1(Value1);
        else
            cBean.SetValue1(cBean.GetValue1());

        if (!Value2.equalsIgnoreCase(""))
            this.cBean.SetValue2(Value2);
        else
            cBean.SetValue2(cBean.GetValue2());

        if (!Value3.equalsIgnoreCase(""))
            this.cBean.SetValue3(Value3);
        else
            cBean.SetValue3(cBean.GetValue3());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/CccSession.jsp?" + queryStr);
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
