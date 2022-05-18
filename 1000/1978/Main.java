import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int primeNumberCount = 0;

        for (int i : input) 
            if (isPrimeNumber(i))
                primeNumberCount += 1;


        System.out.println(primeNumberCount);
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) 
            return false;
        
        for (int i = 2; i * i <= number; i++) 
            if (number % i == 0) 
                return false;

        return true;
    }
}