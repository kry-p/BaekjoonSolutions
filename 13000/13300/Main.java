import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        String[] line = reader.readLine().split(" ");
        int[][] student = new int[6][2];
        int persons = Integer.parseInt(line[0]);
        int maxPerRoom = Integer.parseInt(line[1]);
        int result = 0;

        for (int i = 0; i < persons; i++) {
            line = reader.readLine().split(" ");
            student[Integer.parseInt(line[1]) - 1][Integer.parseInt(line[0])] += 1;
        }

        for (int i = 0; i < student.length; i++) {
            for (int j = 0; j < student[0].length; j++) {
                if (student[i][j] == 0)
                    continue;

                if (student[i][j] % maxPerRoom == 0)
                    result += student[i][j] / maxPerRoom;
                else
                    result += student[i][j] / maxPerRoom + 1;
            }
        }
        System.out.println(result);
    }
}