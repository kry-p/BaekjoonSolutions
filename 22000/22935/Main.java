import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int size = Integer.parseInt(reader.readLine());
        int[] array = new int[size];
        int temp;
        for (int i = 0; i < size; i++) {
            temp = (Integer.parseInt(reader.readLine()) - 1) % 28;
            if (temp > 13)
                array[i] = 28 - temp;
            else
                array[i] = temp;
        }

        for (int i : array) {
            String current = Integer.toBinaryString(i + 1);

            for (int j = 0; j < 4 - current.length(); j++)
                builder.append("V");

            for (int j = 0; j < current.length(); j++) {
                builder.append(current.charAt(j) == '1' ? "딸기" : "V");
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }
}