// 변경사항: 다음에 알아볼 수 있게 주석 추가
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int testCase = Integer.parseInt(reader.readLine());
        
        // 테스트 케이스만큼
        for (int i = 0; i < testCase; i++) {
            int result = 0;
            int[] pos = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int startX = pos[0];
            int startY = pos[1];
            int finishX = pos[2];
            int finishY = pos[3];
            int system = Integer.parseInt(reader.readLine());
            Circle[] systems = new Circle[system]; 
            boolean[] startIncluded = new boolean[system];
            boolean[] finishIncluded = new boolean[system];

            // 행성계 정보를 입력받음
            for (int j = 0; j < system; j++) {
                int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                systems[j] = new Circle(input[0], input[1], input[2]);
            }

            for (int j = 0; j < system; j++) {
                // 원의 중심과 시작점, 끝점과의 거리를 구함
                // 거리가 반지름보다 작으면 해당 점은 행성계 안에 있음 
                double fromStartDistance = Math.pow((Math.pow(systems[j].getX() - startX, 2) + Math.pow(systems[j].getY() - startY, 2)), 0.5);
                double fromFinishDistance = Math.pow((Math.pow(systems[j].getX() - finishX, 2) + Math.pow(systems[j].getY() - finishY, 2)), 0.5);
                if (fromStartDistance <= (double) systems[j].getRadius()) 
                    startIncluded[j] = true;
                if (fromFinishDistance <= (double) systems[j].getRadius()) 
                    finishIncluded[j] = true;
                // 둘 다 겹치는 경우 해당 행성계를 벗어나지 않으므로 계산에서 제외하여야 함
                // 하나만 겹칠 때에만 다른 행성계로 이동하는 것으로 간주, 추가
                if (startIncluded[j] ^ finishIncluded[j])
                    result += 1;
            }
            builder.append(result + "\n");
        }
        System.out.print(builder.toString());
    }
}

class Circle {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getRadius() { return radius; }
}
