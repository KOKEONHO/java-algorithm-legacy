package baekjoon.gold.level4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M; // 행, 열
    static int[][] lab;
    static boolean[][] contaminated;
    static int[] moveRow = {-1, 1, 0, 0};
    static int[] moveCol = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken()); // 연구소의 세로 크기 (행)
        M = Integer.parseInt(stringTokenizer.nextToken()); // 연구소의 가로 크기 (열)
        lab = new int[N][M];
        contaminated = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (lab[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            bw.write(Arrays.toString(lab[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();
            int nowRow = nowNode[0];
            int nowCol = nowNode[1];
            contaminated[nowRow][nowCol] = true;
            for (int i = 0; i < 4; i++) {
                int nextRow = nowRow + moveRow[i];
                int nextCol = nowCol + moveCol[i];
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                    continue;
                }
                if (lab[nextRow][nextCol] == 0 && !contaminated[nextRow][nextCol]) {
                    lab[nextRow][nextCol] = lab[nowRow][nowCol];
                    queue.add(new int[]{nextRow, nextCol});
                    contaminated[nextRow][nextCol] = true;
                }
            }
        }
    }
}
