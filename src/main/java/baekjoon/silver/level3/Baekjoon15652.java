package baekjoon.silver.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon15652 {

    private static int N, M;
    private static int[] array;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[M];

        dfs(0, 0);

        bw.write(stringBuilder.toString());
        bw.newLine();

        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int start) {

        if (depth == M) {
            for (int i = 0; i < array.length; i++) {
                stringBuilder.append(array[i] + " ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            array[depth] = i + 1;
            dfs(depth + 1, i);
        }
    }
}
