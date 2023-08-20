package practice.permutation;

import java.util.Arrays;

public class Main {
    private static int N, M;
    private static int[] array;
    private static boolean[] visited;

    public static void main(String[] args) {

        N = 4;
        M = 2;

        array = new int[M];
        visited = new boolean[N];
        System.out.println("-- 순열 --");
        permutation(0);
        System.out.println();
        System.out.println("-- 중복 순열 --");
        repeatedPermutation(0);
        System.out.println();
        System.out.println("-- 조합 --");
        combination(0, 0);
        System.out.println();
    }

    // 순열
    private static void permutation(int count) {

        if (count == M) {
            System.out.println(Arrays.toString(array));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[count] = i + 1;
                permutation(count + 1);
                visited[i] = false;
            }
        }
    }

    // 중복 순열 - 중복 제거하는 visited를 쓰지 않음
    private static void repeatedPermutation(int count) {
        if (count == M) {
            System.out.println(Arrays.toString(array));
            return;
        }
        for (int i = 0; i < N; i++) {
            array[count] = i + 1;
            repeatedPermutation(count + 1);
        }
    }

    // 조합
    private static void combination(int count, int start) {
        if (count == M) {
            System.out.println(Arrays.toString(array));
            return;
        }
        for (int i = start; i < N; i++) {
            array[count] = i + 1;
            combination(count + 1, i + 1);
        }
    }
}
