package baekjoon.silver.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon24480 {

    private static List<Integer>[] adjacencyListArray;
    private static boolean[] visited;
    private static int[] answer;
    private static int sequence = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());      // 정점 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());      // 간선 개수
        int R = Integer.parseInt(stringTokenizer.nextToken());      // 시작 정점

        adjacencyListArray = new List[N];
        for (int i = 0; i < adjacencyListArray.length; i++) {
            adjacencyListArray[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        answer = new int[N];

        int from, to;
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            from = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            to = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            adjacencyListArray[from].add(to);
            adjacencyListArray[to].add(from);
        }

        for (int i = 0; i < adjacencyListArray.length; i++) {
            Collections.sort(adjacencyListArray[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }       // 내림차순 정렬

        int rootNode = R - 1;
        dfs(rootNode);

        for (int i = 0; i < answer.length; i++) {
            bw.write(Integer.toString(answer[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int nodeIndex) {

        answer[nodeIndex] = ++sequence;
        visited[nodeIndex] = true;
        Iterator<Integer> iterator = adjacencyListArray[nodeIndex].listIterator();
        while (iterator.hasNext()) {
            int nextNode = iterator.next();
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }
}
