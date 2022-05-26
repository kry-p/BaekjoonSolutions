import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int attempt = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        

        for (int i = 0; i < attempt; i++) {
            StringBuilder subBuilder = new StringBuilder();
            leftQueue.clear();
            rightQueue.clear();

            int size = Integer.parseInt(reader.readLine());
            int[] input = new int[size];

            for (int j = 0; j <= size / 10; j++) {
                int[] sub = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int k = 0; k < sub.length; k++)
                    input[j * 10 + k] = sub[k];
            }

            int count = 0;

            for (int j = 0; j < size; j++) {
                int current = input[j];
                if (leftQueue.size() == rightQueue.size()) {
                    rightQueue.add(current);
                } else {
                    leftQueue.add(current);
                }

                if (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
                    if (leftQueue.peek() < rightQueue.peek()) {
                        int temp = leftQueue.poll();
                        leftQueue.add(rightQueue.poll());
                        rightQueue.add(temp);
                    }
                }

                if (j % 2 == 0) {
                    count += 1;
                    subBuilder.append(rightQueue.peek() + " ");
                    if (count % 10 == 0)
                        subBuilder.append("\n");
                }
            }
            builder.append(count + "\n" + subBuilder.toString() + "\n");
        }
        
        System.out.print(builder.toString());
    }
}