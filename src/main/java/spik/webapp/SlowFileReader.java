package spik.webapp;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: sgreenha
 * Date: Sep 2, 2010
 * Time: 1:28:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class SlowFileReader {

    public BufferedReader getTextReader(){
        File file = new File("text.txt");
        BufferedReader buf;
        try {
            buf = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return buf;
    }

    public String readText(){
        BufferedReader buf = getTextReader();

        int lineCount = 1;
        int whileCount = 1;
        Boolean continueReading = true;
        StringBuilder sb = new StringBuilder();

        try {
            while(continueReading){
                if(buf.readLine() != null) {
                    continueReading = false;
                }
                if(lineCount == whileCount){
                    String line = buf.readLine();

                    System.out.println(lineCount + ") " + line);
                    sb.append(lineCount + ") ");
                    sb.append(line);
                    lineCount++;
                    buf = getTextReader();
                }
                whileCount++;
                buf.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        SlowFileReader fileReader = new SlowFileReader();
        long start = System.currentTimeMillis();
        System.out.println(fileReader.readText());
        long finish = System.currentTimeMillis();
        long time = finish - start;
        System.out.println("-------------------------------------------");
        System.out.println("Time taken: " + time);
    }
}
