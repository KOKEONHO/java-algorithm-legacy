package programmers.level2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsClustering {

    public static Map<String, Integer> smallerMap, biggerMap;
    public static Map<String, Integer> str1Tokens, str2Tokens;
    public static int intersection = 0, union = 0;

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = "e=m*c^2";
        String str2 = "e=m*c^2";

        int result = solution(str1, str2);

//        bw.write(str1Tokens.toString());
//        bw.newLine();
//        bw.write(str2Tokens.toString());
//        bw.newLine();
//
//        bw.write("교집합: " + intersection);
//        bw.newLine();
//        bw.write("합집합: " + union);
//        bw.newLine();

        bw.write(Integer.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static int solution(String str1, String str2) {

        int result;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 영문자로 된 글자 쌍만 유효 -> 2자 씩 잘라서 리스트로 반환
        str1Tokens = splitString(str1);
        str2Tokens = splitString(str2);

        if (str1Tokens.isEmpty() && str2Tokens.isEmpty()) {     // 두 맵 중 하나라도 비어있을 경우 교집합은 공집합이 되므로 확정적으로 1 반환
            result = 1;
            return result * 65536;
        }

        getSmallerBiggerMap(str1Tokens, str2Tokens);
        getIntersectionAndUnion();

        double temporary = (double) intersection / union * 65536;
        result = (int) temporary;

        return result;
    }

    public static void getIntersectionAndUnion() {
        Set<Map.Entry<String, Integer>> smallerEntrySet = smallerMap.entrySet();
        Iterator<Map.Entry<String, Integer>> smallerIterator = smallerEntrySet.iterator();
        while (smallerIterator.hasNext()) {
            Map.Entry<String, Integer> entry = smallerIterator.next();
            if (biggerMap.containsKey(entry.getKey())) {
                if (entry.getValue() <= biggerMap.get(entry.getKey())) {
                    intersection += entry.getValue();
                    union += biggerMap.get(entry.getKey());
                    continue;
                }
                intersection += biggerMap.get(entry.getKey());
                union += entry.getValue();
                continue;
            }
            union += entry.getValue();
        }

        Set<Map.Entry<String, Integer>> biggerEntrySet = biggerMap.entrySet();
        Iterator<Map.Entry<String, Integer>> biggerIterator = biggerEntrySet.iterator();
        while (biggerIterator.hasNext()) {
            Map.Entry<String, Integer> entry = biggerIterator.next();
            if (smallerMap.containsKey(entry.getKey())) {
                continue;
            }
            union += entry.getValue();
        }
    }

    public static void getSmallerBiggerMap(Map<String, Integer> str1Tokens, Map<String, Integer> str2Tokens) {
        if (str1Tokens.size() <= str2Tokens.size()) {
            smallerMap = str1Tokens;
            biggerMap = str2Tokens;
            return;
        }
        smallerMap = str2Tokens;
        biggerMap = str1Tokens;
    }


    public static Map<String, Integer> splitString(String string) {

        Pattern pattern = Pattern.compile("[^a-z]");
        Matcher matcher;

        Map<String, Integer> tokens = new HashMap<>();
        String temporary;
        for (int i = 0; i < string.length() - 1; i++) {
            temporary = string.substring(i, i + 2);
            matcher = pattern.matcher(temporary);
            if (matcher.find()) {
                continue;
            }
            tokens.put(temporary, tokens.getOrDefault(temporary, 0) + 1);
        }

        return tokens;
    }
}
