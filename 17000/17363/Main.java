import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static char[] from = {'.', 'O', '-', '|', '/', '\\', '^', '<', 'v', '>'};
    private static char[] to = {'.', 'O', '|', '-', '\\', '/', '<', 'v', '>', '^'};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[][] picture = new char[size[0]][size[1]];
        char[][] landscapePicture = new char[size[1]][size[0]];

        for (int i = 0; i < size[0]; i++) {
            String s = reader.readLine();
            for (int j = 0; j < size[1]; j++) 
                picture[i][j] = s.charAt(j);
        }

        for (int i = 0; i < size[1]; i++) {
            for (int j = 0; j < size[0]; j++) {
                landscapePicture[i][j] = picture[j][i];
                for (int k = 0; k < from.length; k++) {
                    if (landscapePicture[i][j] == from[k]) {
                        landscapePicture[i][j] = to[k];
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < size[1]; i++) {
            for (int j = 0; j < size[0]; j++) {
                System.out.print(landscapePicture[size[1] - i - 1][j]);
            }
            System.out.println();
        }
    }    
}