import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    private static ArrayList<ArrayList<Node>> graph;
    private static int[][] lowestCosts;
	public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int vertex = Integer.parseInt(reader.readLine());
        int edge = Integer.parseInt(reader.readLine());
        graph = new ArrayList<>();
        lowestCosts = new int[vertex + 1][vertex + 1];

        for (int i = 0; i <= vertex; i++) 
            graph.add(new ArrayList<>());
        
        for (int i = 0; i < edge; i++) {
            int[] vector = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(vector[0]).add(new Node(vector[1], vector[2]));
        }

        for (int i = 0; i < lowestCosts.length; i++) 
            for (int j = 0; j < lowestCosts[0].length; j++) 
                lowestCosts[i][j] = Integer.MAX_VALUE;

        for (int i = 1; i <= vertex; i++)
            dijkstra(i);
        
        for (int i = 1; i <= vertex; i++) {
            for (int j = 1; j <= vertex; j++) 
                if (lowestCosts[i][j] == Integer.MAX_VALUE)
                    builder.append("0 ");
                else {
                    builder.append(lowestCosts[i][j] + " ");
                }
            builder.append("\n");
        }
        System.out.print(builder.toString());
    }

    private static void dijkstra(int startPos) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startPos, 0));
        lowestCosts[startPos][startPos] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int currentCost = current.getCost();
            int currentNode = current.getVertex();

            if (lowestCosts[startPos][currentNode] < currentCost) {
                continue;
            }

            for (int i = 0; i < graph.get(currentNode).size(); i++) {
                int cost = lowestCosts[startPos][currentNode] + graph.get(currentNode).get(i).getCost();
                if (cost < lowestCosts[startPos][graph.get(currentNode).get(i).getVertex()]) {
                    lowestCosts[startPos][graph.get(currentNode).get(i).getVertex()] = cost;
                    queue.add(new Node(graph.get(currentNode).get(i).getVertex(), cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    private int vertex, cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int getVertex() {
        return vertex;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}