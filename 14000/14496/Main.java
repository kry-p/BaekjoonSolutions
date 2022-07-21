import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<ArrayList<Node>> graph;
    private static int[] lowestCosts;
	public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        graph = new ArrayList<>();
        lowestCosts = new int[n + 1];

        for (int i = 0; i <= n; i++) 
            graph.add(new ArrayList<>());
        
        for (int i = 0; i < m; i++) {
            int[] vector = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(vector[0]).add(new Node(vector[1], 1)); 
            graph.get(vector[1]).add(new Node(vector[0], 1));
        }

        for (int i = 0; i < lowestCosts.length; i++) 
            lowestCosts[i] = Integer.MAX_VALUE;

        dijkstra(a);
        System.out.println(lowestCosts[b] == Integer.MAX_VALUE ? -1 : lowestCosts[b]);
    }

    private static void dijkstra(int startPos) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startPos, 0));
        lowestCosts[startPos] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int currentCost = current.getCost();
            int currentNode = current.getVertex();

            if (lowestCosts[currentNode] < currentCost) {
                continue;
            }

            for (int i = 0; i < graph.get(currentNode).size(); i++) {
                int cost = lowestCosts[currentNode] + graph.get(currentNode).get(i).getCost();
                if (cost < lowestCosts[graph.get(currentNode).get(i).getVertex()]) {
                    lowestCosts[graph.get(currentNode).get(i).getVertex()] = cost;
                    queue.add(new Node(graph.get(currentNode).get(i).getVertex(), cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    private int n, cost;

    public Node(int n, int cost) {
        this.n = n;
        this.cost = cost;
    }

    public int getVertex() {
        return n;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}