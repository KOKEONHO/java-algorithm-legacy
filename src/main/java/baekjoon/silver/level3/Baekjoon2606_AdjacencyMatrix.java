package baekjoon.silver.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2606_AdjacencyMatrix {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        int computerCount = Integer.parseInt(br.readLine());
        int trunkLineCount = Integer.parseInt(br.readLine());
        int num1, num2;

        int[][] network = new int[computerCount][computerCount];
        boolean[] visited = new boolean[computerCount];

        for (int i = 0; i < trunkLineCount; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            num1 = Integer.parseInt(stringTokenizer.nextToken());
            num2 = Integer.parseInt(stringTokenizer.nextToken());
            network[num1 - 1][num2 - 1] = 1;
            network[num2 - 1][num1 - 1] = 1;
        }

//        for (int i = 0; i < network.length; i++) {
//            bw.write(Arrays.toString(network[i]));
//            bw.newLine();
//        }

        int result = bfs(0, network, visited);

        bw.write(Integer.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static int bfs(int nodeIndex, int[][] network, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(nodeIndex);
        visited[nodeIndex] = true;
        int count = -1;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            count++;
            for (int i = 0; i < network[nowNode].length; i++) {
                if (network[nowNode][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        return count;
    }
}
