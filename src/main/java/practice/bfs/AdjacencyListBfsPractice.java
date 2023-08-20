package practice.bfs;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class AdjacencyListBfsPractice {

    private static List<Integer>[] adjacencyListArray;
    private static boolean[] visited;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N, M, V;        // N: 정점의 개수 M: 간선의 개수 V: 시작 노드
        int from, to;     // start: 간선의 시작 end: 간선의 끝

        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();

        adjacencyListArray = new LinkedList[N];
        for (int i = 0; i < adjacencyListArray.length; i++) {
            adjacencyListArray[i] = new LinkedList<>();
        }
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            from = scanner.nextInt() - 1;
            to = scanner.nextInt() - 1;
            adjacencyListArray[from].add(to);
            adjacencyListArray[to].add(from);
        }

        // 방문 순서를 위해 오름차순 정렬
        for (int i = 0; i < adjacencyListArray.length; i++) {
            Collections.sort(adjacencyListArray[i]);
        }

        int rootNode = V - 1;
        bfs(rootNode);
    }

    private static void bfs(int rootNode) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootNode);
        visited[rootNode] = true;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();     // queue에서 nowNode를 poll
            System.out.print((nowNode + 1) + " ");
            Iterator<Integer> iterator = adjacencyListArray[nowNode].listIterator();
            while (iterator.hasNext()) {
                int nextNode = iterator.next();     // nextNode
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode]=true;
                }
            }
        }
    }

}
