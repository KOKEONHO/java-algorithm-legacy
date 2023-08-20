package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576 {

    static int N, M;
    static int[][] tomatoBox;
    static int[] moveRow = {-1, 1, 0, 0};
    static int[] moveCol = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        M = Integer.parseInt(stringTokenizer.nextToken()); // 열
        N = Integer.parseInt(stringTokenizer.nextToken()); // 행

        tomatoBox = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoBox[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoBox[i][j] == 1) {
                    /**
                     * 익은 토마토(1)라면 바로 queue에 add
                     * 이 문제를 푸는 로직은 한번에 queue에다가 시작 지점을 저장한 뒤에 bfs 실행
                     */
                    queue.add(new int[]{i, j});
                }
            }
        }

        int answer = 0;
        boolean checkZeroFLag;

        if (queue.isEmpty()) { // queue에 아무 값도 담기지 않았을 때
            checkZeroFLag = checkZero();
            if (!checkZeroFLag) {
                answer = -1;
            }
        } else {
            answer = bfs();
            checkZeroFLag = checkZero();
            if (!checkZeroFLag) {
                answer = -1;
            }
        }

        bw.write(Integer.toString(answer));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static int bfs() {

        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();
            int nowRow = nowNode[0];
            int nowCol = nowNode[1];
            for (int i = 0; i < 4; i++) {
                int nextRow = nowRow + moveRow[i];
                int nextCol = nowCol + moveCol[i];
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                    continue;
                }
                if (tomatoBox[nextRow][nextCol] == 0) {
                    tomatoBox[nextRow][nextCol] = tomatoBox[nowRow][nowCol] + 1;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }

        int maxDays = Integer.MIN_VALUE;
        for (int i = 0; i < tomatoBox.length; i++) {
            for (int j = 0; j < tomatoBox[i].length; j++) {
                if (tomatoBox[i][j] > maxDays) {
                    maxDays = tomatoBox[i][j];
                }
            }
        }

        return maxDays - 1;
    }

    public static boolean checkZero() {
        for (int i = 0; i < tomatoBox.length; i++) {
            for (int j = 0; j < tomatoBox[i].length; j++) {
                if (tomatoBox[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
