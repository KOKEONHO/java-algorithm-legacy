package practice.dfs;

import java.util.Scanner;

public class RecursionDfsPractice {

    private static int[][] graph;
    private static boolean[] visited;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /**
         * N: 정점 개수
         * M: 간선 개수
         * V: 시작 노드
         */
        int N, M, V;
        int number1, number2;

        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();

        graph = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            number1 = scanner.nextInt();
            number2 = scanner.nextInt();
            graph[number1 - 1][number2 - 1] = 1;
            graph[number2 - 1][number1 - 1] = 1;
        }

        int rootNode = V - 1;

        System.out.print("dfs 시작 >> ");
        dfs(rootNode);
    }

    static void dfs(int nodeIndex) {

        visited[nodeIndex] = true;        // 방문 처리
        System.out.print((nodeIndex + 1) + " ");
        for (int i = 0; i < graph[nodeIndex].length; i++) {
            if (graph[nodeIndex][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

}
