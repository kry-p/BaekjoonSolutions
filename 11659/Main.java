import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class Main {

    private static int arraySize, subtotalCount;
    private static int[] array, subtotal;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            StringBuilder builder = new StringBuilder();

            arraySize = Integer.parseInt(stringTokenizer.nextToken());
            subtotalCount = Integer.parseInt(stringTokenizer.nextToken());

            array = new int[arraySize];
            subtotal = new int[arraySize];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int i = 0; i < arraySize; i++) {
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            // calculate subtotal
            for (int i = 0; i < array.length; i++) {
                if (i == 0) {
                    subtotal[i] = array[i];
                } else {
                    subtotal[i] = array[i] + subtotal[i - 1];
                }
            }

            for (int i = 0; i < subtotalCount; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                int from = Integer.parseInt(stringTokenizer.nextToken());
                int to = Integer.parseInt(stringTokenizer.nextToken());

                if (from == 1) {
                    builder.append(Integer.toString(subtotal[to - 1]) + "\n");
                } else {
                    builder.append(Integer.toString(subtotal[to - 1] - subtotal[from - 2]) + "\n");
                }
            }

            System.out.println(builder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
