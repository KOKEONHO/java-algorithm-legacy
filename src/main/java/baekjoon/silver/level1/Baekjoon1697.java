package baekjoon.silver.level1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1697 {

    static boolean[] visited = new boolean[200000];
    static LinkedList<Integer>[] nodeListArray = new LinkedList[200000];
    static List<Integer>[] adjacencyListArray = new List[200000];
    static int[] countArray = new int[200000];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());      // 수빈 위치
        int K = Integer.parseInt(stringTokenizer.nextToken());      // 동생 위치

//        if (N >= K) {
//            nodeListArray = new LinkedList[N * 3];
//            visited = new boolean[N * 3];
//            adjacencyListArray = new List[N * 3];
//            countArray = new int[N * 3];
//        } else {
//            nodeListArray = new LinkedList[K * 3];
//            visited = new boolean[K * 3];
//            adjacencyListArray = new List[K * 3];
//            countArray = new int[K * 3];
//        }

//        for (int i = 0; i < nodeListArray.length; i++) {
//            nodeListArray[i] = new LinkedList<>();
//        }

        for (int i = 0; i < adjacencyListArray.length; i++) {
            adjacencyListArray[i] = new LinkedList<>();
            if (i >= 1) {        // -1은 처리 불가능하므로 예외 처리
                adjacencyListArray[i].add(i - 1);
            }
            if (i + 1 < adjacencyListArray.length) {
                adjacencyListArray[i].add(i + 1);
            }
            if (!adjacencyListArray[i].contains(i * 2) && i * 2 > 0 && i * 2 < adjacencyListArray.length) {
                adjacencyListArray[i].add(i * 2);
            }
        }

        int result = bfs(N, K);

//        bw.write(Arrays.toString(result.toArray()));
        bw.write(Integer.toString(result));
        bw.newLine();

//        for (int i = 0; i < adjacencyListArray.length; i++) {
//            bw.write(i + ": ");
//            bw.write(Arrays.toString(adjacencyListArray[i].toArray()));
//            bw.newLine();
//        }

//        for (int i = 0; i < nodeListArray.length; i++) {
//            bw.write(Arrays.toString(nodeListArray[i].toArray()));
//            bw.newLine();
//        }

        bw.flush();
        bw.close();
    }

    static int bfs(int rootNode, int targetNode) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootNode);
        visited[rootNode] = true;
//        nodeListArray[rootNode].add(rootNode);

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            Iterator<Integer> iterator = adjacencyListArray[nowNode].listIterator();
            while (iterator.hasNext()) {
                int nextNode = iterator.next();
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode] = true;
//                    nodeListArray[nextNode] = (LinkedList<Integer>) nodeListArray[nowNode].clone();
//                    nodeListArray[nextNode].add(nextNode);
                    countArray[nextNode] = countArray[nowNode] + 1;
                }
            }
        }

        return countArray[targetNode];
//        return nodeListArray[targetNode];
    }
}
