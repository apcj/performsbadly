package performsbadly.webapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jbull
 * Date: Sep 9, 2010
 * Time: 7:53:08 PM
 * To change this template use File | Settings | File Templates.
 */



public class MemoryLeakServlet {
    private String message;
    private List<String> importantCollectionOfStuff;
    private String sillyString;
    private static final int LEAKYNESS = 1000;

    public MemoryLeakServlet() {
        this.message = "Mmmmmn Leaky";
        importantCollectionOfStuff = new ArrayList<String>();
        sillyString = "This is a silly string.";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LeakMemory(LEAKYNESS);
        response.setContentType("text/plain");
        response.getWriter().println(message);
    }

    private void LeakMemory(int leakyness) {
        for(int x = 0 ; x < leakyness ; x++){
           importantCollectionOfStuff.add(sillyString);
        }
    }
}
