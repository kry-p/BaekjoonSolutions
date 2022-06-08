import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int[] fibonacci = new int[40 + 1];
        fibonacci[1] = 1;
        for (int i = 2; i <= 40; i++) 
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        
        int testCase = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < testCase; i++) {
            int input = Integer.parseInt(reader.readLine());
            int fZero, fOne;
            if (input == 0) {
                fZero = 1;
                fOne = 0;
            } else {
                fZero = fibonacci[input - 1];
                fOne = fibonacci[input];
            }
            builder.append(fZero + " " + fOne + "\n");
        } 
        System.out.print(builder.toString());
    }
}