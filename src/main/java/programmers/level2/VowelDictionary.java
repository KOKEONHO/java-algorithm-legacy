package programmers.level2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VowelDictionary {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = "EIO";
        int result = solution(word);

        bw.write(Integer.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    static int solution(String word) {

        List<String> dictionary = new ArrayList<>();
        String[] vowelArray = {"A", "E", "I", "O", "U"};
        int vowelSize = vowelArray.length;
        int answer = 1, maxLength = 5;

        for (int i = 1; i <= maxLength; i++) {
            String[] rePerm = new String[i];
            for (int j = 0; j < vowelSize; j++) {
                rePerm[0] = vowelArray[j];
                rePermutation(dictionary, vowelArray, rePerm, 1, i, vowelSize);
            }
        }

        Collections.sort(dictionary);

        for (int i = 0; i < dictionary.size(); i++) {
            if (word.equals(dictionary.get(i))) {
                break;
            }
            answer++;
        }

        return answer;
    }

    static void rePermutation(List<String> dictionary, String[] vowelArray, String[] rePerm, int index, int stringLength, int vowelSize) {
        if (index == stringLength) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String i : rePerm) {
                stringBuilder.append(i);
            }
            dictionary.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < vowelSize; i++) {
            rePerm[index] = vowelArray[i];
            rePermutation(dictionary, vowelArray, rePerm, index + 1, stringLength, vowelSize);
        }
    }
}
