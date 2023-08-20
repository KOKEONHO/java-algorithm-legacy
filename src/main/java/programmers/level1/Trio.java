package programmers.level1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Trio {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] number = {-3, -2, -1, 0, 1, 2, 3};

        int result = solution(number);

        bw.write(Integer.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static int solution(int[] number) {

        int trioCount = 0;
        int num1, num2, num3;

        for (int i = 0; i < number.length - 2; i++) {
            num1 = number[i];
            for (int j = i + 1; j < number.length - 1; j++) {
                num2 = number[j];
                for (int k = j + 1; k < number.length; k++) {
                    num3 = number[k];
                    if (num1 + num2 + num3 == 0) {
                        trioCount++;
                    }
                }
            }
        }
        return trioCount;
    }
}
