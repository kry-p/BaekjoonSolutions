import java.util.*;
import java.io.*;

public class Main {
    private final static int[] DX = { 1, 1, 0, -1, -1, -1, 0, 1};
    private final static int[] DY = { 0, -1, -1, -1, 0, 1, 1, 1}; 

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int size = Integer.parseInt(reader.readLine());
        int[][] map = new int[size][size];
        String[][] result = new String[size][size];

        for (int i = 0; i < size; i++) {
            String s = reader.readLine();
            for (int j = 0; j < size; j++) {
                int current = s.charAt(j) - 48;
                if (current > 0 && current < 10) {
                    map[i][j] = current;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] > 0) {
                    result[i][j] = "*";
                } else {
                    int sum = 0;

                    for (int k = 0; k < 8; k++) {
                        int nextX = i + DX[k];
                        int nextY = j + DY[k];
    
                        if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size)
                            continue;
                        sum += map[nextX][nextY];
                    }
                    result[i][j] = sum < 10 ? Integer.toString(sum) : "M";
                }
                builder.append(result[i][j]);
            }
            builder.append("\n");
        }
        System.out.print(builder.toString());
    }
}