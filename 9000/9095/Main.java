import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int attempt = Integer.parseInt(reader.readLine());
        int[] result = new int[11];

        result[1] = 1;
        result[2] = 2;
        result[3] = 4;
        
        for (int i = 4; i < 11; i++)
            result[i] = result[i - 1] + result[i - 2] + result[i - 3];
    
        for (int i = 0; i < attempt; i++) 
            System.out.println(result[Integer.parseInt(reader.readLine())]);
    }
}
