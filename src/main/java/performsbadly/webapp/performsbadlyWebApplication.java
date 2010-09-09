package performsbadly.webapp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class performsbadlyWebApplication {

    public static void main(String[] arguments) {
        try {
            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            context.addServlet(new ServletHolder(new BasicServlet()), "/cheddar");
            context.addServlet(new ServletHolder(new MathsServlet()), "/camembert");
            context.addServlet(new ServletHolder(new IOReadServlet()), "/brie");
            context.addServlet(new ServletHolder(new MemoryLeakServlet()), "/gruyere");

            Server server = new Server(8080);
            server.setHandler(context);
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
