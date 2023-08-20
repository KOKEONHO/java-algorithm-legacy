package baekjoon.silver.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer;
        int N, M, K;
        int[][] ground;
        int num1, num2;
        boolean[][] visited;
        int[] moveRow = {-1, 1, 0, 0};
        int[] moveCol = {0, 0, -1, 1};

        for (int i = 0; i < T; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            M = Integer.parseInt(stringTokenizer.nextToken());
            N = Integer.parseInt(stringTokenizer.nextToken());
            K = Integer.parseInt(stringTokenizer.nextToken());
            ground = new int[N][M];
            visited = new boolean[N][M];
            int wormCount = 0;

            for (int j = 0; j < K; j++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                num1 = Integer.parseInt(stringTokenizer.nextToken());
                num2 = Integer.parseInt(stringTokenizer.nextToken());
                ground[num2][num1] = 1;
            }       // 농지 생성 완료

            for (int j = 0; j < ground.length; j++) {
                for (int k = 0; k < ground[j].length; k++) {
                    if (ground[j][k] == 1 && !visited[j][k]) {
                        int[] rootNode = {j, k};
                        bfs(rootNode, ground, visited, moveRow, moveCol);
                        wormCount++;
                    }
                }
            }

            bw.write(Integer.toString(wormCount));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static void bfs(int[] rootNode, int[][] ground, boolean[][] visited, int[] moveRow, int[] moveCol) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(rootNode);
        visited[rootNode[0]][rootNode[1]] = true;

        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();
            int nowRow = nowNode[0];
            int nowCol = nowNode[1];
            for (int i = 0; i < moveRow.length; i++) {
                int nextRow = nowRow + moveRow[i];
                int nextCol = nowCol + moveCol[i];
                if (nextRow < 0 || nextCol < 0 || nextRow >= ground.length || nextCol >= ground[nextRow].length) {
                    continue;
                }
                int[] nextNode = {nextRow, nextCol};
                if (ground[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    queue.add(nextNode);
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }
}
