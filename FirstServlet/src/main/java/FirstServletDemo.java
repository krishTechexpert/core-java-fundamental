import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
//jakarta.servlet (previously javax.servlet in servlet 5.0 version k baad change)
public class FirstServletDemo  extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        out.println("<h1>Hello from GenericServlet! My First Servlet</h1>");
    }
}
