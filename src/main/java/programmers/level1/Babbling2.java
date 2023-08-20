package programmers.level1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Babbling2 {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        int result = solution(babbling);

        bw.write(Integer.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static int solution(String[] babbling) {

        int result = 0;

        String[] canBabble = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < babbling.length; i++) {
            int canBabbleIndex = -1;     // 같은 발음을 연속해서 할 수 없으므로 마지막으로 한 발음 체크 인덱스
            String word = babbling[i];      // 발음해야 할 단어
            for (int j = 0; j < canBabble.length; j++) {
                if (j == canBabbleIndex) {      // 마지막으로 한 발음이면 continue
                    continue;
                }
                if (word.startsWith(canBabble[j])) {        // 발음해야 할 단어가 canBabble의 원소로 시작 하는지 확인
                    word = word.substring(canBabble[j].length());
                    canBabbleIndex = j;
                    j = -1;
                }
            }
            if (word.equals("")) {
                result++;
            }
        }

        return result;
    }
}
