package performsbadly.webapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: jbull
 * Date: Sep 9, 2010
 * Time: 9:38:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class PoorResponseTimeServlet extends HttpServlet {
        private String message = "Stilton packed and dispatched";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        pause();
        response.getWriter().println(message);
    }

    private void pause() {
        try {
            Thread.sleep(1145);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
