import java.util.*;
import java.io.*;

public class Main {
    private static int l, c;
    private static String[] array;
    private static boolean[] isVisited;
    private static StringBuilder builder;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();
        String[] input = reader.readLine().split(" ");
        l = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        array = reader.readLine().split(" ");
        isVisited = new boolean[c];
       
        Arrays.sort(array);
        dfs(0, 0);
        System.out.println(builder.toString());
    }

    private static void dfs(int start, int depth) {
        if (depth == l) {
            StringBuilder test = new StringBuilder();
            int vowels = 0;
            int consonants = 0;
            for (int i = 0; i < c; i++) {
                if (isVisited[i]) {
                    String current = array[i];
                    test.append(current);

                    if (current.equals("a") || current.equals("e") || 
                        current.equals("i") || current.equals("o") || 
                        current.equals("u"))
                        vowels += 1;
                    else
                        consonants += 1;
                }
            }
            if (vowels > 0 && consonants > 1) builder.append(test.toString() + "\n");
            return;
        }

        for (int i = start; i < c; i++) {
            isVisited[i] = true;
            dfs(i + 1, depth + 1);
            isVisited[i] = false;
        }
    }
}