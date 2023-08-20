package baekjoon.silver.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1260_AdjacencyList {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int V = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        int from, to;

        List<Integer>[] adjacencyListArray = new LinkedList[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < adjacencyListArray.length; i++) {
            adjacencyListArray[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            from = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            to = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            adjacencyListArray[from].add(to);
            adjacencyListArray[to].add(from);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(adjacencyListArray[i]);
        }

        bfs(V, adjacencyListArray, visited);
    }

    static void bfs(int rootNode, List<Integer>[] adjacencyListArray, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootNode);
        visited[rootNode] = true;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            System.out.print((nowNode + 1) + " ");
            Iterator<Integer> iterator = adjacencyListArray[nowNode].listIterator();
            while (iterator.hasNext()) {
                int nextNode = iterator.next();
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }
}
