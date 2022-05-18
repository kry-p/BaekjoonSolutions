import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    
    private static ArrayList<String> result;
    private static boolean isUsed[];
    private static String[] inequality;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        result = new ArrayList<String>();
        isUsed = new boolean[10];
        int size = Integer.parseInt(bufferedReader.readLine());
        inequality = bufferedReader.readLine().split(" ");
        
        run("", 0, size);
        Collections.sort(result);
        
        System.out.print(result.get(result.size() - 1) + "\n" + result.get(0));
    }

    static void run(String number, int position, int size) {
        if (position == size + 1) {
            result.add(number);    
        } else {
            for(int i = 0; i < 10; i++) {
                if (isUsed[i]) continue;
                else {
                    if (position == 0 || check(inequality[position - 1], Integer.parseInt(number.substring(position - 1)), i)) {
                        isUsed[i] = true;
                        run(number + Integer.toString(i), position + 1, size);
                        isUsed[i] = false;
                    }
                }
            }
        }
    }

    static boolean check(String inequal, int num1, int num2) {
        if (inequal.equals(">")) {
            if (num1 > num2)
                return true;
            else
                return false;
        } else {
            if (num1 < num2)
                return true;
            else
                return false;
        }
    }
}