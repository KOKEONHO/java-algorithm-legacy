package baekjoon.silver.level1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2178 {

    static int N, M;
    static int[][] maze;        // 미로 (2차원 배열)
    static boolean[][] visited;     // 방문 처리 (2차원 배열)
    static int[] moveRow = {-1, 1, 0, 0};       // 행 이동 (상: -1 / 하: +1)
    static int[] moveCol = {0, 0, -1, 1};       // 열 이동 (좌: -1 / 우: +1)

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];
        String mazeLine;

        for (int i = 0; i < N; i++) {
            mazeLine = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Character.getNumericValue(mazeLine.charAt(j));
            }
        }

        bfs(0, 0);

        bw.write(Integer.toString(maze[N - 1][M - 1]));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    private static void bfs(int rootRow, int rootCol) {

        Queue<int[]> queue = new LinkedList<>();
        int[] rootNode = {rootRow, rootCol};
        queue.add(rootNode);
        visited[rootRow][rootCol] = true;

        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();
            int nowRow = nowNode[0];
            int nowCol = nowNode[1];
            for (int i = 0; i < 4; i++) {
                int nextRow = nowRow + moveRow[i];
                int nextCol = nowCol + moveCol[i];
                if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) {
                    continue;
                }
                int[] nextNode = {nextRow, nextCol};
                if (maze[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    queue.add(nextNode);
                    visited[nextRow][nextCol] = true;
                    maze[nextRow][nextCol] = maze[nowRow][nowCol] + 1;
                }
            }

        }
    }
}
