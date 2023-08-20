package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MemoryScore {
    public static void main(String[] args) {

        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        int[] answer = solution(name, yearning, photo);

        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {

        /**
         * 사진 속에 나오는 인물의 그리움 점수를 모두 합산한 값 = 해당 사진의 추억 점수
         *
         * name = {"may", "kein", "kain", "radi"}
         * yearning = {5, 10, 1, 3}
         * photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}}
         */

        int[] answer = new int[photo.length];       // 그룹 수만큼 배열 생성

        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            hashMap.put(name[i], yearning[i]);
        }       // 인물의 이름과 추억 점수를 매핑

        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (hashMap.get(photo[i][j]) == null) {
                    continue;
                }
                score += hashMap.get(photo[i][j]);
            }
            answer[i] = score;
        }

        return answer;
    }
}
