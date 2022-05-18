import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static int[] size, attempt;
    public static ArrayList<Robot> robots;
    public static BufferedReader reader;
    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        robots = new ArrayList<>();
        size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        attempt = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < attempt[0]; i++) {
            String[] input = reader.readLine().split(" ");
            robots.add(new Robot(Integer.parseInt(input[0]), Integer.parseInt(input[1]), input[2]));
        }

        boolean result = check();
        if(result) 
            System.out.print("OK");
    }

    public static boolean check() throws IOException {
        for (int i = 0; i < attempt[1]; i++) {
            String[] input = reader.readLine().split(" ");
            Robot currentRobot = robots.get(Integer.parseInt(input[0]) - 1);

            for (int j = 0; j < Integer.parseInt(input[2]); j++) {
                if (input[1].equals("F")) {
                    currentRobot.move();

                    // 벽과 충돌 여부 체크
                    int[] currentPos = currentRobot.getCurrentPos();
                    // 벽과 충돌
                    if (currentPos[0] < 1 || currentPos[0] > size[0] || currentPos[1] < 1 || currentPos[1] > size[1]) {
                        System.out.print("Robot " + input[0] + " crashes into the wall");
                        return false;
                    }

                    // 로봇과 충돌 여부 체크
                    for (int k = 0; k < robots.size(); k++) {
                        // 자기 자신은 체크하지 않음
                        if (k == (Integer.parseInt(input[0]) - 1))
                            continue;
                        int[] anotherPos = robots.get(k).getCurrentPos();

                        if (currentPos[0] == anotherPos[0] && currentPos[1] == anotherPos[1]) {
                            System.out.print("Robot " + input[0] + " crashes into robot " + (k + 1));
                            return false;
                        }
                    }
                } else {
                    currentRobot.rotate(input[1]);
                }
            }
        }
        return true;
    }
}

class Robot {
    private int currentX, currentY;
    private int directionX, directionY;
    private String direction;

    public Robot(int initialX, int initialY, String direction) {
        currentX = initialX;
        currentY = initialY;

        this.direction = direction;
        setDirection(direction);
    }

    public void rotate(String lr) {
        switch(lr) {
            case "L":
                if (direction.equals("E")) {
                    direction = "N";
                } else if (direction.equals("W")) {
                    direction = "S";
                } else if (direction.equals("S")) {
                    direction = "E";
                } else {
                    direction = "W";
                }
                break;
            case "R":
                if (direction.equals("E")) {
                    direction = "S";
                } else if (direction.equals("W")) {
                    direction = "N";
                } else if (direction.equals("S")) {
                    direction = "W";
                } else {
                    direction = "E";
                }
                break;
        }
        setDirection(direction);
    }

    private void setDirection(String direction) {
        switch(direction) {
            case "E":
                directionX = 1;
                directionY = 0;
                break;
            case "W":
                directionX = -1;
                directionY = 0;
                break;
            case "S":
                directionX = 0;
                directionY = -1;
                break;
            case "N":
                directionX = 0;
                directionY = 1;
                break;
        }
    }

    public void move() {
        currentX += directionX;
        currentY += directionY;
    }

    public int[] getCurrentPos() {
        int[] result = {currentX, currentY};
        return result;
    }
}
