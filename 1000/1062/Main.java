import java.io.*;

public class Main {
    private static int n, k, max;
    private static boolean[] isVisited;
    private static String[] strings;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = reader.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);
        max = 0;

        // a, c, i, k, n이 포함되어야 하므로 없으면 0
        if (k < 5) {
            System.out.print(0);
            return;
        } else if (k == 26) {
            System.out.print(n);
            return;
        } else {
            strings = new String[n];
            for (int i = 0; i < n; i++) {
                String temp = reader.readLine();
                strings[i] = temp.substring(4, temp.length() - 4);
            }
            k -= 5;
            isVisited = new boolean[26];
            isVisited['a' - 97] = true;
            isVisited['c' - 97] = true;
            isVisited['i' - 97] = true;
            isVisited['n' - 97] = true;
            isVisited['t' - 97] = true;

            dfs(0, 0);
            System.out.print(max);
        }
    }

    private static void dfs(int start, int depth) {
        if (depth == k) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean isReadable = true;
                for (int j = 0; j < strings[i].length(); j++) {
                    if (!isVisited[strings[i].charAt(j) - 97]) {
                        isReadable = false;
                        break;
                    }
                }
                if (isReadable) count += 1;
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(i, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
