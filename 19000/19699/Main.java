import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] h, result;
    private static boolean[] isVisited;
    private static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        set = new HashSet<>();
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        h = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        isVisited = new boolean[n];
        result = new int[m];
        Arrays.sort(h);
        dfs(0, 0);

        if (set.size() == 0) System.out.print(-1);
        else {
            Integer[] result = set.toArray(new Integer[0]);
            Arrays.sort(result);
            StringBuilder builder = new StringBuilder();
            for (int i : result) builder.append(i + " ");
            System.out.print(builder.toString());
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number == 1) 
            return false;
        
        for (int i = 2; i * i <= number; i++) 
            if (number % i == 0) 
                return false;

        return true;
    }

    private static void dfs(int depth, int latest) {
        if (depth == m) {
            int sum = 0;
            for (int i = 0; i < n; i++)
                if (isVisited[i]) sum += h[i];
                
            if (isPrimeNumber(sum)) set.add(sum);
            return;
        } 

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                result[depth] = h[i];

                if (latest <= result[depth]) {
                    dfs(depth + 1, result[depth]);
                }
                isVisited[i] = false;
            }
        }
        return;
    }
}