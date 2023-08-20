package practice.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Practice {

    private static List<Integer>[] adjacencyListArray;
    private static boolean[] visited;

    public static void main(String[] args) {

        int N = 8;      // 정점 개수
        int M = 9;      // 간선 개수
        int R = 1;      // 시작 정점

        adjacencyListArray = new List[N];
        visited = new boolean[N];

        for (int i = 0; i < adjacencyListArray.length; i++) {
            adjacencyListArray[i] = new ArrayList<>();
        }

        adjacencyListArray[0].add(1);
        adjacencyListArray[0].add(7);
        adjacencyListArray[0].add(2);
        adjacencyListArray[1].add(0);
        adjacencyListArray[1].add(7);
        adjacencyListArray[1].add(5);
        adjacencyListArray[2].add(0);
        adjacencyListArray[2].add(4);
        adjacencyListArray[3].add(4);
        adjacencyListArray[3].add(6);
        adjacencyListArray[4].add(2);
        adjacencyListArray[4].add(3);
        adjacencyListArray[4].add(6);
        adjacencyListArray[5].add(1);
        adjacencyListArray[6].add(3);
        adjacencyListArray[6].add(4);
        adjacencyListArray[7].add(0);
        adjacencyListArray[7].add(1);

        for (int i = 0; i < adjacencyListArray.length; i++) {
            Collections.sort(adjacencyListArray[i]);
        }

        System.out.println("인접 리스트: ");
        for (int i = 0; i < adjacencyListArray.length; i++) {
            System.out.println(i + ": " + adjacencyListArray[i]);
        }

        int rootNode = R - 1;
//        stackDfs(rootNode);

        System.out.print("인접 리스트 + 재귀를 활용한 DFS: ");
        recursionDfs(rootNode);
    }

    private static void stackDfs(int nodeIndex) {

        Stack<Integer> stack = new Stack<>();
        stack.push(nodeIndex);
        visited[nodeIndex] = true;

        System.out.print("인접 리스트 + 스택을 활용한 DFS: ");

        while (!stack.isEmpty()) {
            int nowNode = stack.pop();
            System.out.print((nowNode + 1) + " ");
            Iterator<Integer> iterator = adjacencyListArray[nowNode].listIterator();
            while (iterator.hasNext()) {
                int nextNode = iterator.next();
                if (!visited[nextNode]) {
                    stack.push(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }

    private static void recursionDfs(int nodeIndex) {

        visited[nodeIndex]=true;
        System.out.print((nodeIndex + 1) + " ");
        for (int i = 0; i < adjacencyListArray[nodeIndex].size(); i++) {
            if (!visited[adjacencyListArray[nodeIndex].get(i)]) {
                recursionDfs(adjacencyListArray[nodeIndex].get(i));
            }
        }
    }
}
