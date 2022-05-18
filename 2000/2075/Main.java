import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;


public final class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2)
                    return 1;
                else 
                    return -1;
            }
        });

        int size = Integer.parseInt(reader.readLine());
        for (int i = 0; i < size; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j : input) 
                queue.add(j);
        }
        
        for (int i = 0; i < size - 1; i++)
            queue.poll();
        
        System.out.println(queue.poll());
    }
}