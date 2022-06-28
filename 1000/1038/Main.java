import java.util.*;
import java.io.*;

public class Main { 
    private static boolean flag;
    private static int current, prev, temp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int count = 0;
        int i = 1;
        int j = 0;
        if (n > 1022) {
            System.out.println(-1);
            return;
        }
        if (n == 1022) {
            System.out.println("9876543210");
            return;
        }
        if (n < 10) {
            System.out.println(n);
            return;
        }
        int[] from = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        int[] to = {10, 210, 3210, 43210, 543210, 6543210, 76543210, 876543210};

        while (true) {
            if (i > 987654322) break;
            if (j < 8 && i == from[j]) {
                i = to[j];
                j += 1;
            }
            current = i;
            flag = true;
            prev = current % 10;
            current /= 10;
            while (current > 0) {
                temp = current % 10;
                if (prev >= temp) {
                    flag = false;
                    break;
                }
                prev = temp;
                current /= 10;
            }
            if (flag)  count += 1;
            if (count == n) {
                System.out.println(i);
                return;
            }
            i += 1;
        }
        System.out.println(-1);
    }
}