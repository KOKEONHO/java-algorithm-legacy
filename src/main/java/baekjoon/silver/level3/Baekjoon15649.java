package baekjoon.silver.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15649 {

    private static int[] array;
    private static boolean[] visited;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[M];
        visited = new boolean[N];

        dfs(0, N, M);

        System.out.println(stringBuilder);
    }

    private static void dfs(int depth, int N, int M) {

        if (depth == M) {
            for (int i = 0; i < array.length; i++) {
                stringBuilder.append(array[i]).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i]=true;
                array[depth] = i + 1;
                dfs(depth + 1, N, M);
                visited[i] = false;
            }
        }
    }
}
