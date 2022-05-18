import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    private static boolean[] isVisited;
    private static int[] result;
    private static boolean[][] ban;
    private static int n, m, count;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        isVisited = new boolean[n];
        ban = new boolean[n][n];
        result = new int[3];

        count = 0;

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;

            ban[a][b] = true;
            ban[b][a] = true;
        }

        dfs(0, 0);

        System.out.print(count);
    }

    private static void dfs(int index, int pos) {
        if (pos == 3) {
            if (check())
                count += 1;
            return;
        }

        for (int i = index; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                result[pos] = i;
                dfs(i, pos + 1);
                isVisited[i] = false;
            }
        }
    }

    private static boolean check() {
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (ban[result[i]][result[j]])
                    return false;
            }
        }
        return true;
    }
}