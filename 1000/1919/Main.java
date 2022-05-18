import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line0 = reader.readLine();
        String line1 = reader.readLine();

        int[] count0 = new int[26];
        int[] count1 = new int[26];

        int differences = 0;

        for (int i = 0; i < line0.length(); i++) {
            count0[line0.charAt(i) - 97] += 1;
        }

        for (int i = 0; i < line1.length(); i++) {
            count1[line1.charAt(i) - 97] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (count0[i] != count1[i]) {
                differences += Math.abs(count0[i] - count1[i]);
            }
        }

        System.out.println(differences);
    }
}
