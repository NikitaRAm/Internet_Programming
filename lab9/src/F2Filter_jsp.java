import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class F2Filter_jsp implements Filter {
    public void destroy() {
        System.out.println("F2Filter: destroy");
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if(req.getParameter("Value1").equals("jsp") && req.getParameter("Value2").equals("jsp") && req.getParameter("Value3").equals("jsp"))
        {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/block.jsp" );
            req.setAttribute("Bloking","Filter2 for jsp blocked this page");
            requestDispatcher.forward(req, resp);}
        else {chain.doFilter(req, resp);}

        System.out.println("F2Filter_jsp: doFilter");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("F2Filter_jsp: init");
    }

}