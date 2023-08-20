package programmers.level2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compression {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        int[] answer = solution(msg);

        bw.write(Arrays.toString(answer));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    static int[] solution(String msg) {

        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> indexList = new ArrayList<>();
        String shortString = "";
        int count = 1;
        boolean flag = false;

        for (int i = 'A'; i <= 'Z'; i++) {
            dictionary.put(String.valueOf((char) i), count);
            count++;
        }

        for (int i = 0; i < msg.length(); i++) {
            flag = false;
            for (int j = i + 1; j <= msg.length(); j++) {
                shortString = msg.substring(i, j);
                if (dictionary.containsKey(shortString)) {
                    continue;
                }
                dictionary.put(shortString, count);
                count++;
                indexList.add(dictionary.get(msg.substring(i, j - 1)));
                i += shortString.length() - 2;
                flag = true;
                break;
            }
            if (!flag) {
                indexList.add(dictionary.get(msg.substring(i, msg.length())));
                break;
            }
        }

        int[] result = new int[indexList.size()];
        for (int i = 0; i < indexList.size(); i++) {
            result[i] = indexList.get(i);
        }

        return result;
    }
}
