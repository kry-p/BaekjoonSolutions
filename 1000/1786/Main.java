import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static StringBuilder builder;
    private static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] str = reader.readLine().toCharArray();
        char[] find = reader.readLine().toCharArray();
        int[] table = createTable(find);
        builder = new StringBuilder();
        count = 0;

        kmp(str, find, table);
        System.out.print(count + "\n" + builder.toString());
    }

    public static int[] createTable(char[] find) {
        int[] table = new int[find.length];
        int j = 0;
       
        for (int i = 1; i < find.length; i++) {
            while (j > 0 && find[i] != find[j])
                j = table[j - 1];

            if (find[i] == find[j]) {
                table[i] = ++j;
            }
        }

        return table;
    }

    public static void kmp(char[] str, char[] find, int[] table) {
        int j = 0;

        for (int i = 0; i < str.length; i++) {
            while (j > 0 && str[i] != find[j])
                j = table[j - 1];
            
            if (str[i] == find[j]) {
                if (j == find.length - 1) {
                    j = table[j];

                    builder.append((i - find.length + 2) + " ");
                    count += 1;
                } else {
                    j += 1;
                }
            }
        }
    }
}
