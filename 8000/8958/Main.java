import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            StringBuilder resultBuilder = new StringBuilder();

            String[] ox;
            int attempt = Integer.parseInt(stringTokenizer.nextToken());
            ox = new String[attempt];

            for (int i = 0; i < ox.length; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                ox[i] = stringTokenizer.nextToken();
            }

            for (int i = 0; i < attempt; i++) {
                int temp = 0;
                String[] strArray = ox[i].split("");
                int baseScore = 1;

                for (int j = 0; j < strArray.length; j++) {
                    if (strArray[j].equals("O")) {
                        temp += baseScore;
                        baseScore += 1;
                    } else {
                        baseScore = 1;
                    }
                }
                resultBuilder.append(Integer.toString(temp) + '\n');
            }
            System.out.println(resultBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
