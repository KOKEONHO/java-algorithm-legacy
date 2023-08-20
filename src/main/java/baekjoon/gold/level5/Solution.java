package baekjoon.gold.level5;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[][] graph;
    static boolean[][] visited;
    static int[] destination;
    static int[] moveRow = {-1, 1, 0, 0, -1, 1}; // 행 이동: 상, 하, 좌상, 우하
    static int[] moveCol = {0, 0, -1, 1, -1, 1}; // 열 이동: 좌, 우, 좌상, 우하

    public static void main(String[] args) {

        int width = 2;
        int height = 2;
        int[][] diagonals = {{1, 1}, {2, 2}};

        int result = solution(width, height, diagonals);
        System.out.println(result);
    }

    static int solution(int width, int height, int[][] diagonals) {

        graph = new int[height + 1][width + 1];
        visited = new boolean[height + 1][width + 1];
        destination = new int[]{0, width};

        for (int i = 0; i < diagonals.length; i++) {
            int[] temp = new int[2];
            // 1. 순서 바꾸고
            temp[0] = diagonals[i][1];
            temp[1] = diagonals[i][0];
            // 2. 행 -2
            temp[0] = 2 - temp[0];
            // 3. 행+1 , 열-1
            graph[temp[0]][temp[1] - 1] = 1;
            graph[temp[0] + 1][temp[1]] = 1;
        }

        return bfs(2, 0);
    }

    static int bfs(int rootRow, int rootCol) {

        Queue<int[]> queue = new LinkedList<>();
        int[] rootNode = {rootRow, rootCol};
        queue.add(rootNode);
        visited[rootRow][rootCol] = true;
        int answer = 0;
        boolean flag = false;

        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();
            int nowRow = nowNode[0];
            int nowCol = nowNode[1];
            if (nowRow == destination[0] && nowCol == destination[1]) {
                answer++;
            }
            if (graph[nowRow][nowCol] == 1 && !flag) { // 대각선이 연결돼있을 경우
                for (int i = 0; i < 6; i++) {
                    int nextRow = nowRow + moveRow[i];
                    int nextCol = nowRow + moveCol[i];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= graph.length || nextCol >= graph[0].length) {
                        continue;
                    }
                    if (i < 4) {
                        int[] nextNode = {nextRow, nextCol};
                        if (!visited[nextRow][nextCol]) {
                            queue.add(nextNode);
                            visited[nextRow][nextCol]=true;
                        }
                    } else {
                        int[] nextNode = {nextRow, nextCol};
                        if(!visited[nextRow][nextCol]) {
                            queue.add(nextNode);
                            visited[nextRow][nextCol]=true;
                            flag = true;
                        }
                    }
                }
            } else { // 대각선이 연결돼있지 않을 경우
                for (int i = 0; i < 4; i++) {
                    int nextRow = nowRow + moveRow[i];
                    int nextCol = nowCol + moveCol[i];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= graph.length || nextCol >= graph[0].length) {
                        continue;
                    }
                    int[] nextNode = {nextRow, nextCol};
                    if (!visited[nextRow][nextCol]) {
                        queue.add(nextNode);
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }

        return answer;
    }
}
