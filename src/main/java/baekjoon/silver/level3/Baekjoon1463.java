package baekjoon.silver.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon1463 {

    private static long[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());

        array = new long[X + 1];

        long result = dynamicProgramming(X);

        bw.write(Long.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    private static long dynamicProgramming(int X) {

        array[1] = 0;
        if (array.length > 2) {
            for (int i = 2; i < array.length; i++) {
                if (i % 2 == 0 || i % 3 == 0) {
                    if (i % 2 == 0) {
                        array[i] = Math.min(array[i / 2], array[i - 1]) + 1;
                    }
                    if (i % 3 == 0) {
                        array[i] = Math.min(array[i / 3], array[i - 1]) + 1;
                    }
                    if (i % 2 == 0 && i % 3 == 0) {
                        array[i] = Math.min(Math.min(array[i / 2], array[i / 3]), array[i - 1]) + 1;
                    }
                } else {
                    array[i] = array[i - 1] + 1;
                }
            }
        }

        return array[X];
    }
}
