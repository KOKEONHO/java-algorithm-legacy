package baekjoon.silver.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon24479 {

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

        adjacencyListArray = new List[N];       // 인접 리스트 배열 생성
        visited = new boolean[N];       // 방문 처리 배열 초기화
        answer = new int[N];        // 방문 순서를 저장하는 배열 초기화
        for (int i = 0; i < adjacencyListArray.length; i++) {
            adjacencyListArray[i] = new ArrayList<>();
        }       // 인접 리스트 배열 초기화

        int from, to;       // 시작 정점 & 도착 정점
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            from = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            to = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            adjacencyListArray[from].add(to);
            adjacencyListArray[to].add(from);
        }       // 간선의 개수만큼 인접 리스트 배열에 간선 추가

        for (int i = 0; i < adjacencyListArray.length; i++) {
            Collections.sort(adjacencyListArray[i]);
        }

        int rootNode = R - 1;       // 시작 정점 선작업
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
