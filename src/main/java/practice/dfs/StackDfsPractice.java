package practice.dfs;

import java.util.Scanner;
import java.util.Stack;

public class StackDfsPractice {

    private static int[][] graph;
    private static boolean[] visited;
    private static boolean[] fullVisited;
    private static Stack<Integer> stack;

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
        fullVisited = new boolean[visited.length];
        for (int i = 0; i < fullVisited.length; i++) {
            fullVisited[i] = true;
        }

        for (int i = 0; i < M; i++) {
            number1 = scanner.nextInt();
            number2 = scanner.nextInt();
            graph[number1 - 1][number2 - 1] = 1;
            graph[number2 - 1][number1 - 1] = 1;
        }

        stack = new Stack<>();
        int rootNode = V - 1;
        dfs(rootNode);
    }

    private static void dfs(int rootNode) {
        boolean flag;
        stack.push(rootNode);
        visited[rootNode]=true;
        while (!stack.isEmpty()) {
            int nodeIndex = stack.pop();
            System.out.print((nodeIndex + 1) + " ");
            flag = checkEnd();
            if(!flag) {
                System.out.print("-> ");
            }
            for (int i = 0; i < graph[nodeIndex].length; i++) {
                if (graph[nodeIndex][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static boolean checkEnd() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
