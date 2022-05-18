// 2번째 제출 변경사항 : dead code 제거 및 주석 추가
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main { 
    private static ArrayList<Point> houseList, chickenList; // 집 목록, 치킨집 목록
    private static int[][] map; // 지도
    private static int[] closingChickenIndex, minimumChickenDistance; // 문을 닫을 치킨집의 인덱스
    private static boolean[] isChecked; // 닫을 치킨집 목록 작성 시 노드 방문 여부
    private static int size, removal, min; // 지도 크기, 폐업할 치킨집 수, 구하려는 최솟값
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        chickenList = new ArrayList<>();
        houseList = new ArrayList<>();
        String[] input = reader.readLine().split(" ");
        size = Integer.parseInt(input[0]);
        int survivedChicken = Integer.parseInt(input[1]); // 남길 치킨집 개수
        map = new int[size][size];

        // 지도 초기화 및 집, 치킨집의 목록을 추가
        for (int i = 0; i < size; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < size; j++) {
                if (map[i][j] == 1)
                    houseList.add(new Point(i, j));
                if (map[i][j] == 2)
                    chickenList.add(new Point(i, j));
            }
        }

        removal = chickenList.size() - survivedChicken;
        isChecked = new boolean[chickenList.size()];
        closingChickenIndex = new int[removal];
        minimumChickenDistance = new int[houseList.size()];
        min = Integer.MAX_VALUE;
        
        dfs(0, 0);

        System.out.println(min);

    }

    // 치킨 거리를 계산
    private static void calculateChickenDistance() {
        Arrays.fill(minimumChickenDistance, Integer.MAX_VALUE);
        for (int i = 0; i < houseList.size(); i++) {
            Point currentHouse = houseList.get(i);
            
            for (int j = 0; j < chickenList.size(); j++) {
                if (Arrays.binarySearch(closingChickenIndex, j) < 0) {
                    Point currentChicken = chickenList.get(j);
                    minimumChickenDistance[i] = Math.min(minimumChickenDistance[i], Math.abs(currentHouse.x - currentChicken.x) + Math.abs(currentHouse.y - currentChicken.y));
                }
            }
        }
        min = Math.min(min, Arrays.stream(minimumChickenDistance).sum());
    }

    // DFS로 닫을 치킨집 인덱스가 들어 있는 배열을 작성
    private static void dfs(int depth, int latest) {
        if (depth == removal) {
            // 다 찾으면 치킨 거리를 계산
            calculateChickenDistance();
            return;
        }

        for (int i = 0; i < chickenList.size(); i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
             closingChickenIndex[depth] = i;
                if (latest <= closingChickenIndex[depth]) {
                    dfs(depth + 1, closingChickenIndex[depth]);
                }
                isChecked[i] = false;
            }
        }
    }
}

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}