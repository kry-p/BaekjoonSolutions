import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] sum;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[size];
        sum = new int[size + 1];
        
        String[] arrString = bufferedReader.readLine().split(" ");

        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(arrString[i]);
        }
        
        calculate1(array, size);
        System.out.print(calculate2(array, size));
    }
    
    static void calculate1(int[] arr, int size) {
        sum[0] = arr[0];
        
        for(int i = 1; i < size; i++)
            sum[i] = Math.max(arr[i], arr[i] + sum[i - 1]);
    }
    
    static int calculate2(int[] arr, int size) {
        int max = sum[0];
        
        for (int i = 0; i < size ; i++) {
            if (sum[i] > max)
                max = sum[i];
        }
        
        return max;
    }
}