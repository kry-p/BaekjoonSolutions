import java.util.Scanner;

public class Main {
    private static int[] temp; // 현재 확인 중인 퀸의 위치
    private static int size, count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        count = 0;

        scanner.close();
        temp = new int[size];

        track(0);
        System.out.println(count);

    }

    private static void track(int depth) {
        if (depth == size) {
            count += 1;
            return;
        }
        // 각 퀸의 위치를 지정 (DFS)
        for (int i = 0; i < size; i++) {
            temp[depth] = i;

            // 해당 퀸의 위치가 유망하면 다음 위치도 지정
            if (isInvulnerable(depth))
                track(depth + 1);
        }
    }

    // 현재 퀸의 위치가 유망한지 판정
    // 1차원 배열로 지정하였으므로 하나의 축은 판정할 필요가 없음 (가로축 기준이면 세로, 대각선만 판정)
    private static boolean isInvulnerable(int current) {
        for (int i = 0; i < current; i++) {
            // 각각 세로축(or 가로축), 대각선을 판정
            // 대각선 : 현재 퀸의 위치와 기존 퀸의 위치를 비교할 때 가로축의 차이와 세로축의 차이가 같으면 공격 범위 안에 있음
            if (temp[i] == temp[current] || (current - i) == Math.abs(temp[current] - temp[i]))
                return false;
        }
        return true;
    }
}
