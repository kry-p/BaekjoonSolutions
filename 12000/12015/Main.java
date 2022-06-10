import java.util.*;
import java.io.*;

public class Main {
    public static int[] lis;
    public static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(reader.readLine());
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        lis = new int[size];

        System.out.print(lowerBound(array));
    }

    public static int binarySearch(int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;

            if (lis[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static int lowerBound(int[] array) {
        lis[0] = array[0];
        int i = 1, j = 0;

        while (i < size) {
            if (lis[j] < array[i]) {
                lis[j + 1] = array[i];
                j += 1;
            } else {
                int index = binarySearch(0, j, array[i]);
                lis[index] = array[i];
            }
            i += 1;
        }

        return j + 1;
    }
}
