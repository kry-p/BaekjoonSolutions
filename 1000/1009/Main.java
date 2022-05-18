import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int testCase = Integer.parseInt(reader.readLine());
        int result;

        for (int i = 0; i < testCase; i++) {
            String[] input = reader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            result = 1;
           
            for (int j = 0; j < b; j++) 
                result = a * result % 10;
            
            if (result == 0)
                result = 10;
            builder.append(result + "\n");
        }
        System.out.print(builder.toString());
    }
}