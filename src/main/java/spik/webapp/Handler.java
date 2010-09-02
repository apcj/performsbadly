package spik.webapp;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: sgreenha
 * Date: Sep 2, 2010
 * Time: 11:42:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Handler extends AbstractHandler {

        public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException, ServletException {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            request.setHandled(true);
            response.getWriter().println("<h1>Hello World</h1>");
        }
    }
