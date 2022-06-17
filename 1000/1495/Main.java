import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nsm = reader.readLine().split(" ");
        int n = Integer.parseInt(nsm[0]);
        int s = Integer.parseInt(nsm[1]);
        int m = Integer.parseInt(nsm[2]);
        int[] volumes = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[][] result = new boolean[n][m + 1];

        if (s + volumes[0] <= m) result[0][s + volumes[0]] = true;
        if (s - volumes[0] >= 0) result[0][s - volumes[0]] = true;

        for (int i = 1; i < n; i++) 
            for (int j = 0; j <= m; j++) 
                if (result[i - 1][j]) {
                    if (j + volumes[i] <= m) result[i][j + volumes[i]] = true;
                    if (j - volumes[i] >= 0) result[i][j - volumes[i]] = true;
                }

        for (int i = m; i >= 0; i--) {
            if (result[n - 1][i]) {
                System.out.print(i);
                return;
            }
        }
        System.out.print(-1);
    }
}