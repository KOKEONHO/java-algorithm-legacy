package baekjoon.silver.level2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon11724_Bfs_AdjacencyList {

    private static List<Integer>[] adjacencyListArray;
    private static boolean[] visited;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();      // 정점 개수
        int M = scanner.nextInt();      // 간선 개수

        adjacencyListArray = new List[N];
        for (int i = 0; i < adjacencyListArray.length; i++) {
            adjacencyListArray[i] = new LinkedList<>();
        }
        visited = new boolean[N];

        int from, to;
        int connectedComponent = 0;

        for (int i = 0; i < M; i++) {
            from = scanner.nextInt() - 1;
            to = scanner.nextInt() - 1;
            adjacencyListArray[from].add(to);
            adjacencyListArray[to].add(from);
        }

        while (true) {
            int rootNode = getRootNode();
            if (rootNode == -1) {
                break;
            }
            bfs(rootNode);
            connectedComponent++;
        }

        System.out.println(connectedComponent);
    }

    private static void bfs(int rootNode) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootNode);
        visited[rootNode] = true;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            Iterator<Integer> iterator = adjacencyListArray[nowNode].listIterator();
            while (iterator.hasNext()) {
                int nextNode = iterator.next();
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }

    private static int getRootNode() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return -1;
    }
}
