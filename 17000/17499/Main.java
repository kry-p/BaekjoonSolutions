import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        String[] input = reader.readLine().split(" ");

        int size = Integer.parseInt(input[0]);
        int queries = Integer.parseInt(input[1]);
        int startPos = 0; // 처음 읽는 위치

        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < queries; i++) {
            int[] query = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (query[0] == 1) {
                arr[(startPos + query[1] - 1) % size] += query[2];
            }
            if (query[0] == 2) {
                startPos = (startPos + (size - query[1])) % size;
            }
            if (query[0] == 3) {
                startPos = (startPos + query[1]) % size;
            }
        }

        for (int i = startPos; i < size; i++) 
            builder.append(arr[i] + " ");
        for (int i = 0; i < startPos; i++)
            builder.append(arr[i] + " ");
        
        System.out.print(builder.toString());
    }

}