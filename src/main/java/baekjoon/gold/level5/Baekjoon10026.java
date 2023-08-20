package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon10026 {

    public static int N;
    public static char[][] grid;
    public static boolean[][] visited;
    public static char color;
    public static int[] moveRow = {-1, 1, 0, 0}; // 행 이동: 상, 하
    public static int[] moveCol = {0, 0, -1, 1}; // 열 이동: 좌, 우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < grid.length; i++) {
            String gridLine = br.readLine();
            for (int j = 0; j < gridLine.length(); j++) {
                grid[i][j] = gridLine.charAt(j);
            }
        }

        int normalCount = 0, abnormalCount = 0;

        // 정상인의 시야: R, G, B 다 구별 가능
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j]) {
                    color = grid[i][j];
                    normalBfs(i, j);
                    normalCount++;
                }
            }
        }

        visited = new boolean[N][N];
        // 적록색약의 시야
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j]) {
                    color = grid[i][j];
                    abnormalBfs(i, j);
                    abnormalCount++;
                }
            }
        }


        bw.write(normalCount + " " + abnormalCount);
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static void normalBfs(int rootRow, int rootCol) {

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
                if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) {
                    continue;
                }
                if (grid[nextRow][nextCol] == color && !visited[nextRow][nextCol]) {
                    queue.add(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }

    public static void abnormalBfs(int rootRow, int rootCol) {

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
                if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) {
                    continue;
                }
                if (color == 'R' || color == 'G') { // 만약 초록 or 빨강일 경우
                    if (grid[nextRow][nextCol] != 'B' && !visited[nextRow][nextCol]) {
                        queue.add(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
                if (color == 'B') { // 파랑일 경우
                    if (grid[nextRow][nextCol] == color && !visited[nextRow][nextCol]) {
                        queue.add(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
    }
}
