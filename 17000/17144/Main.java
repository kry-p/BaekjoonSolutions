import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static int sizeX, sizeY, time;
    private static int purifierPosition;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sizeX = input[0];
        sizeY = input[1];
        time = input[2];

        // 미세먼지 정보 입력
        map = new int[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) 
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        // 공기청정기 위치 시작점
        for (int i = 0; i < sizeX; i++) 
            if (map[i][0] == -1) {
                purifierPosition = i;
                break;
            }

        int currentTime = 0;
        while (currentTime < time) {
            ArrayList<Dust> list = new ArrayList<>();
            // 확산을 위해 먼지의 좌표를 구함
            for (int i = 0; i < sizeX; i++) 
                for (int j = 0; j < sizeY; j++) 
                    if (map[i][j] > 0)
                        list.add(new Dust(map[i][j], purifierPosition, sizeX, sizeY, i, j));
            
            // 확산될 위치를 찾고 0으로 채움
            for (int i = 0; i < sizeX; i++)
                Arrays.fill(map[i], 0);

            for (Dust d : list) {
                int x = d.getX();
                int y = d.getY();
                int[] diffusion = d.getDiffusion();

                map[x][y] += d.getAmount();
                for (int i = 0; i < 4; i++) {
                    if (diffusion[i] != -1) {
                        map[x + DX[i]][y + DY[i]] += diffusion[i];
                    }
                }
            }
            
            circulateTop();
            circulateBottom();

            currentTime += 1;
        }

        int sum = 0;

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    public static void circulateTop() {
        int currentX = purifierPosition, currentY = 0; // 시작점
        
        while (currentX >= 1) {
            map[currentX][currentY] = map[currentX - 1][currentY];
            currentX -= 1;
        }
        map[purifierPosition][0] = 0;

        while (currentY < sizeY - 1) {
            map[currentX][currentY] = map[currentX][currentY + 1];
            currentY += 1;
        }
    
        while (currentX < purifierPosition) {
            map[currentX][currentY] = map[currentX + 1][currentY];
            currentX += 1;
        }

        while (currentY >= 1) {
            map[currentX][currentY] = map[currentX][currentY - 1];
            currentY -= 1;
        }
    }

    public static void circulateBottom() {
        int currentX = purifierPosition + 1, currentY = 0; // 시작점
        
        while (currentX < sizeX - 1) {
            map[currentX][currentY] = map[currentX + 1][currentY];
            currentX += 1;
        }
        map[purifierPosition + 1][0] = 0;

        while (currentY < sizeY - 1) {
            map[currentX][currentY] = map[currentX][currentY + 1];
            currentY += 1;
        }
    
        while (currentX > purifierPosition + 1) {
            map[currentX][currentY] = map[currentX - 1][currentY];
            currentX -= 1;
        }

        while (currentY >= 1) {
            map[currentX][currentY] = map[currentX][currentY - 1];
            currentY -= 1;
        }
    }
}

class Space {
    protected int x, y;
    protected int amount;

    public Space(int amount, int x, int y) {
        this.amount = amount;
        this.x = x;
        this.y = y;
    }

    public int getX() { 
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAmount() {
        return amount;
    }
}

class Dust extends Space {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private int[] diffusion = { 0, 0, 0, 0 }; // 상, 하, 좌, 우 확산
    private int sizeX, sizeY;
    private int purifierPosition;

    public Dust(int amount, int purifierPosition, int sizeX, int sizeY, int x, int y) {
        super(amount, x, y);

        this.purifierPosition = purifierPosition;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        setDiffusion();
    }

    private void setDiffusion() {
        int diffusedAmount = (int) Math.floor(amount / 5);

        for (int i = 0; i < 4; i++) {
            int nextX = x + DX[i];
            int nextY = y + DY[i];

            // 공간 범위를 벗어남
            if (nextX < 0 || nextY < 0 || nextX >= sizeX || nextY >= sizeY) {
                diffusion[i] = -1;
                continue;
            }
            // 해당 위치에 공기청정기가 있음
            if (( nextX == purifierPosition || nextX == (purifierPosition + 1)) && nextY == 0) {
                diffusion[i] = -1;
                continue;
            }
            diffusion[i] = diffusedAmount; // 해당 위치에 이만큼 확산
            amount -= diffusedAmount; // 확산된 만큼 현 위치의 양은 줄어듦
        }
    }
    
    public int[] getDiffusion() {
        return diffusion;
    }
}