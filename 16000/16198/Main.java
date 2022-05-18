import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int length = Integer.parseInt(reader.readLine());
        int[] energy = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : energy) {
            list.add(i);
        }

        dfs(list, 0);
        System.out.println(max);
    }

    public static void dfs(ArrayList<Integer> list, int sum) {
        if (list.size() <= 2) {
            if (max < sum) 
                max = sum;
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int temp = list.get(i);
            int current = list.get(i - 1) * list.get(i + 1);
            list.remove(i);

            dfs(list, sum + current);
            list.add(i, temp);
        }
    }
}