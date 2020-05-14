import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "zad3_servlet")
public class zad3_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Integer n = new Integer(request.getHeader("XRand-N"));
        XXRand num = new XXRand(n);
        response.setContentType("application/json");
        PrintWriter w = response.getWriter();
        String s ="{\"X\":[" ;
        for (int i = 0; i < 10; i++)
        {
            s += ("{\"rand\":"+ num.Get().toString()+"}"+
                    ((i < 9)?",":" "));
        }
        s+="]}";
        w.println(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("zad3_servlet: doGet");
    }

    public class XXRand {
        private Integer n = Integer.MAX_VALUE;
        private Random random = new Random();

        public XXRand(Integer n) {
            if (n > 0)
                this.n = n;
        }

        public Integer Get() {
            return (this.random.nextInt()%this.n);
        }
    }
}
