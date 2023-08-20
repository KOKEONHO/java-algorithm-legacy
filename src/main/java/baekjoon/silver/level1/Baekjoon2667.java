package baekjoon.silver.level1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baekjoon2667 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String mapString;

        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        int[] moveRow = {-1, 1, 0, 0};
        int[] moveCol = {0, 0, -1, 1};
        int complexCount = 0;
        List<Integer> houseCountList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            mapString = br.readLine();
            for (int j = 0; j < mapString.length(); j++) {
                map[i][j] = Character.getNumericValue(mapString.charAt(j));
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int[] rootNode = {i, j};
                    houseCountList.add(bfs(rootNode, map, visited, moveRow, moveCol));
                    complexCount++;
                }
            }
        }

        bw.write(Integer.toString(complexCount));
        bw.newLine();

        Collections.sort(houseCountList);

        for (int i = 0; i < houseCountList.size(); i++) {
            bw.write(Integer.toString(houseCountList.get(i)));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static int bfs(int[] rootNode, int[][] map, boolean[][] visited, int[] moveRow, int[] moveCol) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(rootNode);
        visited[rootNode[0]][rootNode[1]] = true;
        int houseCount = 0;

        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();
            int nowRow = nowNode[0];
            int nowCol = nowNode[1];
            houseCount++;
            for (int i = 0; i < moveRow.length; i++) {
                int nextRow = nowRow + moveRow[i];
                int nextCol = nowCol + moveCol[i];
                if (nextRow < 0 || nextCol < 0 || nextRow >= map.length || nextCol >= map[nowRow].length) {
                    continue;
                }
                int[] nextNode = {nextRow, nextCol};
                if (map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    queue.add(nextNode);
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return houseCount;
    }
}
