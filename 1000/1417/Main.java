import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int candidateCount = Integer.parseInt(reader.readLine());
        int[] candidates = new int[candidateCount - 1]; // 다른 후보자
        int count = 0;
        int dasom = Integer.parseInt(reader.readLine());

        for (int i = 0; i < candidateCount - 1; i++) 
            candidates[i] = Integer.parseInt(reader.readLine());

        while (true) {
            int currentMax = Integer.MIN_VALUE;
            int index = 0;

            for (int i = 0; i < candidateCount - 1; i++) {
                if (currentMax < candidates[i]) {
                    currentMax = candidates[i];
                    index = i;
                }
            }

            if (dasom > currentMax) {
                System.out.println(count);
                break;
            }

            dasom += 1;
            candidates[index] -= 1;
            count += 1;
        }
    }
}