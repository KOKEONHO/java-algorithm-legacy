package baekjoon.silver.level1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2468 {

    public static int N;
    public static int maxHeight = Integer.MIN_VALUE;
    public static int maxSafeArea = Integer.MIN_VALUE;
    public static int safeAreaCount;
    public static int comparisonHeight;
    public static int[][] territory;
    public static boolean[][] visited;
    public static int[] moveRow = {-1, 1, 0, 0}; // 행 이동: 상, 하
    public static int[] moveCol = {0, 0, -1, 1}; // 열 이동: 좌, 우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        territory = new int[N][N];
        StringTokenizer stringTokenizer;

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                territory[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (territory[i][j] > maxHeight) {
                    maxHeight = territory[i][j];
                }
            }
        } // 2차원 배열 territory 생성

        for (int i = 0; i < maxHeight; i++) {
            comparisonHeight = i; // 기준 높이
            visited = new boolean[N][N];
            safeAreaCount = 0;
            for (int j = 0; j < territory.length; j++) {
                for (int k = 0; k < territory[j].length; k++) {
                    if (territory[j][k]>comparisonHeight && !visited[j][k]) {
                        bfs(j, k);
                        safeAreaCount++;
                    }
                }
            }
            if (safeAreaCount > maxSafeArea) {
                maxSafeArea = safeAreaCount;
            }
        }

        bw.write(Integer.toString(maxSafeArea));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static void bfs(int rootRow, int rootCol) {

        Queue<int[]> queue = new LinkedList<>();
        int[] rootNode = new int[]{rootRow, rootCol};
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();
            int nowRow = nowNode[0];
            int nowCol = nowNode[1];
            visited[nowRow][nowCol] = true;
            for (int i = 0; i < moveRow.length; i++) {
                int nextRow = nowRow + moveRow[i];
                int nextCol = nowCol + moveCol[i];
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
                    continue;
                }
                if (territory[nextRow][nextCol] > comparisonHeight && !visited[nextRow][nextCol]) {
                    queue.add(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }
}
