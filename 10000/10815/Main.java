import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int inputSize = Integer.parseInt(reader.readLine());
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    
        int findSize = Integer.parseInt(reader.readLine());
        int[] find = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(input);
        for (int i : find) 
            builder.append(Arrays.binarySearch(input, i) > -1 ? "1 " : "0 ");
        System.out.print(builder.toString());
    }
}
