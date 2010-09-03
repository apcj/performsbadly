package spik.webapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Scanner;

public class IOReadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.getWriter().println(read());
    }

    private String read(){
        String spacer = "\n-------------------------------------------\n";
        long start = System.currentTimeMillis();
        String text = readText();
        long finish = System.currentTimeMillis();
        long time = finish - start;
        return text + spacer + "Time taken: " + time + spacer;
    }

    private String readText() {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("text.txt"));
            while(scanner.hasNextLine()){
                sb.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            scanner.close();
        }
        return sb.toString();
    }

}
