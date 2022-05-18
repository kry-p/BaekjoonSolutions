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
        String[] input = reader.readLine().split(" ");
        int vertex = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);
        graph = new ArrayList<>();
        lowestCosts = new int[vertex + 1][vertex + 1];

        for (int i = 0; i <= vertex; i++) 
            graph.add(new ArrayList<>());
        
        for (int i = 0; i < edge; i++) {
            int[] vector = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(vector[0]).add(new Node(vector[1], vector[2]));
            graph.get(vector[1]).add(new Node(vector[0], vector[2]));
        }
        input = reader.readLine().split(" ");
        int checkpoint1 = Integer.parseInt(input[0]);
        int checkpoint2 = Integer.parseInt(input[1]);

        for (int i = 0; i < lowestCosts.length; i++) 
            for (int j = 0; j < lowestCosts[0].length; j++) 
                lowestCosts[i][j] = Integer.MAX_VALUE;

        // 출발지와 경유지에 대해 최단 거리를 계산
        dijkstra(1);
        dijkstra(checkpoint1);
        dijkstra(checkpoint2);

        int[] result = { Integer.MAX_VALUE, Integer.MAX_VALUE }; 
        // 1. 1 -> checkpoint1 -> checkpoint2 -> n
        if (lowestCosts[1][checkpoint1] == Integer.MAX_VALUE || 
            lowestCosts[checkpoint1][checkpoint2] == Integer.MAX_VALUE ||
            lowestCosts[checkpoint2][vertex] == Integer.MAX_VALUE) {
            result[0] = Integer.MAX_VALUE;
        } else {
            result[0] = lowestCosts[1][checkpoint1] + 
                        lowestCosts[checkpoint1][checkpoint2] + 
                        lowestCosts[checkpoint2][vertex];
        }
        // 2. 1 -> checkpoint2 -> checkpoint1 -> n
        if (lowestCosts[1][checkpoint2] == Integer.MAX_VALUE || 
            lowestCosts[checkpoint2][checkpoint1] == Integer.MAX_VALUE ||
            lowestCosts[checkpoint1][vertex] == Integer.MAX_VALUE) {
            result[1] = Integer.MAX_VALUE;
        } else {
            result[1] = lowestCosts[1][checkpoint2] + 
                        lowestCosts[checkpoint2][checkpoint1] + 
                        lowestCosts[checkpoint1][vertex];
        }

        int min = Arrays.stream(result).min().getAsInt();
        
        System.out.println(min == Integer.MAX_VALUE ? "-1" : min);
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