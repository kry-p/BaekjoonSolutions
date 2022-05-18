import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) 
            list.add(Integer.parseInt(reader.readLine()));

        Collections.sort(list);

        for (int i = 0; i < size; i++) {
            int temp = list.get(i) * (size - i);
            if (temp > max) 
                max = temp;
        }
        
        System.out.print(max);
    }
}