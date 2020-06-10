import com.github.sardine.DavResource;
import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

@WebServlet(name = "zad1_servlet")
@MultipartConfig
public class zad1_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Sardine sardine = (Sardine) session.getAttribute("clientWebDav");
        if(sardine == null){
            sardine = SardineFactory.begin(
                    getServletContext().getInitParameter("login"),
                    getServletContext().getInitParameter("password")
            );
            session.setAttribute("clientWebDav", sardine);
        }

        String action =  request.getParameter("action");
        if(action != null) {
            switch (action) {
                case "createDir": {
                    String name = request.getParameter("name");
                    sardine.createDirectory("https://webdav.yandex.ru/" + name);
                    break;
                }
                case "remove": {
                    String name = request.getParameter("name");
                    sardine.delete("https://webdav.yandex.ru/" + name);
                    break;
                }
                case "move": {
                    String from = request.getParameter("from");
                    String to = request.getParameter("to");
                    sardine.move("https://webdav.yandex.ru/" + from,
                            "https://webdav.yandex.ru/" + to);
                    break;
                }
            }
        }
        else{
            String fileName = "";
            for (Part part : request.getParts()) {
                fileName = extractFileName(part);

                fileName = new File(fileName).getName();
                part.write( getServletContext().getInitParameter("doc-dir")+ File.separator + fileName);
            }
            byte[] data = readFile(new File(getServletContext().getInitParameter("doc-dir")+ File.separator + fileName)).getBytes();
            sardine.put("https://webdav.yandex.ru/" + fileName, data);
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Sardine sardine = (Sardine) session.getAttribute("clientWebDav");
        if(sardine == null){
            sardine = SardineFactory.begin(
                    getServletContext().getInitParameter("login"),
                    getServletContext().getInitParameter("password")
            );
            session.setAttribute("clientWebDav", sardine);
        }

        String action =  request.getParameter("action");

        switch (action){
            case "downloadFile":{
                String name = request.getParameter("file");
                InputStream is = sardine.get("https://webdav.yandex.ru" + name);

                response.setContentType("application/msword");
                response.addHeader("Content-Disposition", "attachment; filename="+ name);
                response.setContentLength(is.available());

                //FileInputStream in = new FileInputStream(doc);
                BufferedInputStream buf = new BufferedInputStream(is);
                ServletOutputStream out = response.getOutputStream();
                int readBytes = 0;
                while ((readBytes = buf.read()) != -1)
                    out.write(readBytes);
                break;
            }
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
    public static String readFile(File file) {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append('\n');
            }
            return String.valueOf(builder);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return "";
    }
}
