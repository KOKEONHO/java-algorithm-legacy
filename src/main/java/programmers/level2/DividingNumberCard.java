package programmers.level2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class DividingNumberCard {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arrayA = {5};
        int[] arrayB = {5, 17};

        int result = solution(arrayA, arrayB);

        bw.write(Integer.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static int solution(int[] arrayA, int[] arrayB) {

        int gcdA, gcdB;
        if (arrayA.length == 1) {
            gcdA = arrayA[0];
        } else {
            Arrays.sort(arrayA);
            gcdA = getGcd(arrayA[0], arrayA[1]);
            for (int i = 2; i < arrayA.length; i++) {
                if (arrayA[i] % gcdA == 0) {
                    continue;
                }
                gcdA = getGcd(arrayA[i], gcdA);
            }
        }

        for (int i = 0; i < arrayB.length; i++) {
            if (arrayB[i] % gcdA != 0) {
                continue;
            }
            gcdA = 0;
            break;
        }

        if (arrayB.length == 1) {
            gcdB = arrayB[0];
        } else {
            Arrays.sort(arrayB);
            gcdB = getGcd(arrayB[0], arrayB[1]);
            for (int i = 2; i < arrayB.length; i++) {
                if (arrayB[i] % gcdB == 0) {
                    continue;
                }
                gcdB = getGcd(arrayB[i], gcdB);
            }
        }

        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] % gcdB != 0) {
                continue;
            }
            gcdB = 0;
            break;
        }

        if (gcdA > gcdB) {
            return gcdA;
        }
        if (gcdA < gcdB) {
            return gcdB;
        }
        return gcdA;
    }

    public static int getGcd(int number1, int number2) {
        int result = number1 % number2;
        if (result == 0) {
            return number2;
        }
        return getGcd(number2, result);
    }
}
