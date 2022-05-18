import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int max = 0;
    private static boolean[] isVisited;
    static List<Integer>[] list;
    private static int[] result;
    private static List<Integer>[] connection;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        // nm[0] = n, nm[1] = m
        int[] nm = new int[2];
        nm[0] = Integer.parseInt(tokenizer.nextToken());
        nm[1] = Integer.parseInt(tokenizer.nextToken());

        int[] relation = new int[2];
        isVisited = new boolean[nm[0] + 1];
        connection = new ArrayList[nm[0] + 1];
        result = new int[nm[0] + 1];

        // 링크 상태 정보를 저장할 ArrayList 배열 초기화
        for (int i = 1; i <= nm[0]; i++) {
            connection[i] = new ArrayList<Integer>();
        }

        // 각 입력에 대해 링크 상태를 ArrayList에 저장
        for (int i = 0; i < nm[1]; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            relation[0] = Integer.parseInt(tokenizer.nextToken());
            relation[1] = Integer.parseInt(tokenizer.nextToken());
            connection[relation[0]].add(relation[1]);
        }

        for (int i = 1; i <= nm[0]; i++) {
            isVisited = new boolean[nm[0] + 1];
            isVisited[i] = true;
            search(i);
        }

        max = Arrays.stream(result).max().getAsInt();

        for (int i = 1; i <= nm[0]; i++) {
            if (max == result[i]) {
                System.out.print(i);
                if (i != nm[0]) {
                    System.out.print(" ");
                }
            }
        }
    }

    private static void search(int node) {
        for (int i : connection[node]) {
            if (!isVisited[i]) {
                result[i] += 1;
                isVisited[i] = true;
                search(i);
            }
        }
    }
}
