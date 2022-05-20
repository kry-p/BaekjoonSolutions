import java.util.*;
import java.io.*;

public class Main {
    private final static int MAX = 30;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        int current = 666;
        int count = 0;
        
        while (true) {
            String currentStr = Integer.toString(current);
            int repeatCount = 0;
            for (int i = 0; i < currentStr.length(); i++) {
                if (currentStr.charAt(i) == '6') {
                    repeatCount += 1;
                } else {
                    repeatCount = 0;
                }
                if (repeatCount == 3) {
                    count += 1;
                    break;
                }
            }
            if (count == input) break;
            current += 1;
        }
        System.out.println(current);
    }
}