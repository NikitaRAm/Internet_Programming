import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class F1Filter implements Filter {
    public void destroy() {
        System.out.println("F1Filter: destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if(req.getParameter("Value1").equals("f1") && req.getParameter("Value2").equals("f1") && req.getParameter("Value3").equals("f1"))
        {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/block.jsp" );
            req.setAttribute("Bloking","Filter1 blocked this page");
            requestDispatcher.forward(req, resp);}
        else {chain.doFilter(req, resp);}
        System.out.println("F1Filter: doFilter");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("F1Filter: init");
    }
}
