import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int caseCount, sum, overMean;
    private static int[] studentCount, score;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            caseCount = Integer.parseInt(stringTokenizer.nextToken());
            studentCount = new int[caseCount];

            for (int i = 0; i < caseCount; i++) {
                sum = 0;
                overMean = 0;
                double mean;

                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                studentCount[i] = Integer.parseInt(stringTokenizer.nextToken());
                score = new int[studentCount[i]];

                for (int j = 0; j < score.length; j++) {
                    score[j] = Integer.parseInt(stringTokenizer.nextToken());
                    sum += score[j];
                }

                mean = sum / studentCount[i];

                for (int j = 0; j < score.length; j++) {
                    if (score[j] > mean)
                        overMean += 1;
                }

                double result = (double) overMean / studentCount[i];

                System.out.println(String.format("%.3f", result * 100) + "%");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
