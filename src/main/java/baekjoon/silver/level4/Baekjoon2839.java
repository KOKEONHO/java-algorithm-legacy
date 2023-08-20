package baekjoon.silver.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2839 {

    private static long[] sugarBags;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sugarBags = new long[N + 1];

        long result = countingSugarBags(N);

        System.out.println(result);
    }

    private static long countingSugarBags(int N) {

        if (N >= 3) {
            sugarBags[3] = 1;
        }
        if (N >= 5) {
            sugarBags[5] = 1;
        }
        for (int i = 6; i <= N; i++) {
            if (i % 5 == 0) {
                sugarBags[i] = sugarBags[i - 5] + 1;
                continue;
            }
            if (i % 3 == 0) {
                sugarBags[i] = sugarBags[i - 3] + 1;
                continue;
            }
            if (sugarBags[i - 3] != 0 && sugarBags[i - 5] != 0) {
                sugarBags[i] = Math.min(sugarBags[i - 3], sugarBags[i - 5]) + 1;
            }
        }

        if (sugarBags[N] == 0) {
            return -1;
        }
        return sugarBags[N];
    }
}
