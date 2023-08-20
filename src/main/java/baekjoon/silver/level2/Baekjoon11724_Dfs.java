package baekjoon.silver.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon11724_Dfs {

    private static int[][] graph;
    private static boolean[] visited;
    private static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());      // 정점의 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());      // 간선의 개수

        graph = new int[N][N];      // 그래프
        visited = new boolean[N];       // 방문 처리 배열

        int u, v;       // u, v: 간선의 양 끝점

        for (int i = 0; i < M; i++) {       // 간선의 개수만큼 반복
            stringTokenizer = new StringTokenizer(br.readLine());
            u = Integer.parseInt(stringTokenizer.nextToken());
            v = Integer.parseInt(stringTokenizer.nextToken());
            graph[u - 1][v - 1] = 1;
            graph[v - 1][u - 1] = 1;
        }

        int rootNode, connectedComponent = 0;

        // 1. 재귀
//        while (true) {
//            rootNode = getRootNode();
//            if (rootNode == -1) {
//                break;
//            }
//            dfsRecursion(rootNode);
//            connectedComponent++;
//        }

        // 2. 스택
        stack = new Stack<>();
        while (true) {
            rootNode = getRootNode();
            if (rootNode == -1) {
                break;
            }
            dfsStack(rootNode);
            connectedComponent++;
        }

        bw.write(Integer.toString(connectedComponent));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    // 1. 재귀 풀이법
    private static void dfsRecursion(int nodeIndex) {

        visited[nodeIndex] = true;
        for (int i = 0; i < graph[nodeIndex].length; i++) {
            if (graph[nodeIndex][i] == 1 && !visited[i]) {
                dfsRecursion(i);
            }
        }
    }

    // 2. 스택 풀이법
    private static void dfsStack(int rootNode) {

        stack.push(rootNode);
        visited[rootNode] = true;
        while (!stack.isEmpty()) {
            int nodeIndex = stack.pop();
            for (int i = 0; i < graph[nodeIndex].length; i++) {
                if (graph[nodeIndex][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
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
