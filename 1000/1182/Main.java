import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static int count = 0, size, target;
    private static int[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] criteria = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        size = criteria[0];
        target = criteria[1];
        find(0, 0);

        // 전부 세지 않았을 때 (합이 0)를 제외
        System.out.println(target == 0 ? count -= 1 : count);
    }
    
    public static void find(int currentIndex, int currentSum) {
        if (currentIndex == size) {
            if (currentSum == target) 
                count += 1;
            return;
        }

        find(currentIndex + 1, currentSum);
        find(currentIndex + 1, currentSum + input[currentIndex]);
    }
}