package programmers.level1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FoodFightCompetition {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] food = {1, 7, 1, 2};
        String result = solution(food);

        bw.write(result);
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static String solution(int[] food) {

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                result.append(i);
            }
        }
        String temp = result.toString();
        result.append(0);
        for (int i = temp.length() - 1; i >= 0; i--) {
            result.append(temp.charAt(i));
        }

        return result.toString();
    }
}
