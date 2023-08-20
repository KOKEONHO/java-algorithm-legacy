package programmers.level2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class StockPrice {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] prices = {1, 2, 3, 2, 3};

        int[] result = solution(prices);

        bw.write(Arrays.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] prices) {
        int count;
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            count = 0;
            int price = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (price > prices[j]) {
                    count++;
                    break;
                }
                count++;
            }
            answer[i] = count;
        }
        return answer;
    }
}

