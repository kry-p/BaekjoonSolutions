import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, 1, 0, -1 };
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<Point> snake = new ArrayDeque<>();
        int size = Integer.parseInt(reader.readLine());
        int currentDirection = 0;
        int appleCount = Integer.parseInt(reader.readLine());
        map = new int[size][size];

        for (int i = 0; i < appleCount; i++) {
            int[] position = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[position[1] - 1][position[0] - 1] = 1;
        }
        int directionSize = Integer.parseInt(reader.readLine());
        Direction[] directionArray = new Direction[directionSize];

        for (int i = 0; i < directionSize; i++) {
            String[] input = reader.readLine().split(" ");
            directionArray[i] = new Direction(Integer.parseInt(input[0]), input[1].equals("L") ? -1 : 1);
        }

        snake.add(new Point(0, 0));

        int count = 0;
        int directionIndex = 0;

        snakeGame:
        while (true) {
            Point snakeHead = snake.peekFirst();
            if (directionIndex == directionSize || directionArray[directionIndex].time != count) {
                
            } else {
                currentDirection += directionArray[directionIndex].direction;
                if (currentDirection == -1) {
                    currentDirection = 3;
                } else if (currentDirection == 4) {
                    currentDirection = 0;
                }
                directionIndex += 1;
            }

            int nextX = snakeHead.getX() + DX[currentDirection];
            int nextY = snakeHead.getY() + DY[currentDirection];

            // 벽에 충돌하여 종료
            if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size) {
                count += 1;
                break;
            }
            // 다음 위치에 사과가 있으면 머리 앞에 붙임 (충돌 판정 없음)
            // 사과가 없으면 꼬리를 머리로 옮긴 다음 충돌 판정 계산
            if (map[nextX][nextY] == 1) {
                snake.addFirst(new Point(nextX, nextY));
                map[nextX][nextY] = 0;
            } else {
                snake.addFirst(new Point(nextX, nextY));
                Point currentHead = snake.pollFirst();
                
                if (snake.size() > 0) {
                    for (int i = 0; i < snake.size(); i++) {
                        Point snakeBody = snake.pollFirst();
                        
                        if (snakeBody.getX() == currentHead.getX() && snakeBody.getY() == currentHead.getY()) {
                            count += 1;
                            break snakeGame;
                        }
                        snake.addLast(snakeBody);
                    }
                    snake.addFirst(currentHead);
                    snake.pollLast();
                } else {
                    snake.addFirst(currentHead);
                }
                
            }
            count += 1;
        }

        System.out.println(count);
    }
}

class Point {
    private int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Direction {
    int time, direction;
    // direction이 1이면 시계 방향, -1이면 반대 방향
    public Direction(int time, int direction) {
        this.time = time;
        this.direction = direction;
    }
}