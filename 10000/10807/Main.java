import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        String[] numbers = reader.readLine().split(" ");
        String find = reader.readLine();
        
        int count = 0;

        for(String s:numbers){
            if(s.equals(find)) count+=1;
        }

        System.out.print(count);
    }
}