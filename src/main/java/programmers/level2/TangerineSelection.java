package programmers.level2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TangerineSelection {
    public static void main(String[] args) {

        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        int result = solution(k, tangerine);

        System.out.println(result);
    }

    static int solution(int k, int[] tangerine) {

        int answer = 0;

        Map<Integer, Integer> tangerineMap = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            tangerineMap.put(tangerine[i], tangerineMap.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(tangerineMap.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        for (int i = entryList.size() - 1; i >= 0; i--) {
            k -= entryList.get(i).getValue();
            if (k <= 0) {
                answer++;
                break;
            }
            answer++;
        }

        return answer;
    }
}
