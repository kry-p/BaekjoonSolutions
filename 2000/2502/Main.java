import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int day = Integer.parseInt(input[0]);
        int dduk = Integer.parseInt(input[1]);

        int[] d1 = new int[day + 1];
        int[] d2 = new int[day + 1];

        if (day == 3) {
            System.out.println("1\n" + Integer.toString(dduk - 1));
            return;
        }

        d1[3] = d2[3] = 1;
              
        d1[4] = 1;
        d2[4] = 2;
    
        for (int i = 5; i <= day; i++) {
            d1[i] = d1[i - 1] + d1[i - 2];
            d2[i] = d2[i - 1] + d2[i - 2];
        }
        
        for (int i = 1; i <= 100000; i++) {
            if ((dduk - d1[day] * i) % d2[day] == 0) {
                System.out.println(Integer.toString(i) + "\n" + String.valueOf((dduk - d1[day] * i) / d2[day]));
                break;
            }
        }
    }

}
