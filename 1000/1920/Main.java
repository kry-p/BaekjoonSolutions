import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(reader.readLine());
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int testSize = Integer.parseInt(reader.readLine());
        int[] test = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);

        for (int i = 0; i < test.length; i++) {
            boolean result = binarySearch(array, test[i]);
            if (result) 
                System.out.println(1);
            else    
                System.out.println(0);
        }
    }

    public static boolean binarySearch(int[] array, int find) {
        int low = 0, hi = array.length - 1, mid;

        while (low <= hi) {
            mid = (low + hi) / 2;
            if (array[mid] == find)
                return true;
            else if (array[mid] > find)
                hi = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}
