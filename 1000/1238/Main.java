import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<ArrayList<Node>> graph;
    private static int[][] lowestCosts;
    private static int[] max;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int vertex = Integer.parseInt(input[1]);
        int edge = Integer.parseInt(input[0]);
        int destination = Integer.parseInt(input[2]);

        graph = new ArrayList<>();
        lowestCosts = new int[edge + 1][edge + 1];
        max = new int[vertex + 1];
        int maximumCost = Integer.MIN_VALUE;

        for (int i = 0; i <= vertex; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < vertex; i++) {
            int[] vector = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(vector[0]).add(new Node(vector[1], vector[2]));
        }

        for (int i = 0; i < lowestCosts.length; i++) 
            for (int j = 0; j < lowestCosts.length; j++) 
                lowestCosts[i][j] = Integer.MAX_VALUE;
            
        for (int i = 1; i <= edge; i++) 
            dijkstra(i);

        for (int i = 1; i <= edge; i++) {
            max[i] += lowestCosts[i][destination] + lowestCosts[destination][i];
            maximumCost = Math.max(maximumCost, max[i]);
        }
        System.out.println(maximumCost);
    }

    private static void dijkstra(int startPos) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startPos, 0));
        lowestCosts[startPos][startPos] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int currentCost = current.cost;
            int currentNode = current.vertex;

            if (lowestCosts[startPos][currentNode] < currentCost)
                continue;

            for (int i = 0; i < graph.get(currentNode).size(); i++) {
                int cost = lowestCosts[startPos][currentNode] + graph.get(currentNode).get(i).cost;
                if (cost < lowestCosts[startPos][graph.get(currentNode).get(i).vertex]) {
                    lowestCosts[startPos][graph.get(currentNode).get(i).vertex] = cost;
                    queue.add(new Node(graph.get(currentNode).get(i).vertex, cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    public int vertex, cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
