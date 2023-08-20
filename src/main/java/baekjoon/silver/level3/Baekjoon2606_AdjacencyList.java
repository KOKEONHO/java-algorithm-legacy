package baekjoon.silver.level3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon2606_AdjacencyList {

    private static List<Integer>[] adjacencyListArray;
    private static boolean[] visited;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int computers, pairs;
        int from, to;

        computers = scanner.nextInt();
        pairs = scanner.nextInt();

        adjacencyListArray = new List[computers];
        visited = new boolean[computers];

        for (int i = 0; i < adjacencyListArray.length; i++) {
            adjacencyListArray[i] = new LinkedList<>();
        }

        for (int i = 0; i < pairs; i++) {
            from = scanner.nextInt() - 1;
            to = scanner.nextInt() - 1;
            adjacencyListArray[from].add(to);
            adjacencyListArray[to].add(from);
        }

        int rootNode = 0;
        int answer = bfs(rootNode);

        System.out.println(answer);
    }

    private static int bfs(int rootNode) {

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootNode);
        visited[rootNode] = true;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            count++;
            Iterator<Integer> iterator = adjacencyListArray[nowNode].listIterator();
            while (iterator.hasNext()) {
                int nextNode = iterator.next();
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }

        return count-1;
    }

}
