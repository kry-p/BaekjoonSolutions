import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] str = reader.readLine().toCharArray();
        char[] find = reader.readLine().toCharArray();
        int[] table = createTable(find);

        System.out.println(kmp(str, find, table) ? 1 : 0);
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

    public static boolean kmp(char[] str, char[] find, int[] table) {
        boolean result = false;
        int j = 0;

        for (int i = 0; i < str.length; i++) {
            while (j > 0 && str[i] != find[j])
                j = table[j - 1];
            
            if (str[i] == find[j]) {
                if (j == find.length - 1) {
                    // 완전 일치 시
                    result = true;
                    j = table[j];
                } else {
                    j += 1;
                }
            }
        }
        return result;
    }
}
