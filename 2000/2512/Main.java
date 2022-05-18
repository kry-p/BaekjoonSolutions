import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long sum = 0;
        long answer = 0;

        long[] budget = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long maximumBudget = Long.parseLong(reader.readLine());
        Arrays.sort(budget);

        for (long i : budget) sum += i;

        if (sum <= maximumBudget) {
            System.out.print(budget[n - 1]);
        } else {
            long left = 0;
            long right = budget[n - 1];
    
            while (left <= right) {
                sum = 0;
                long mid = (left + right) / 2;

                for (long i : budget) {
                    if (i >= mid) sum += mid;
                    else sum += i;
                }

                if (sum > maximumBudget) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                    answer = Math.max(answer, mid);
                }
            }
            System.out.println(answer);
        }

    }   
}