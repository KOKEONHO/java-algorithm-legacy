package baekjoon.silver.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1260_AdjacencyMatrix {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M, V;        // N: 정점 개수 M: 간선 개수 V: 시작 정점 번호
        int num1, num2;

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        V = Integer.parseInt(stringTokenizer.nextToken());

        int[][] graph = new int[N][N];
        boolean[] visited;

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            num1 = Integer.parseInt(stringTokenizer.nextToken());
            num2 = Integer.parseInt(stringTokenizer.nextToken());
            graph[num1 - 1][num2 - 1] = 1;
            graph[num2 - 1][num1 - 1] = 1;
        }

        int rootNode = V - 1;       // 시작 정점

        visited = new boolean[N];

        dfs(rootNode, graph, visited);

        System.out.println();

        visited = new boolean[N];

        bfs(rootNode, graph, visited);
    }

    static void dfs(int nodeIndex, int[][] graph, boolean[] visited) {

        visited[nodeIndex] = true;
        System.out.print((nodeIndex + 1) + " ");
        for (int i = 0; i < graph[nodeIndex].length; i++) {
            if (graph[nodeIndex][i] == 1 && !visited[i]) {
                dfs(i, graph, visited);
            }
        }
    }

    static void bfs(int nodeIndex, int[][] graph, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(nodeIndex);
        visited[nodeIndex] = true;

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
