import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cities = Integer.parseInt(reader.readLine());
        int[] distance = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] cost = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] recharge = new long[cities - 1];
        int currentPos = 0;
        int nextPos = 1;

        // 가격 계산 위치가 범위를 넘어서면 종료
        while (currentPos < cities && nextPos < cities) {
            // 현 위치가 다음 위치보다 주유비가 비쌀 경우
            if (cost[currentPos] > cost[nextPos]) {
                // currentPos부터 nextPos까지의 거리를 currentPos에서 주유
                for (int i = currentPos; i < nextPos; i++)
                    recharge[currentPos] += distance[i] * cost[currentPos];
                currentPos = nextPos;
                nextPos = currentPos + 1;
            } else {
                // 처음 위치의 주유비가 가장 쌀 때의 예외처리
                if (nextPos == cities - 1) {
                    for (int i = currentPos; i < nextPos; i++)
                        recharge[currentPos] += distance[i] * cost[currentPos];
                    currentPos = nextPos;
                    nextPos = currentPos + 1;
                } else
                    nextPos += 1; // 일반적으로는 다음 주유소의 위치를 넘김
            }
        }
        long sum = 0;
        for (int i = 0; i < recharge.length; i++) {
            sum += recharge[i];
        }
        System.out.println(sum);
    }
}
