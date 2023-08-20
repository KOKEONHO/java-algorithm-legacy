package programmers.level1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DeckOfCards {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        String result = solution(cards1, cards2, goal);

        bw.write(result);
        bw.newLine();

        bw.flush();
        bw.close();
    }

    static String solution(String[] cards1, String[] cards2, String[] goal) {

        String word;
        int cards1Index = 0, cards2Index = 0;
        boolean resultFlag = true;

        for (int i = 0; i < goal.length; i++) {
            word = goal[i];
            if (cards1Index < cards1.length) {
                if (cards1[cards1Index].equals(word)) {
                    cards1Index++;
                    continue;
                }
            }
            if (cards2Index < cards2.length) {
                if (cards2[cards2Index].equals(word)) {
                    cards2Index++;
                    continue;
                }
            }
            resultFlag = false;
            break;
        }

        if (resultFlag) {
            return "Yes";
        }
        return "No";
    }
}
