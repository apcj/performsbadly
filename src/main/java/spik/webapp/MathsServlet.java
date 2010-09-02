package spik.webapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

public class MathsServlet extends HttpServlet {

    private String message = "I have done some maths";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doSomeMaths();

        response.setContentType("text/plain");
        response.getWriter().println(message);
    }

    private void doSomeMaths() {
        for (int i = 0; i < 1000; i++) {
            factorial(1000);
        }
    }

    private BigInteger factorial(int i) {
        if (i <= 0) return BigInteger.valueOf(1);
        return factorial(i - 1).multiply(BigInteger.valueOf(i));
    }
}