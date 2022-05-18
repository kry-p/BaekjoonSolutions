import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static ArrayList<ArrayList<Integer>> relationsList;
    private static boolean[] isVisited;
    private static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        // 친구 관계를 저장할 연결 리스트
        relationsList = new ArrayList<>();

        int person = Integer.parseInt(tokenizer.nextToken());
        int relationCount = Integer.parseInt(tokenizer.nextToken());

        // 노드 방문 여부
        isVisited = new boolean[person];

        for (int i = 0; i < person; i++)
            relationsList.add(new ArrayList<>());

        for (int i = 0; i < relationCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            // 친구 관계는 상호이므로 양쪽으로 추가
            relationsList.get(a).add(b);
            relationsList.get(b).add(a);
        }

        for (int i = 0; i < person; i++) {
            Arrays.fill(isVisited, false);
            dfs(i, 1);
            if (result)
                break;
        }

        System.out.println(result ? 1 : 0);
    }

    // 친구 관계 탐색 (현위치, 현재 누적 친구 연결)
    private static void dfs(int currentPos, int count) {
        if (count == 5) {
            result = true;
            return;
        }

        isVisited[currentPos] = true;
        for (int i : relationsList.get(currentPos))
            if (!isVisited[i])
                dfs(i, count + 1);

        isVisited[currentPos] = false;
    }
}
