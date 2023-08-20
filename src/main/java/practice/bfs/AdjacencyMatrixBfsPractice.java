package practice.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjacencyMatrixBfsPractice {

    private static int[][] graph;
    private static boolean[] visited;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N, M, V;        // N: 정점의 개수 M: 간선의 개수 V: 시작 노드
        int start, end;     // start: 간선의 시작 end: 간선의 끝

        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();

        graph = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            start = scanner.nextInt();
            end = scanner.nextInt();
            graph[start - 1][end - 1] = 1;
            graph[end - 1][start - 1] = 1;
        }

        int rootNode = V - 1;
        bfs(rootNode);
    }

    private static void bfs(int nodeIndex) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(nodeIndex);
        visited[nodeIndex]=true;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            System.out.print((nowNode + 1) + " ");
            for (int i = 0; i < graph[nowNode].length; i++) {
                if (graph[nowNode][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
