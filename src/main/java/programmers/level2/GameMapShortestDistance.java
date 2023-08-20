package programmers.level2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        int result = solution(maps);

        bw.write(Integer.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static int solution(int[][] maps) {

        int N = maps.length;
        int M = maps[0].length;
        boolean[][] visited = new boolean[N][M];
        int[] moveRow = {-1, 1, 0, 0};
        int[] moveCol = {0, 0, -1, 1};

        return bfs(maps, N, M, visited, moveRow, moveCol);
    }

    public static int bfs(int[][] maps, int N, int M, boolean[][] visited, int[] moveRow, int[] moveCol) {

        Queue<int[]> queue = new LinkedList<>();
        int[] rootNode = {0, 0};
        queue.add(rootNode);
        visited[rootNode[0]][rootNode[1]] = true;

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
                if (maps[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    queue.add(nextNode);
                    visited[nextRow][nextCol] = true;
                    maps[nextRow][nextCol] = maps[nowRow][nowCol] + 1;
                }
            }
        }

        if (maps[N - 1][M - 1] <= 1) {
            return -1;
        }
        return maps[N - 1][M - 1];
    }
}
