package performsbadly.webapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemoryLeakServlet extends HttpServlet {
    private String message;
    private List<String> importantCollectionOfStuff;
    private String sillyString;
    private static final int LEAKINESS = 100;

    public MemoryLeakServlet() {
        this.message = "Gruyere packed and dispatched";
        importantCollectionOfStuff = new ArrayList<String>();
        sillyString = "This is a silly string.";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LeakMemory(LEAKINESS);
        response.setContentType("text/plain");
        response.getWriter().println(message);
    }

    private void LeakMemory(int leakiness) {
        for(int x = 0 ; x < leakiness ; x++){
           importantCollectionOfStuff.add(sillyString);
        }
    }
}
