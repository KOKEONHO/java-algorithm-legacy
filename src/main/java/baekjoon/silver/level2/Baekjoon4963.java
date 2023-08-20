package baekjoon.silver.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon4963 {

    public static int w, h;
    public static int[][] territory;
    public static boolean[][] visited;
    public static int[] moveRow = {-1, -1, -1, 0, 0, 1, 1, 1}; // 행 이동: 좌상, 상, 우상, 좌, 우, 좌하, 하, 우하
    public static int[] moveCol = {-1, 0, 1, -1, 1, -1, 0, 1}; // 열 이동: 좌상, 상, 우상, 좌, 우, 좌하, 하, 우하

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            w = Integer.parseInt(stringTokenizer.nextToken());
            h = Integer.parseInt(stringTokenizer.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            territory = new int[h][w]; // 2차원 영역 배열 생성
            visited = new boolean[h][w]; // 2차원 방문 배열 생성

//            System.out.println(h + "행 " + w + "열 2차원 배열");

            for (int i = 0; i < h; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    territory[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (territory[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            bw.write(Integer.toString(count));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void bfs(int rootRow, int rootCol) {

        Queue<int[]> queue = new LinkedList<>();
        int[] rootNode = new int[]{rootRow, rootCol};
        queue.add(rootNode); // 시작 노드 queue에 추가

        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();
//            System.out.println(Arrays.toString(nowNode));
            int nowRow = nowNode[0];
            int nowCol = nowNode[1];
            visited[nowRow][nowCol] = true;
            for (int i = 0; i < moveRow.length; i++) {
                int nextRow = nowRow + moveRow[i];
                int nextCol = nowCol + moveCol[i];
                if (nextRow < 0 || nextRow >= h || nextCol < 0 || nextCol >= w) {
                    continue;
                }
                if (territory[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    queue.add(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }
}
