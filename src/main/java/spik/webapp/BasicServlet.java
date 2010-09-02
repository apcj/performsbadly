package spik.webapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: sgreenha
 * Date: Sep 2, 2010
 * Time: 12:25:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicServlet extends HttpServlet{

    private String message = "Hello from a basic servlet";

    public BasicServlet(){}
    public BasicServlet(String message) {
        this.message = message;
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>"+message+"</h1>");
        response.getWriter().println("<h3>Current Time:</h3> " + new Date(System.currentTimeMillis()));
    }
}

