import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int find = Integer.parseInt(reader.readLine());
        int count = 0;
        Arrays.sort(arr);

        int ptr1 = 0;
        int ptr2 = size - 1;

        while (ptr1 < ptr2) {
            int current = arr[ptr1] + arr[ptr2];
            if (current == find) {
                count += 1;
            }
            if (current <= find)
                ptr1 += 1;
            else
                ptr2 -= 1;
        }

        System.out.println(count);
    }

}
