package spik.webapp;

import org.eclipse.jetty.server.Server;

public class HelloWorld {

    public static void main(String[] arguments) {
        try {
            new Server().start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
